package observers.curso;

import facade.FacadeCurso;
import model.Curso;
import observers.Observer;

public class NovoCursoObserver implements Observer<Curso> {

	private Curso curso;
	
	@Override
	public void update(Curso novoCurso) {
		this.curso = FacadeCurso.inserir(novoCurso);
	}
	
	public static NovoCursoObserver criar(){
		return new NovoCursoObserver();
	}
	
	public Curso getCurso(){
		return curso;
	}

}
