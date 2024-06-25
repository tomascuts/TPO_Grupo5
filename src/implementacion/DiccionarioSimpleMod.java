package implementaciones;

import interfaz.DiccionarioSimpleModTDA;
import interfaz.conjuntoTDA;


public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
	
	private class Elemento {	// creo el elmento del dicc con un dato mas que va a contabilizar las modificaciones
		
		int clave;
		int valor;
		int mod;
		
	}
	private Elemento[] elementos;
	private int cant;

	@Override
	public void inicializarDiccionario() {
		
		cant = 0;
		elementos = new Elemento[100];

	}

	@Override
	public void agregar(int clave, int valor) {

		int pos = this.clave2Indice(clave);
		if (pos == -1) {							// si el dicc esta vacio agrego los valores
			elementos[cant] = new Elemento();
			elementos[cant].clave = clave;
			elementos[cant].valor = valor;
			elementos[cant].mod = 0;
			cant ++;
		
		} else {								// si la clave existe, reemplezo el valor x el nuevo
			elementos[pos].valor = valor;
			elementos[pos].mod ++;				// incremento el contador de modificaciones
		}
	}
	
	private int clave2Indice ( int clave) {
		int i= cant -1;
		while (i>=0 && elementos[i].clave !=clave) {
			i--;
		}
		return i;
	}

	

	@Override
	public void eliminar(int clave) {
		int pos = this.clave2Indice(clave);
		if (pos !=-1) {
			elementos[pos] = elementos[cant-1];		// si la clave existe elimino los datos
			cant--;
			}
	}

	@Override
	public int recuperar(int clave) {
		int pos = this.clave2Indice(clave);
		return elementos[pos].valor;
	}

	@Override
	public int recuperarMod(int clave) {
		int pos = this.clave2Indice(clave);
		return elementos[pos].mod;		// muestro la cantidad de modificaciones
		
	}

	@Override
	public conjuntoTDA claves() {
		conjuntoTDA c = new Conjuntos();
		c.inicializarConjunto();
		
		for (int i=0;i<cant; i++) {
			c.agregar(elementos[i].clave);
		}
		return c;
	}
	}
