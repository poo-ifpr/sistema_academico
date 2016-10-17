package observers.curso;



import java.util.logging.Level;
import java.util.logging.Logger;


import model.Curso;
import observers.Observer;

public class LogCursoObserver implements Observer<Curso> {

	private final Logger logger = Logger.getLogger("LogCursoObserver");

	
	@Override
	public void update(Curso novoCurso) {
		logger.info(novoCurso.toString());
	}
	
	public static LogCursoObserver criar(){
		return new LogCursoObserver();
	}

}
