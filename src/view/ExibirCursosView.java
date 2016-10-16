package view;

import java.util.List;

import model.Curso;
import util.Console;

public class ExibirCursosView {

	public static void criar(List<Curso> cursos){
		Console.mensagem("Foram encontrados (" + cursos.size() +") cursos");
		for(Curso curso : cursos){
			Console.mensagem(curso.toString());
		}
	}
}
