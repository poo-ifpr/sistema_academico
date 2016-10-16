package view;

import model.Curso;
import model.Modalidade;
import util.Console;

public class NovoCursoView {

	
	
	public static Curso criar(){
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = getModalidade();
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		return curso;
	}

	//	INTERFACE - VIEW
	private static Modalidade getModalidade() {
		int numeroModalidade = Console.
				lerNumeroObrigatorio("Digite a Modalidade (número).\n"
						+ "1. Técnico Integrado\n"
						+ "2. Técnico Subsequente");
		try{
			return Modalidade.getModalidade(numeroModalidade);
		}
		catch(IllegalArgumentException e){
			return getModalidade();
		}
	}	
}
