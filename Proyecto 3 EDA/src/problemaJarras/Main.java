package problemaJarras;

import arbolAPS.*;

public class Main {

	public static void main(String[] args) {
		APS<Jarras> arbol = new APS<Jarras>(new Nodo<Jarras>(new Jarras(0,0)));
		SolProblema solucion = new SolProblema(arbol);	
	}

}
