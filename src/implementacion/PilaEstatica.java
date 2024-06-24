package implementacion;

import interfaz.PilaTDA;

public class PilaEstatica implements PilaTDA {
	private int[] valores;
	private int cant;

	@Override
	public void inicializa() {
		
		valores = new int[100];
		cant=0;
		
	}

	@Override
	public int tope() {
		
		return valores[cant -1];
	}

	@Override
	public void apilar(int v) {
		
		valores[cant] = v;
		cant++;
	}

	@Override
	public void desapilar() {
		
		cant--;
		
	}

	@Override
	public boolean pilaVacia() {
		
		return cant==0;
	}

}
