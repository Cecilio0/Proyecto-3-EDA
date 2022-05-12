package arbolAPS;

public class Nodo {
	protected Jarras llave;
	protected Nodo hijo;
	protected Nodo sigHermano;
	protected Jarras padre;

	public Nodo(Jarras llave) {
		this.llave = llave;
		padre = null;
		hijo = null;
		sigHermano = null;
	}

	public Nodo(Jarras llave, Nodo hijo, Nodo sigHermano, Jarras padre) {
		super();
		this.llave = llave;
		this.sigHermano = sigHermano;
		this.hijo = hijo;
		this.padre = padre;
	}

	public Jarras getLlave() {
		return llave;
	}

	public void setLlave(Jarras llave) {
		this.llave = llave;
	}

	public void setHijo(Nodo hijo) {
		 if (hijo != null) {
	            hijo.setPadre(this.llave);
	        }
		this.hijo = hijo;
	}

	public Nodo getHijo() {
		return hijo;
	}

	public Nodo getSigHermano() {
		return sigHermano;
	}

	public Jarras getPadre() {
		return padre;
	}

	public void setPadre(Jarras padre) {
		
		this.padre = padre;
	}

	public void setSigHermano(Nodo hermano) {
		 if (hermano != null) {
	            hermano.setPadre(this.llave);
	        }
		
		this.sigHermano = hermano;
	}

	@Override
	public String toString() {
		return "NodoB [llave=" + llave.getJarra4L().getCantAgua() + " " + llave.getJarra3L().getCantAgua() + ", hijo="
				+ hijo + ", siguienteHermano=" + sigHermano + ", padre=" + padre + "]";
	}

}