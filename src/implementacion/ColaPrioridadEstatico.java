package implementacion;


import interfazComplemento.ColaPrioridadTDA;

public class ColaPrioridadEstatico implements ColaPrioridadTDA {
	class Elemento{
		private int valor;
		private int prioridad;
	}
	private Elemento[] elementos;
	private int cant;

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		elementos = new Elemento[100];
		cant = 0;
		
	}

	
	@Override
	public void acolarPrioridad(int v, int p) {
		// TODO Auto-generated method stub
		int pos = cant;
		while(pos > 0 && elementos[pos -1].prioridad >= p) {
			elementos[pos] = elementos[pos -1];
			pos--;
		}
		elementos[pos] = new Elemento();
		elementos[pos].prioridad = p;
		elementos[pos].valor = v;
		cant++;
	}

	@Override
	public void desacolar() {
		// TODO Auto-generated method stub
		cant--;
		
	}

	@Override
	public int prioridad() {
		// TODO Auto-generated method stub
		return elementos[cant -1].prioridad;
	}

	@Override
	public int primero() {
		// TODO Auto-generated method stub
		return elementos[cant -1].valor;
	}

	@Override
	public boolean estaVacio() {
		// TODO Auto-generated method stub
		return cant==0;
	}

}
