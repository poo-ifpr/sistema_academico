package util;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {

	
	private static Scanner leitorNumeros;
	private static Scanner leitorStrings;
	private static PrintStream terminal;
	
	
	static {
		leitorNumeros = new Scanner(System.in);
		leitorStrings = new Scanner(System.in);
		terminal = System.out;
	}
	
	public static String lerStringObrigatoria(String mensagem){
		String string;
		terminal.println(mensagem);
		string = leitorStrings.nextLine();
		while (string.isEmpty()) {
			terminal.println(mensagem);
			string = leitorStrings.nextLine();
		}
		return string;
	}
	
	public static int lerNumeroObrigatorio(String mensagem){
		int numero = -1;
		boolean ok = false;
		while(!ok){
			try{
				terminal.println(mensagem);
				numero = leitorNumeros.nextInt();
				ok = true;
			}
			catch(Exception e){
				terminal.println("Erro na leitura do número. Tente novamente");
				ok = false;
			}
		}
		return numero;
	}
	
}
