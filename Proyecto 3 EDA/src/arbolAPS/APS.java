package arbolAPS;

public class APS <T extends Comparable<T>>{
	
	private Nodo<T> raiz;
	
	public APS(T llave) {
		raiz = new Nodo<T>(llave);
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}
	
	// es necesario hacer los metodos insertar, eliminar y buscar
	
	//para el metodo insertar es sagrado recordar que para la raiz el hermano es null
	
	//para el formato primer hijo siguiente hermano se puede usar la verificacion si n es menor que  
	//el nodo actual que se esta revisando y mayor que el primer hijo de el mismo entonces verificar
	//si es mayor que el siguiente hermano e insertarlo cuando no sea el caso, es necesario tambien 
	//recordar que si esta entre dos hermanos el siguiente hermano se debe reasginar como siguiente
	//hermano del que se acaba de insertar
	public void insertar(T llave) {//valor de retorno puede cambiar
		insertarNodo(new Nodo<T>(llave), raiz);
	}
	
	public void insertarNodo(Nodo<T> n, Nodo<T> r) {//valor de retorno puede cambiar
		
	}
	
	//no le he pensado mucho todavia
	public void eliminarNodo(T llave) {//valor de retorno puede cambiar
		
	}
	
	//para el metodo buscar es importante recordar que si el 
	
	//para el metodo buscar se puede usar la misma logica que para el insertar si la llave es menor
	//que el nodo actual se sigue con el primer hijo y si es mayor que el nodo actual se sigue
	//buscando por el siguiente hermano del primer hijo, asi tambien evitamos problemas con la raiz
	public Nodo<T> buscar() {
	 return null;
	}
	
	
	
	
	
}

