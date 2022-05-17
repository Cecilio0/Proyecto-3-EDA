package arbolAPS;


public class ExceptionNodo extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionNodo() {
		super("No existe el nodo padre dentro del arbol");//se explica solo
	}
}
