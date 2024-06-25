package implementaciones;

import interfaz.MultiPilaTDA;
import interfaz.pilaTDA;




public class MultiPila implements MultiPilaTDA {
	
	//Creo el nodo, con un dato tipo pilaTDA y otro nodo que servira como puntero
	
	private class Nodo {
		pilaTDA pilaIN;
		Nodo sig;
	}
	
	private Nodo primero;
	
	@Override
	public void apilar(pilaTDA valores) {
		
		Nodo nuevo = new Nodo();			// creo el nodo nuevo para guardar la pila
		nuevo.pilaIN = valores;				// asigno la pila recibida al nodo nuevo
		nuevo.sig = primero;				// y apunto el nodo a primero
		primero = nuevo;					//asigno el nodo primero al comienzo de la multipila
		
	}

	@Override
	public void desapilar(pilaTDA valores) {
		
		pilaTDA pilaTope = primero.pilaIN;	// creo una pila para almacenar el tope de la Multipila
		boolean coincidencia = true;		// me indica si coincide3n todos los elementos de la pila
		while (!valores.pilaVacia() && coincidencia == true) { // recorro la pila valores
			if (valores.tope() == pilaTope.tope()) {		// comparo si los valores son iguales
				valores.desapilar();						//desapilo los tope	
				pilaTope.desapilar();
			} else {										
				coincidencia = false;						// si los topes no coinciden cambio la var
			}
		}
		if (coincidencia && (pilaTope.pilaVacia())) {		// verifico si la coincidencia fue exacta y tenian la misma cant de elemnetos
			primero.sig = primero.sig.sig;					// desapilo la MultiPila
			
		} else if (coincidencia) {											
			primero.pilaIN = pilaTope;						//si coincidieron todos los valores pero no tiene la misa cant de elemntos vuelvo a apilar el resto de la pila tope
		}
	}

	@Override
	public pilaTDA tope(int cantidad) {
		
		pilaTDA topPila = primero.pilaIN;				//creo una pila con el tope de la MultiPila
		pilaTDA pilaFinal = new Pila();					// creo una pila que almacenara el tope requerido
		pilaFinal.inicializarPila();					
		
		while (!topPila.pilaVacia() && cantidad >0) {	//recorro la pilatope las veces que indica cantidad
			pilaFinal.apilar(topPila.tope());			//voy apilando el valor en la pila que voy a devolver
			topPila.desapilar();
			cantidad--;									// voy descontando la cantidad de vueltas
		}
		
		return pilaFinal;
	}

	@Override
	public void inicializarPila() {
		primero = null;							// creo un Nodo vacio

	}

	@Override
	public boolean pilaVacia() {
		return primero == null;					// me fijo si el primer nodo esta vacio, quiere decir que no hay datos en la Multipila
	}

}
