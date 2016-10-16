package view;

import model.Curso;
import model.Modalidade;
import util.Console;

public class NovoCursoView {

	
	
	public static Curso criar(){
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = NovaModalidadeView.criar();
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		return curso;
	}

}
