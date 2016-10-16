package view.materia;

import util.Console;

public class BuscarParteNomeMateriaView {

	public static String criar(){
		String nomeMateria = Console.
				lerStringObrigatoria("Digite parte do nome da Matéria");
		return nomeMateria;
	}
}
