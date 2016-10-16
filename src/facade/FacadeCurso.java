package facade;

import java.util.List;

import dao.CursoDAO;
import dao.MateriaDAO;
import model.Aluno;
import model.Curso;
import model.Materia;
import model.Modalidade;
import util.Console;
import view.NovaModalidadeView;
import view.NovoCursoView;

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
//TODO: FIx remover
//	private void removerCurso() {
//		CursoDAO cursoDAO = new CursoDAO();
//		Curso curso = buscarCursoPorId();
//		if(curso == null){
//			Console.mensagem("Nenhum curso foi encontrado");
//			return;
//		}
//		cursoDAO.remover(curso);
//	}

	public static void alterar(Curso curso) {
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.alterar(curso);
	}

	public static List<Curso> buscar(String nomeCurso) {
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
		return cursos;
	}
	
	public static Curso buscarPorId(Long idCurso){
		CursoDAO cursoDAO = new CursoDAO();
		return cursoDAO.buscarPorId(idCurso);

	}

	//Reutilizado em MenuMatéria
	public static Curso inserir(Curso novoCurso) {
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.inserir(novoCurso);
		return novoCurso;
	}


	
	//Utilizado em MenuMateria e MenuMatricula
	public static Curso getCurso(){
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
		if(cursos.isEmpty()){
			Console.mensagem("Nenhum curso encontrado. Adicione um");
			Curso novoCurso = NovoCursoView.criar();
			cursos.add(FacadeCurso.inserir(novoCurso));
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
