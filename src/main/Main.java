package main;

import menu.Menu;
import menu.MenuCurso;
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
		if(opcao == 1){
			return new MenuCurso();
		}
		else if(opcao == 9){
			Console.mensagem("Fim do Programa");
			System.exit(0);
		}
		return null;
	}

	private static int menuPrincipal() {
		Console.mensagem("\n-----Menu-----\n");
		Console.mensagem("1. Curso");
		Console.mensagem("9. Sair");
		return Console.lerNumeroObrigatorio("");
	}
	
}
