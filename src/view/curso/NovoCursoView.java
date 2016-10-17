package view.curso;

import model.Curso;
import model.Modalidade;
import observers.SubjectView;
import util.Console;
import view.modalidade.NovaModalidadeView;

public class NovoCursoView extends SubjectView<Curso> {

	private Curso curso;
	
	public NovoCursoView(){
		this.curso = new Curso();
	}
	
	
	public void executar(){
		String nome = Console.lerStringObrigatoria("Digite o nome do Curso");
		Modalidade modalidade = NovaModalidadeView.criar();
		this.curso.setNome(nome);
		this.curso.setModalidade(modalidade);
		notificarObservers();
	}

	@Override
	public Curso getSubject() {
		return this.curso;
	}

}
