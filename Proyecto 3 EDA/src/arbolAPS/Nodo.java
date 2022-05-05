package arbolAPS;

public class Nodo <T extends Comparable<T>>{
	
	private Nodo<T> primHijo;
	private Nodo<T> sigHermano;
	private T llave;
	
	public Nodo(T llave) {
		this.llave = llave;
		this.primHijo = null;
		this.sigHermano = null;
	}

	public Nodo<T> getPrimHijo() {
		return primHijo;
	}

	public void setPrimHijo(Nodo<T> primHijo) {
		this.primHijo = primHijo;
	}

	public Nodo<T> getSigHermano() {
		return sigHermano;
	}

	public void setSigHermano(Nodo<T> sigHermano) {
		this.sigHermano = sigHermano;
	}

	public T getLlave() {
		return llave;
	}

	public void setLlave(T llave) {//no estoy seguro de si es necesario todavia
		this.llave = llave;
	}
	
	
}
