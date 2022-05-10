package problemaJarras;

import arbolAPS.*;

public class Main {

	public static void main(String[] args) {
		APS<Jarras> arbol = new APS<Jarras>(new Jarras(4,3,0,0));
		SolProblema solucion = new SolProblema(arbol);	
	}

}
