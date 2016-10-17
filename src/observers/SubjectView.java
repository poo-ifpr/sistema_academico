package observers;

import java.util.ArrayList;
import java.util.List;

public abstract class SubjectView<E> implements Subject<E> {

	protected List<Observer<E>> observers;
	
	public SubjectView(){
		observers = new ArrayList<Observer<E>>();
	}

	@Override
	public void adicionarObserver(Observer<E> o) {
		observers.add(o);
	}

	@Override
	public void removerObserver(Observer<E> o) {
		observers.remove(o);
		
	}

	@Override
	public void notificarObservers() {
		for(Observer<E> observer : this.observers){
			observer.update(getSubject());
		}
	}

	abstract E getSubject();
	
	
}
