package view.curso;

import util.Console;

public class LerNomeCursoView {

	
	public static String criar(){
		String nomeCurso = Console.lerStringObrigatoria("Digite parte do nome do Curso");
		return nomeCurso;

	}
}
