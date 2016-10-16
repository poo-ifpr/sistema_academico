package view;

import model.Modalidade;
import util.Console;

public class NovaModalidadeView {

	
	public static Modalidade criar(){
		int numeroModalidade = Console.
				lerNumeroObrigatorio("Digite a Modalidade (número).\n"
						+ "1. Técnico Integrado\n"
						+ "2. Técnico Subsequente");
		try{
			return Modalidade.getModalidade(numeroModalidade);
		}
		catch(IllegalArgumentException e){
			return NovaModalidadeView.criar();
		}
	}
}
