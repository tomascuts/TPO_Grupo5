package implementacion;

import interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
	
	int[] a;
	int cant;

	//Metodo identico al base: ConjuntoTDA
	@Override
	public void inicializar() {
		a = new int[100];
		cant = 0;
	}

	//El metodo "guardar" solo almacena el dato sin importar si ya pertenece. Esto es debido a que no nos importa si esta repetido.
	@Override
	public void guardar(int dato) {
			a[cant] = dato;
			cant++; //nuevo elemento	
	}

	
	// El metodo "sacar" pisa con el ultimo dato a la primer coincidencia que encuentre. 
	// Luego disminuye el contador para "sacar" ese ultimo elemento que copiamos en la posicion original de "dato".
	@Override
	public void sacar(int dato) { 
		int i = 0;
		while (i < cant && a[i] != dato)
			i++;
		if (i < cant){ //elemento encontrado
			a[i] = a[cant-1];
			cant--;
		}
	}

	//Metodo identico al base: ConjuntoTDA
	@Override
	public int elegir() {
		int max = cant-1;
		int min = 0;
		int pos = (int)(Math.random() * (max-min+1) + min);
		return a[pos]; 
	}

	//El metodo "perteneceCant" recorre todo el conjunto y cuando encuentra una coincidencia con dato lo almacena en un contador, para luego poder retornarlo como respuesta.
	@Override
	public int perteneceCant(int dato) {
		int contador=0;
		
        for (int i = 0; i < cant; i++) {
        	
            if (a[i] == dato) {
                contador++;
            }
        }
        return contador;
	}

	@Override
	public boolean estaVacio() {
		return (cant == 0);
	}

}
