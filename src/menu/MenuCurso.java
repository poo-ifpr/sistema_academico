package menu;

import java.util.List;

import dao.CursoDAO;
import dao.MateriaDAO;
import model.Aluno;
import model.Curso;
import model.Materia;
import model.Modalidade;
import util.Console;

public class MenuCurso implements Menu {

	@Override
	public void executar() {
		int opcao = escolheOpcao();
		switch(opcao){
		
		case 1:
			inserirCurso();
			break;
		case 2:
			buscarCurso();
			break;
		case 3:
			alterarCurso();
			break;
		case 4:
			removerCurso();
			break;
		case 5:
			listarMateriasPorNome();
			break;
		default:
			break;
		}
	}
	
	private void listarMateriasPorNome() {
		Curso curso = getCurso();
		MateriaDAO materiaDAO = new MateriaDAO();
		String nomeMateria = Console.
				lerStringObrigatoria("Digite parte do nome da Matéria");
		List<Materia> materias = materiaDAO.buscarPorCursoPorNome(curso, nomeMateria);
		Console.mensagem("Foram encontrados (" + materias.size() +") matérias");
		int i = 0;
		for(Materia materia: materias){
			i++;
			Console.mensagem(materia.toString());
		}
	}

	private void removerCurso() {
		CursoDAO cursoDAO = new CursoDAO();
		Curso curso = buscarCursoPorId();
		if(curso == null){
			Console.mensagem("Nenhum curso foi encontrado");
			return;
		}
		cursoDAO.remover(curso);
	}

	private void alterarCurso() {
		CursoDAO cursoDAO = new CursoDAO();
		Curso curso = buscarCursoPorId();
		if(curso == null){
			Console.mensagem("Nenhum curso foi encontrado");
			return;
		}
		Console.mensagem("Curso escolhido: " + curso);
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = getModalidade();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		cursoDAO.alterar(curso);
	}

	private void buscarCurso() {
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
		Console.mensagem("Foram encontrados (" + cursos.size() +") cursos");
		for(Curso curso : cursos){
			Console.mensagem(curso.toString());
		}
	}
	
	private Curso buscarCursoPorId(){
		Long id_curso = new Long(Console.lerNumeroObrigatorio("Digite o id do curso"));
		CursoDAO cursoDAO = new CursoDAO();
		return cursoDAO.buscarPorId(id_curso);

	}

	//Reutilizado em MenuMatéria
	public Curso inserirCurso() {
		Curso novoCurso = getNovoCurso();
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.inserir(novoCurso);
		return novoCurso;
	}

	private Curso getNovoCurso() {
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = getModalidade();
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		return curso;
	}
	
	//Utilizado em MenuMateria e MenuMatricula
	public Curso getCurso(){
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
		if(cursos.isEmpty()){
			Console.mensagem("Nenhum curso encontrado. Adicione um");
			cursos.add(new MenuCurso().inserirCurso());
		}
		Console.mensagem("Foram encontrados (" + cursos.size() +") cursos");
		int i = 0;
		for(Curso curso : cursos){
			i++;
			Console.mensagem("(" + i + ") " +curso.toString());
		}
		i = Console.lerNumeroObrigatorio("Escolha o número do Curso");
		return cursos.get(i - 1);
	}

	private Modalidade getModalidade() {
		int numeroModalidade = Console.
				lerNumeroObrigatorio("Digite a Modalidade (número).\n"
						+ "1. Técnico Integrado\n"
						+ "2. Técnico Subsequente");
		try{
			return Modalidade.getModalidade(numeroModalidade);
		}
		catch(IllegalArgumentException e){
			return getModalidade();
		}
	}

	public int escolheOpcao(){
		Console.mensagem("\n-----Menu Curso-----\n");
		Console.mensagem("1. Inserir");
		Console.mensagem("2. Buscar curso por nome");
		Console.mensagem("3. Alterar Curso (por id)");
		Console.mensagem("4. Remover um Curso (por id)");
		Console.mensagem("5. Listar matérias do Curso (por parte do nome)");
		Console.mensagem("9. Voltar ao Menu Principal");
		return Console.lerNumeroObrigatorio("");
	}

}
