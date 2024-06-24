package interfaz;

public interface ColaPrioridadTDA {
	public void inicializar();
	public void acolarPrioridad(int v, int p);
	public void desacolar();
	public int prioridad();
	public int primero();
	public boolean estaVacio();
	

}
