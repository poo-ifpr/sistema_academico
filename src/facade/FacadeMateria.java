package facade;

import java.util.List;

import dao.MateriaDAO;
import model.Curso;
import model.Materia;

public class FacadeMateria {

	
	public static List<Materia> listarMateriasCursoPorNome(Curso curso, String nomeMateria){
		MateriaDAO materiaDAO = new MateriaDAO();
		List<Materia> materias = materiaDAO.buscarPorCursoPorNome(curso, nomeMateria);
		return materias;
	}
}
