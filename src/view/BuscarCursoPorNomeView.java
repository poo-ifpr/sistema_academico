package view;

import util.Console;

public class BuscarCursoPorNomeView {

	
	public static String criar(){
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		return nomeCurso;

	}
}
