package facade;

import java.util.List;

import dao.CursoDAO;
import model.Curso;

public class FacadeCurso {

	public static void remover(Curso curso) {
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.remover(curso);
	}

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
}
