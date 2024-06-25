package interfaz;

public interface ABBTDA {
	public void inicializar();
	public void agregar(int v);
	public void eliminar(int v);
	public int raiz();
	ABBTDA hijoIzq();
	ABBTDA hijoDer();
	boolean arbolVacio();
	
}
