package menu;

import java.util.List;

import dao.CursoDAO;
import model.Curso;
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
		default:
			break;
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

	private void inserirCurso() {
		Curso novoCurso = getNovoCurso();
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.inserir(novoCurso);
	}

	private Curso getNovoCurso() {
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = getModalidade();
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		return curso;
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
		Console.mensagem("9. Voltar ao Menu Principal");
		return Console.lerNumeroObrigatorio("");
	}

}
