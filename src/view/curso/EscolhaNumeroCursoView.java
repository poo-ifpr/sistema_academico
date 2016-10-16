package view.curso;

import util.Console;

public class EscolhaNumeroCursoView {

	public static int criar(){
		int i = Console.lerNumeroObrigatorio("Escolha o número do Curso");
		return i;
	}
}
