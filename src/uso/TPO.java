package uso;

import tda.*;
import imple.*;
import implementacion.DiccionarioSimpleEstatico;
import implementacion.PilaEstatica;
import implementacion.ConjuntoEstatico;
import interfaz.DiccionarioSimpleTDA;
import interfaz.PilaTDA;
import interfaz.ColaTDA;
import interfaz.ConjuntoTDA;

public class TPO {

	
	public static float ejercicio6(PilaTDA p) {//el metodo es lineal puesto que posee un ciclo
		PilaTDA aux = new PilaEstatica();
		aux.inicializa();
		int pares=0;
		int total=0;
		while(!p.pilaVacia()) {
			int n = p.tope();
			if(n % 2 == 0) 
				pares++;
			total++;
			aux.apilar(p.tope());
			p.desapilar();
		}
		float porcentaje = ((float)pares/total)*100 ;
		while(!aux.pilaVacia()) {
			p.apilar(aux.tope());
			aux.desapilar();
		}
	
		
		return porcentaje;
	}
	
	public static void main(String[] args) {
		

		PilaTDA pila = (PilaTDA) new Pila();
		pila.inicializa();	
		
		ConjuntoTDA ejercicio7 = ElementosRepetidosPila(pila);
		
		/****************/
		
		ColaTDA cola = new Cola();
		cola.inicializarCola();
		
		ColaTDA ejercicio8 = ColaSinRepetidos(cola);

	}
	
	
	/****************/
	/****  EJ: 7 ****/
	/****************/
	public static ConjuntoTDA ElementosRepetidosPila(PilaTDA pila)  
	{
		ConjuntoTDA respuesta = new Conjunto(); 
		respuesta.inicializarConjunto();

		ConjuntoTDA utilizados = new Conjunto();
		utilizados.inicializarConjunto();
		
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializa();		
		
		//Comenzamos a recorrer la pila, elemento por elemento hasta que quede vacia.
		while(!pila.pilaVacia()) 
		{
			int valor = pila.tope();	
			pilaAux.apilar(valor);
			
			// Preguntas si el valor ya esta en el conjunto auxiliar llamado utilizados
			// en caso de que ya exista el valor en utilizados, es decir que el valor esta repetido,
			// lo agregamos al conjunto respuesta.
			if(utilizados.pertenece(valor)) 
			{
				respuesta.agregar(valor);
			}
			
			utilizados.agregar(valor);			
			pila.desapilar();		
		}
		
		// recuperamos la pila que nos llego como input al metodo
		while(!pilaAux.pilaVacia()) 
		{
			pila.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}		
		
		return respuesta;
	}
	
	/****************/
	/****  EJ: 8 ****/
	/****************/
	public static ColaTDA ColaSinRepetidos(ColaTDA cola)  
	{
		ConjuntoTDA conjunto = new Conjunto(); 
		conjunto.inicializarConjunto();
		
		ColaTDA respuesta = new Cola(); 
		cola.inicializarCola();	
		
		//Comenzamos a recorrer la cola, elemento por elemento hasta que quede vacia.
		while(!cola.colaVacia()) 
		{
			int valor = cola.primero();	
			
			// Preguntas si el valor ya esta en el conjunto para omitir agregar elementos repetidos.
			// en caso de que no exista el valor, lo agregamos a la nueva cola respuesta.
			if(!conjunto.pertenece(valor)) 
			{
				respuesta.acolar(valor);
				conjunto.agregar(valor);
			}
					
			cola.desacolar();		
		}			
		
		return respuesta;
	}
	
	public static ConjuntoTDA ejercicio9(ColaTDA c, PilaTDA p) {//el metodo es polinomico puesto que posee un ciclo dentro de otro
		ConjuntoTDA res = new ConjuntoEstatico();
		ConjuntoTDA auxC = new ConjuntoEstatico();
		ConjuntoTDA auxP = new ConjuntoEstatico();
		res.inicializarConjunto();
		auxC.inicializarConjunto();
		auxP.inicializarConjunto();
		while(!p.pilaVacia()) {
			auxP.agregar(p.tope());
			p.desapilar();
		}
		while(!c.colaVacia()) {
			auxC.agregar(c.primero());
			c.desacolar();
		}
		while(!auxC.conjuntoVacio()) {
			int v = auxC.elegir();
			if(auxP.pertenece(v))
				res.agregar(v);
			auxC.sacar(v);
		}
		
		return res;
	}
	
	public static DiccionarioSimpleTDA ejercicio10(PilaTDA p) {//el metodo es polinomico puesto que posee un ciclo dentro de otro
		DiccionarioSimpleTDA ds = new DiccionarioSimpleEstatico();
		PilaTDA aux = new PilaEstatica();
		ds.inicializar();
		aux.inicializa();
		while(!p.pilaVacia()) {
			int v = p.tope();
			p.desapilar();
			int cont = 1;
			while(!p.pilaVacia()) {
				if(v == p.tope()) {
					cont++;
					p.desapilar();
				}
				else {
					aux.apilar(p.tope());
					p.desapilar();
				}
			}
			ds.agregar(v, cont);
			while(!aux.pilaVacia()) {
				p.apilar(aux.tope());
				aux.desapilar();
			}
		}
		return ds;
	}
	

}
