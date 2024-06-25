package uso;

import tda.*;
import imple.*;
import implementacion.DiccionarioSimpleEstatico;
import implementacion.PilaEstatica;
import implementacion.ConjuntoEstatico;
import interfaz.DiccionarioSimpleTDA;
import interfaz.PilaTDA;
import interfaz.ABBTDA;
import interfaz.ColaTDA;
import interfaz.ConjuntoTDA;

public class TPO {

	
	/****************/
	/****  EJ: 6 ****/
	/****************/
	
	
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
		
		ColaTDA cola = (ColaTDA) new Cola();
		cola.inicializar();
		
		ColaTDA ejercicio8 = ColaSinRepetidos(cola);

	}
	
	
	/****************/
	/****  EJ: 7 ****/
	/****************/
	public static ConjuntoTDA ElementosRepetidosPila(PilaTDA pila)  
	{
		ConjuntoTDA respuesta = (ConjuntoTDA) new Conjunto(); 
		respuesta.inicializarConjunto();

		ConjuntoTDA utilizados = (ConjuntoTDA) new Conjunto();
		utilizados.inicializarConjunto();
		
		PilaTDA pilaAux = (PilaTDA) new Pila();
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
		ConjuntoTDA conjunto = (ConjuntoTDA) new Conjunto(); 
		conjunto.inicializarConjunto();
		
		ColaTDA respuesta = (ColaTDA) new Cola(); 
		cola.inicializar();	
		
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
	
	/****************/
	/****  EJ: 9 ****/
	/****************/
	
	
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
	/****************/
	/****  EJ: 10 ****/
	/****************/
	
	
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
	
	
	/****************/
	/****  EJ: 11 ****/
	/****************/

	public class ConvertirDicMultipleACola {

		 public static void main(String[] args) {
		        // Inicializar diccionario múltiple
		        DiccionarioMultipleTDA dicMultiple = new DiccionarioMultiple();
		        dicMultiple.inicializarDiccionario();

		        dicMultiple.agregar(1, 2);
		        dicMultiple.agregar(1, 3);
		        dicMultiple.agregar(2, 4);
		        dicMultiple.agregar(2, 5);
		        dicMultiple.agregar(3, 5);
		        dicMultiple.agregar(3, 2);

		        // Convertir diccionario múltiple a cola sin repeticiones
		        ColaTDA cola = (ColaTDA) new Cola();
		        cola.inicializar();

		        ConjuntoTDA valoresUnicos = (ConjuntoTDA) new Conjunto();
		        valoresUnicos.inicializarConjunto();

		        ConjuntoTDA claves = (ConjuntoTDA) dicMultiple.claves();
		        while (!claves.conjuntoVacio()) {
		            int clave = claves.elegir();
		            claves.sacar(clave);

		            ConjuntoTDA valores = (ConjuntoTDA) dicMultiple.recuperar(clave);
		            while (!valores.conjuntoVacio()) {
		                int valor = valores.elegir();
		                valores.sacar(valor);
		                if (!valoresUnicos.pertenece(valor)) {
		                    valoresUnicos.agregar(valor);
		                    cola.acolar(valor);
		                }
		            }
		        }

		        // Imprimir cola
		        while (!cola.colaVacia()) {
		            System.out.print(cola.primero() + " ");
		            cola.desacolar();
		        }
		    }
		
	}
	
	/****************/
	/****  EJ: 12 ****/
	/****************/
	
	public static int ejercicio12(ABBTDA a) {
		if(a.arbolVacio()) {
			return 0;
		}
		if(a.raiz() %2!=0) {
			return a.raiz()+ ejercicio12(a.hijoIzq()) + ejercicio12(a.hijoDer());
		}
		else {
			return ejercicio12(a.hijoIzq()) + ejercicio12(a.hijoDer());
		}
		
	}
	
	/****************/
	/****  EJ: 13 ****/
	/****************/
	
	public static int ejercicio13(ABBTDA a) {
		if (a.arbolVacio()) {
	        return 0; 
		}if(a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio() && a.raiz() % 2 == 0) {
			return 1 + ejercicio13(a.hijoIzq())+ ejercicio13(a.hijoDer());
		}
		else {
			return ejercicio13(a.hijoIzq())+ ejercicio13(a.hijoDer());
		}
	}

	/****************/
	/****  EJ: 14 ****/
	/****************/
	public static ConjuntoTDA verticesPuente(GrafoTDA grafo, int verticeOrigen, int verticeDestino) { 
		ConjuntoTDA respuesta = (ConjuntoTDA) new Conjunto(); 
		respuesta.inicializarConjunto();
		
		tda.ConjuntoTDA vertices = grafo.vertices();
		
		while(!vertices.conjuntoVacio()) 
		{
			int posibleVerticePuente = vertices.elegir(); 
			
			//Se pregunta si el vertice que estamos evaluando es puente. 
			//Es decir, si tiene una arista desde verticeOrigen hasta ese vertice Y al mismo tiempo debe tener una arista desde
			// ese vertice a verticeDestino
			if(grafo.existeArista(verticeOrigen, posibleVerticePuente) && grafo.existeArista(posibleVerticePuente, verticeDestino)) {
				
				respuesta.agregar(posibleVerticePuente);
			} 
		}		
		
		return respuesta;
	}
	
	/****************/
	/****  EJ: 15 ****/
	/****************/
	public static int GradoVertice(GrafoTDA grafo, int vertice) { 

	       int aristasSalientes = 0;
	        int aristasEntrantes = 0;

	        tda.ConjuntoTDA vertices = grafo.vertices();

	        while (!vertices.conjuntoVacio()) {
	            int vert = vertices.elegir();
	            
	            //Veo si el vertice que estoy evaluando tiene una arista hacia el vertice que recibo como parametro. 
	            if(vert != vertice && grafo.existeArista(vert, vertice)) 
	            {
	            	aristasEntrantes++;
	            	
	            } //Veo si el vertice que recibo como parametro tiene una arista hacia el vertice que estoy evaluando
	            else if(vert != vertice && grafo.existeArista(vertice, vert)) 
	            {
	            	aristasSalientes++;
	            }
	            else {
	            	// En este caso el vertice es el mismo que el de entrada. Por lo que unico que evaluamos es si tiene un bucle.
	            	// En caso de tener un bucle tiene una arista entrante y saliente a si misma.
	            	if(grafo.existeArista(vert, vertice))
	            	{
		            	aristasSalientes ++;
		            	aristasEntrantes ++;
	            	}
	            }
	            
	            vertices.sacar(vert);      
	        }
	        
	        return aristasSalientes - aristasEntrantes;		
	}


}
