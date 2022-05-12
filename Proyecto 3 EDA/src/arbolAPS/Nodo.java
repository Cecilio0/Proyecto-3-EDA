package arbolAPS;

public class Nodo <T extends Comparable<T>>{
	protected T llave;
	protected Nodo<T> hijo;
	protected Nodo<T> sigHermano;
	protected T padre;

	public Nodo (T llave) {
		this.llave = llave;
		padre = null;
		hijo = null;
		sigHermano = null;
	}

	public Nodo (T llave, Nodo<T> hijo, Nodo<T> sigHermano, T padre) {
		super();
		this.llave = llave;
		this.sigHermano = sigHermano;
		this.hijo = hijo;
		this.padre = padre;
	}

	public T getLlave() {
		return llave;
	}

	public void setLlave(T llave) {
		this.llave = llave;
	}

	public void setHijo(Nodo<T> hijo) {
		 if (hijo != null) {
	            hijo.setPadre(this.llave);
	        }
		this.hijo = hijo;
	}

	public Nodo<T> getHijo() {
		return hijo;
	}

	public Nodo<T> getSigHermano() {
		return sigHermano;
	}

	public T getPadre() {
		return padre;
	}

	public void setPadre(T padre) {
		
		this.padre = padre;
	}

	public void setSigHermano(Nodo<T> hermano) {
		 if (hermano != null) {
	            hermano.setPadre(this.llave);
	        }
		
		this.sigHermano = hermano;
	}

	/*
	public String toString() {
		return "NodoB [llave=" + llave.toString() + ", hijo="
				+ hijo + ", siguienteHermano=" + sigHermano + ", padre=" + padre + "]";
	}
	*/

}