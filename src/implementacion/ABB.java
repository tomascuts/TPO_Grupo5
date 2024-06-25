package implementacion;

import interfaz.ABBTDA;

public class ABB implements ABBTDA {
	private class NodoABB{
		int info;
		ABBTDA hI;
		ABBTDA hD;
	}
	
	NodoABB raiz;
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		raiz = null;
		
	}

	@Override
	public void agregar(int v) {
		// TODO Auto-generated method stub
		if(raiz == null) {
			raiz = new NodoABB();
			raiz.info = v;
			raiz.hI = new ABB();
			raiz.hI.inicializar();
			raiz.hD = new ABB();
			raiz.hD.inicializar();		
		}else if(raiz.info > v) {
			raiz.hI.agregar(v);
		}else if(raiz.info < v) {
			raiz.hD.agregar(v);
		}
		
	}

	@Override
	public void eliminar(int v) {
		// TODO Auto-generated method stub
		if(raiz != null) {
			if(raiz.info == v && raiz.hD.arbolVacio() && raiz.hI.arbolVacio()) {
				raiz = null;
			}else if(raiz.info == v && !raiz.hI.arbolVacio()) {
				int mayor = mayor(raiz.hI);
				raiz.info = mayor;
				raiz.hI.eliminar(mayor);
			}else if(raiz.info == v && !raiz.hD.arbolVacio()) {
				int menor = menor(raiz.hD);
				raiz.info = menor;
				raiz.hD.eliminar(menor);
			}else if(raiz.info > v) {
				raiz.hI.eliminar(v);
			}else {
				raiz.hD.eliminar(v);
			}
			
		}
		
	}

	@Override
	public int raiz() {
		// TODO Auto-generated method stub
		return raiz.info;
	}

	@Override
	public ABBTDA hijoIzq() {
		// TODO Auto-generated method stub
		return raiz.hI;
	}

	@Override
	public ABBTDA hijoDer() {
		// TODO Auto-generated method stub
		return raiz.hD;
	}
	private int mayor(ABBTDA raiz) {
		if(raiz.hijoDer().arbolVacio())
			return raiz.raiz();
		else
			return mayor(raiz.hijoDer());
	}
	private int menor(ABBTDA raiz) {
		if(raiz.hijoIzq().arbolVacio())
			return raiz.raiz();
		else
			return menor(raiz.hijoIzq());
	}

	@Override
	public boolean arbolVacio() {
		return raiz == null;
	}

	

}
