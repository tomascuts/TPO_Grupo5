package interfaz;

public interface DiccionarioSimpleTDA {
	public void inicializar();
	public void agregar(int c,int v);
	public void eliminar(int c);
	public int recuperar(int c);
	public ConjuntoTDA claves();
	

}
