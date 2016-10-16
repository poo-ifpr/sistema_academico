package view.materia;

import java.util.List;

import model.Materia;
import util.Console;

public class ExibirMateriasView {

	public static void criar(List<Materia> materias){
		Console.mensagem("Foram encontrados (" + materias.size() +") matérias");
		int i = 0;
		for(Materia materia: materias){
			i++;
			Console.mensagem("(" + i + ") " + materia.toString());
		}
	}
}
