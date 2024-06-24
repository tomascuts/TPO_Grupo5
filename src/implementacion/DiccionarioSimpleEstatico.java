package implementacion;

import implementacion.ColaPrioridadEstatico;
import implementacion.ConjuntoEstatico;
import interfaz.DiccionarioSimpleTDA;
import interfaz.ColaPrioridadTDA;
import interfaz.ConjuntoTDA;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {
	private ColaPrioridadTDA cola;
 	@Override
	public void inicializar() {//el motodo es constante puesto que el metodo tiene operaciones de asignacion
		// TODO Auto-generated method stub
 		cola = (ColaPrioridadTDA) new ColaPrioridadEstatico();
 		cola.inicializar();
	}

	
	public void agregar(int c, int v) {//el metodo es polinomico por que existe un ciclo dentro de otro
	    if (cola.estaVacio()) {
	        cola.acolarPrioridad(v, c);
	    } else {
	        ColaPrioridadTDA aux = (ColaPrioridadTDA) new ColaPrioridadEstatico();
	        aux.inicializar();
	        boolean bandera = true;
	        while (!cola.estaVacio() && bandera) {
	            if (cola.prioridad() != c) {
	                aux.acolarPrioridad(cola.primero(), cola.prioridad());
	            } else {
	                aux.acolarPrioridad(v, cola.prioridad());
	                bandera = false;
	            }
	            cola.desacolar();
	        }

	        while (!aux.estaVacio()) {
	            cola.acolarPrioridad(aux.primero(), aux.prioridad());
	            aux.desacolar();
	        }
	        if (bandera) {
	            cola.acolarPrioridad(v, c);
	        }
	    }
	}


	@Override
	public void eliminar(int c) {//el metodo es polinomico por que existe un ciclo dentro de otro
	    if (!cola.estaVacio()) {
	        ColaPrioridadTDA aux = (ColaPrioridadTDA) new ColaPrioridadEstatico();
	        aux.inicializar();
	        while (!cola.estaVacio()) {
	            if (cola.prioridad() != c) {
	            	 aux.acolarPrioridad(cola.primero(), cola.prioridad());
	            	}
	            cola.desacolar();
	         
	            }
	        while (!aux.estaVacio()) {
	            cola.acolarPrioridad(aux.primero(), aux.prioridad());
	            aux.desacolar();
	        }
	        }
	}


	@Override
	public int recuperar(int c) {//el metodo es polinomico por que existe un ciclo dentro de otro
		// TODO Auto-generated method stub
		ColaPrioridadTDA aux = (ColaPrioridadTDA) new ColaPrioridadEstatico();
		aux.inicializar();
		boolean bandera = true;
		int valor = 0;
		while(!cola.estaVacio() && bandera) {
			if(cola.prioridad() == c) {
				valor = cola.primero();
				bandera = false;
			}
			aux.acolarPrioridad(cola.primero(), cola.prioridad());
			cola.desacolar();
		}
		while(!aux.estaVacio()) {
			cola.acolarPrioridad(aux.primero(), aux.prioridad());
			aux.desacolar();
		}
		
		return valor ;
	}

	@Override
	public ConjuntoTDA claves() {//el metodo es polinomico por que existe un ciclo dentro de otro
		// TODO Auto-generated method stub
		ColaPrioridadTDA aux = (ColaPrioridadTDA) new ColaPrioridadEstatico();
		ConjuntoTDA claves = new ConjuntoEstatico();
		aux.inicializar();
		claves.inicializarConjunto();
		while(!cola.estaVacio()) {
			aux.acolarPrioridad(cola.primero(), cola.prioridad());
			claves.agregar(cola.prioridad());
			cola.desacolar();
		}
		while(!aux.estaVacio()) {
			cola.acolarPrioridad(aux.primero(), aux.prioridad());
			aux.desacolar();
		}
		
		return claves;
	}

}
