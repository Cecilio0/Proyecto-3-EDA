package problemaJarras;

import arbolAPS.*;

public class SolProblema {//esta clase se ocupa de resolver el problema de las Jarras
	
	private APS<Jarras> arbol;
	
	public SolProblema(APS<Jarras> arbol) {
		this.arbol = arbol;
		resolver();
	}
	
	
	
	public void resolver() {//se encarga de hacer la solucion para el acertijo
		
	}
	
	public void nuevaGeneracion(Nodo<Jarras> nodo, boolean[] combinaciones) {//crea una nueva generacion en el arbol variando un solo dato
		
	}
	
	/*
	devuelve un vector de booleans donde se evidencia cuales variaciones 
	se pueden hacer de generacion a generacion(eg: si la cantidad de agua 
	de la jarra de 4L es 4 entonces no se puede llenar)
	*/
	public boolean[] variacion() {
		return null;
	}
	
	//para mostrar la ruta hacia un Nodo especifico, para facilitar hacer 
	//el metodo es posible hacerlo de manera similar a buscarNodo en APS
	public void mostrarRuta(Nodo<Jarras> nodo) {
		
	}
	
	public boolean isActivo(Nodo<Jarras> nodo) {//revisa si un Nodo esta activo
		return nodo.getLlave().isActivo();
	}
	
	//tambien es necesario pensar en una manera de devolver la respuesta, ya sea con un String o un System.out.print();

}
