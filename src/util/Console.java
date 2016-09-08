package util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Console {

	
	private static Scanner leitorNumeros;
	private static Scanner leitorStrings;
	private static PrintStream terminal;
	private static SimpleDateFormat dateFormatter;
	private static String dateFormat = "dd/MM/yyyy";
	
	static {
		leitorNumeros = new Scanner(System.in);
		leitorStrings = new Scanner(System.in);
		terminal = System.out;
		dateFormatter = new SimpleDateFormat();
		dateFormatter.applyPattern(dateFormat);
	}
	
	public static void mensagem(String mensagem){
		terminal.println(mensagem);
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

	public static Date lerDataObrigatoria(String mensagem) {
		String dataString = lerStringObrigatoria(mensagem);
		try{
			return dateFormatter.parse(dataString);
		} catch(ParseException e){
			mensagem("Data inválida. Entre novamente");
			return lerDataObrigatoria(mensagem);
		}
	}
	
}
