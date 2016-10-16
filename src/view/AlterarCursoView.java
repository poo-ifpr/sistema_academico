package view;

import model.Curso;
import model.Modalidade;
import util.Console;

public class AlterarCursoView {

	
	public static Curso criar(Curso curso){
		Console.mensagem("Curso escolhido: " + curso);
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = NovaModalidadeView.criar();
		curso.setNome(nome);
		curso.setModalidade(modalidade);
		return curso;
	}
}
