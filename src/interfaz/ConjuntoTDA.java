package interfaz;

public interface ConjuntoTDA {
	//el cunjuto devuleve cualquier numero
	public void inicializarConjunto();
	public void agregar(int valor);
	public void sacar(int valor);
	public int elegir();
	public boolean conjuntoVacio();
	public boolean pertenece(int x);
}
