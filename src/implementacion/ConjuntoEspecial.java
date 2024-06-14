package implementacion;

import interfaz.ConjuntoEspecialTDA;

/****************/
/****  EJ: 1 ****/
/****************/

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

	int[] a;
	int cant;
	
	//Metodo identico al base: ConjuntoTDA
	@Override
	public void inicializarConjunto() {
		a = new int[100];
		cant = 0;
	}

	//El metodo "agregar" solo almacena el dato si no pertenece. En estos casos devuelve como respuesta error = false.
	//Caso contrario, es decir si ya pertenece el valor que se intenta agregar, devuelve como respuesta error = true. 
	@Override
	public Respuesta agregar(int valor) {
		Respuesta res = new Respuesta();
		
		if (!this.pertenece(valor)){ //verificación de no pertenece
			a[cant] = valor;
			cant++; //nuevo elemento
			
			res.error = false;
		}else
		{
			res.error = true;
		}		
		
		return res;
	}
	
	//El metodo "sacar" solo saca el dato si existe en el conjunto. En estos casos devuelve como respuesta error = false.
	//Caso contrario, es decir cuando el valor que se intenta sacar no existe en el conjunto, devuelve como respuesta error = true. 
	@Override
	public Respuesta sacar(int valor) {
		Respuesta res = new Respuesta();		
		int i = 0;
		
		while (i < cant && a[i] != valor)
			i++;		
		if (i < cant){ //elemento encontrado
			a[i] = a[cant-1];
			cant--;
			
			res.error = false;
		}else
		{
			res.error = true;
		}	
		
		return res;
	}

	//El metodo "elegir" devuelve un valor random del conjunto, solo si existe alguno. En estos casos el metodo retorna como respuesta error = false y rta = valor elegido.
	//Caso contrario, es decir cuando el conjunto no tiene valores, devuelve como respuesta error = true. 
	@Override
	public Respuesta elegir() {
		Respuesta res = new Respuesta();	
		
		if(!this.conjuntoVacio())
		{
			int max = cant-1;
			int min = 0;
			int pos = (int)(Math.random() * (max-min+1) + min);		
			
			res.rta = a[pos]; 
			res.error = false;
			
		}else 
		{
			res.error = true;
		}
		
		return res;
	}

	//Metodo identico al base: ConjuntoTDA
	@Override
	public boolean pertenece(int valor) {
		int i = 0;
		while (i < cant && a[i] != valor)
			i++;
		return (i < cant);
	}

	//Metodo identico al base: ConjuntoTDA
	@Override
	public boolean conjuntoVacio() {
		return (cant == 0);
	}

}
