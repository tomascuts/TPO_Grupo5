package uso;

import tda.*;
import imple.*;

public class TPO {

	public static void main(String[] args) {
		

		PilaTDA pila = new Pila();
		pila.inicializarPila();	
		
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
		pilaAux.inicializarPila();		
		
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

}
