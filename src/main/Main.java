package main;

import menu.Menu;
import menu.MenuAluno;
import menu.MenuCurso;
import menu.MenuMateria;
import util.Console;

public class Main {

	public static void main(String[] args) {
		int opcao = 0;
		Menu menu = null;
		while(true){
			opcao = menuPrincipal();
			menu = getMenu(opcao);
			menu.executar();
		}
	}

	private static Menu getMenu(int opcao) {
		switch(opcao){
		case 1:
			return new MenuCurso();
		case 2:
			return new MenuAluno();
		case 3:
			return new MenuMateria();
		case 9:
			Console.mensagem("Fim do Programa");
			System.exit(0);
		}
		return null;
	}

	private static int menuPrincipal() {
		Console.mensagem("\n-----Menu-----\n");
		Console.mensagem("1. Curso");
		Console.mensagem("2. Aluno");
		Console.mensagem("3. Matéria");
		Console.mensagem("9. Sair");
		return Console.lerNumeroObrigatorio("");
	}
	
}
