package facade;

import java.util.List;

import dao.CursoDAO;
import dao.MateriaDAO;
import model.Aluno;
import model.Curso;
import model.Materia;
import model.Modalidade;
import util.Console;

public class FacadeCurso {

	
	
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
	public static Curso inserir() {
		//TODO: Fix GetNovoCurso
		//Curso novoCurso = getNovoCurso();
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.inserir(novoCurso);
		return novoCurso;
	}


	
	//Utilizado em MenuMateria e MenuMatricula
	public Curso getCurso(){
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
		if(cursos.isEmpty()){
			Console.mensagem("Nenhum curso encontrado. Adicione um");
			cursos.add(new FacadeCurso().inserirCurso());
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

	

	

}
