package implementacion;

import interfaz.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
		int[] a;
		int cant;
		
		public void inicializarConjunto() {
			a = new int[100];
			cant = 0;
		}
		
		public void agregar(int x) {
			if (!this.pertenece(x)){ //verificación de no pertenece
				a[cant] = x;
				cant++; //nuevo elemento
			}
		}
		
		public boolean conjuntoVacio() {
			return (cant == 0);
		}
		
		public int elegir() { //arbitrario
			int max = cant-1;
			int min = 0;
			int pos = (int)(Math.random() * (max-min+1) + min);
			return a[pos]; 
		}
		public boolean pertenece(int x) {
			int i = 0;
			while (i < cant && a[i] != x)
				i++;
			return (i < cant);
		}
		
		public void sacar(int x) {
			int i = 0;
			while (i < cant && a[i] != x)
				i++;
			if (i < cant){ //elemento encontrado
				a[i] = a[cant-1];
				cant--;
			}
		}
	
	}
