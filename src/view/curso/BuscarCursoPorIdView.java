package view.curso;

import util.Console;

public class BuscarCursoPorIdView {

	
	public static Long criar(){
		Long idCurso = new Long(Console.lerNumeroObrigatorio("Digite o id do curso"));
		return idCurso;

	}
}
