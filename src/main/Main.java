package main;

import menu.Menu;
import menu.MenuCurso;

public class Main {

	public static void main(String[] args) {
		int opcao = menuPrincipal();
		Menu menu = getMenu(opcao);
		menu.executar();
		
	}

	private static Menu getMenu(int opcao) {
		if(opcao == 1){
			return new MenuCurso();
		}
		return null;
	}

	private static int menuPrincipal() {
		System.out.println("Escolhida opção Curso");
		return 1;
	}
	
}
