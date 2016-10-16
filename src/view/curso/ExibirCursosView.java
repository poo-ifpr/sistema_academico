package view.curso;

import java.util.List;

import model.Curso;
import util.Console;

public class ExibirCursosView {

	public static void criar(List<Curso> cursos){
		Console.mensagem("Foram encontrados (" + cursos.size() +") cursos");
		int i = 0;
		for(Curso curso : cursos){
			i++;
			Console.mensagem("(" + i + ") " +curso.toString());
		}
	}
}
