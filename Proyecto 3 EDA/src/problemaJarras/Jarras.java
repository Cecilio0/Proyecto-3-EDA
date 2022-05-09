package problemaJarras;

public class Jarras {//funciona como el objeto que existira dentro del Nodo

	private Jarra jarra4L;
	private Jarra jarra3L;
	private boolean activo;//para determinar si se debe seguir usando para la creacion de nuevas generaciones
	
	public Jarras(int size1, int size2) {
		jarra4L = new Jarra(size1);
		jarra3L = new Jarra(size2);
		activo = true;
	}
	
	public Jarra getJarra4L() {
		return jarra4L;
	}

	public Jarra getJarra3L() {
		return jarra3L;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {//se debera cambiar cuando se repita este Nodo dentro del arbol
		this.activo = activo;
	}

	public void llenar() {//llena una jarra en especifico
	
	}
	
	public void vaciar() {//vacia una jarra en especifico
		
	}
	
	
	//para este metodo se debe restar de la jarra 1 y añadir a la jarra 2 pero nada mas en la medida que 
	//quepa liquido y si cabe todo pasarlo completamente a la jarra 2 y restarlo todo de la jarra1 
	public void trasvasar(Jarra jarra1, Jarra jarra2) {//pasa liquido de una jarra a otra
		
	}
}
