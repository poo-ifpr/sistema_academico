package observers;

public interface Subject<E> {

	
	public void adicionarObserver(Observer<E> o);
	public void removerObserver(Observer<E> o);
	public void notificarObservers();
}
