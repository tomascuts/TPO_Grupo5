package implementaciones;

import interfaz.conjuntoTDA;
import interfaz.diccionarioSimpleTDA;
import interfaz.colaPrioridadTDA;

public class diccionarioSimpleCP implements diccionarioSimpleTDA {
	
	colaPrioridadTDA dicCola = new ColaPrioridad();  // creo la estructura del diccionario
	
	
	private boolean existeClave (int clave) {  // con este metodo verifico si la clave ingresada existe en el dic
		
		colaPrioridadTDA Aux = new ColaPrioridad();
		
		boolean existe = false;		// creo una var para identificar si existe la clave
		
		Aux.inicializarCola();
				
		while (!dicCola.colaVacia() && existe == false) {			//verifico si la clave existe
			
			int prio = dicCola.prioridad();
			
			if (prio == clave) {
				
				existe = true;
			}
			
			Aux.acolarPrioridad(dicCola.primero(), dicCola.prioridad());
			dicCola.desacolar();
		}
		
		while (!Aux.colaVacia()) {	// restablesco la cola original
			
			dicCola.acolarPrioridad(Aux.primero(), Aux.prioridad());
			Aux.desacolar();
		}
		
		return existe;	
	}

	@Override
	public void inicializarDiccionario() {
		
		dicCola.inicializarCola();
	}

	@Override
	public void agregar(int clave, int valor) {
		
		colaPrioridadTDA Aux = new ColaPrioridad();  // creo una cola auxiliar que me permite restablecer la cola original
		Aux.inicializarCola();
		
		boolean existe = existeClave(clave);
				
		if (dicCola.colaVacia() || existe == false) { // si la cola esta vacia o la clave no esiste acolo directamente
		
			dicCola.acolarPrioridad(valor, clave);
			
			
		} else {
			
			while ( clave != dicCola.prioridad()) {  // busco la clave ingresada en la cola
				
				Aux.acolarPrioridad(dicCola.primero(), dicCola.prioridad());
				dicCola.desacolar();
			}
			
			dicCola.desacolar();  // desacolo la clave ingresada
			dicCola.acolarPrioridad(valor, clave); // acolo la clave con su valor nuevamente
			
		}
		
		while (!Aux.colaVacia()) {  // restauro la cola original
			
			dicCola.acolarPrioridad(Aux.primero(), Aux.prioridad());
			Aux.desacolar();
		}
	}

	@Override
	public void eliminar(int clave) {
		
		colaPrioridadTDA Aux = new ColaPrioridad();
		Aux.inicializarCola();
		
		boolean existe = existeClave(clave);
		
		if (existe) { // verifico que la clave exista para poder eliminarla
			
			while ( clave != dicCola.prioridad()) { // busco la clave ingresada
				
				Aux.acolarPrioridad(dicCola.primero(), dicCola.prioridad()); // voy guardadndo los datos en la cola aux
				dicCola.desacolar(); 
			}
			
			dicCola.desacolar(); // elimino la clave ingresada
			
			while (!Aux.colaVacia()) {  // restauro la cola original sin la clave eliminada
				
				dicCola.acolarPrioridad(Aux.primero(), Aux.prioridad());
				Aux.desacolar();
			}
					
		}

	}

	@Override
	public int recuperar(int clave) {
		
		colaPrioridadTDA Aux = new ColaPrioridad();
		Aux.inicializarCola();
		
		boolean existe = existeClave(clave);
		
		int valor = 0;
		
		if (existe) {  // verifico que la clave exista
			
			while ( clave != dicCola.prioridad()) {  // busco la clave en la cola
				
				Aux.acolarPrioridad(dicCola.primero(), dicCola.prioridad());
				dicCola.desacolar();
			}
			
			valor = dicCola.primero();  // obtengo el valor asociado a la clave
			
			while (!Aux.colaVacia()) { // restauro la cola original
				
				dicCola.acolarPrioridad(Aux.primero(), Aux.prioridad());
				Aux.desacolar();
			}
		
		}
		
		return valor;
	}

	@Override
	public conjuntoTDA claves() {
		
		conjuntoTDA conjClaves = new Conjuntos();
		conjClaves.inicializarConjunto();
		
		colaPrioridadTDA Aux = new ColaPrioridad();
		Aux.inicializarCola();
		
		while(!dicCola.colaVacia()) {  // voy agregando las claves al conjunto y a su vez conservando los datos descartados en la cola aux
			
			conjClaves.agregar(dicCola.prioridad());
			Aux.acolarPrioridad(dicCola.primero(), dicCola.prioridad());
			dicCola.desacolar();
		}
		
		while(!Aux.colaVacia()) {  // restauro la cola original
			
			dicCola.acolarPrioridad(Aux.primero(), Aux.prioridad());
			Aux.desacolar();
		}
		
		
		return conjClaves;
	}

}
