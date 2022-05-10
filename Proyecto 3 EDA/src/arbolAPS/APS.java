package arbolAPS;

public class APS <T extends Object>{//Un Arbol Primer hijo Siguiente hermano generico. para el desarollo de este es importante recordar que para este tipo de arbol es posible tener mas de dos hijo
	
	private Nodo<T> raiz;
	
	//hay varios metodos que no son necesarios dentro de nuestro proyecto pero es bueno tenerlos para manetener la forma de un arbol APS generico
	
	public APS() {
		raiz = null;
	}
	
	public APS(T llave) {
		raiz = new Nodo<T>(llave);
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {//es posible que este metodo no sea necesario para nuestro proyecto en especifico
		this.raiz = raiz;
	}
	
	// es necesario hacer los metodos insertar, eliminar y buscar
	
	//para hacer este metodo se usa el Nodo n que es el que queremos insertar y el Nodo 
	//r el cual correspondera al que sera el padre de n
	public void insertNodo(Nodo<T> n, Nodo<T> r) {
		
	}
	
	//simplemente que busque la llave y cambie las relaciones entre Nodos al eliminar el 
	//Nodo de dicha llave
	public void eliminarNodo(T llave) {//es posible que este metodo no sea necesario para nuestro proyecto en especifico
		
	}
	
	//para este metodo se podria hacer una recursion estilo divide y venceras que busque por 
	//el siguiente hijo y el siguiente hermano si es que no son nulos
	public Nodo<T> buscarNodo(T llave) {
	 return null;
	}
	

}

