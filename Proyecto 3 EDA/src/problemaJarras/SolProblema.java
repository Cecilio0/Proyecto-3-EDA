package problemaJarras;

import java.util.*;
import arbolAPS.*;

public class SolProblema {// esta clase se ocupa de resolver el problema de las Jarras

	private APS<Jarras> arbol;
	

	public SolProblema(APS<Jarras> arbol) {
		this.arbol = arbol;
		resolver();
	}

	public void resolver() {// se encarga de hacer la solucion para el acertijo
		resolver(arbol.getRaiz());
	}

	public void resolver(Nodo<Jarras> n) {// se encarga de hacer la solucion para el acertijo
		if (cantAgua3L(n) == 2 || cantAgua4L(n) == 2)
			mostrarRuta(n);
		else if (n.getLlave().isActivo()) {
			ArrayList<Nodo<Jarras>> nuevosHijos = nuevaGeneracion(n);
			for (int i = 0; i < nuevosHijos.size(); i++)
				resolver(nuevosHijos.get(i));
		}
	}

	public ArrayList<Nodo<Jarras>> nuevaGeneracion(Nodo<Jarras> n) {// crea una nueva generacion el el arbol variando un solo																		// dato
		ArrayList<Nodo<Jarras>> nuevosHijos = new ArrayList<Nodo<Jarras>>();
		
		if (cantAgua3L(n) != 3) {//llenar 3L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, 3, cantAgua4L(n), 3)));	
		}
		if (cantAgua4L(n) != 4) {//llenar 4L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, 3, 4, cantAgua3L(n))));
		}
		if (cantAgua3L(n) != 0) {//Vaciar 3L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, 3, cantAgua4L(n), 0)));
		}
		if (cantAgua4L(n) != 0) {//Vaciar 4L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, 3, 0, cantAgua3L(n))));
		}
		if (cantAgua4L(n) != 4 && cantAgua3L(n) != 0) {//Trasvasar 3L a 4L 
			int aux3L = cantAgua3L(n);
			int aux4L = cantAgua4L(n);
			while (aux3L != 0 && aux4L != 4) {
				aux4L++;
				aux3L--;
			}
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, 3, aux4L, aux3L)));
		}
		if (cantAgua4L(n) != 0 && cantAgua3L(n) != 3) {//Trasvasar 4L a 3L
			int aux3L = cantAgua3L(n);
			int aux4L = cantAgua4L(n);
			while (aux3L != 3 && aux4L != 0) {
				aux4L--;
				aux3L++;
			}
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, 3, aux4L, aux3L)));
		}
		boolean aux;
		for (int i = 0; i < nuevosHijos.size(); i++) {
			if (aux = verificarRepetido(nuevosHijos.get(i))) {//para no insertar nodos repetidos
				arbol.insertNodo(n, nuevosHijos.get(i));
			}
			nuevosHijos.get(i).getLlave().setActivo(aux);//los pone inactivos para que no se usen en resolver
		}
		return nuevosHijos;
	}

	// para mostrar la ruta hacia un Nodo especifico, para facilitar hacer
	// el metodo es posible hacerlo de manera similar a buscarNodo en APS
	public void mostrarRuta(Nodo<Jarras> n) {
		Stack<Nodo<Jarras>> camino = new Stack<Nodo<Jarras>>();
		Nodo<Jarras> nodo = n;
		while (nodo.getPadre() != null) {
			camino.push(nodo);
			nodo = nodo.getPadre();
		}
		while (!camino.empty()) {
			System.out.println(camino.pop().getLlave().toString() + " ");
		}
	}

	public boolean isActivo(Nodo<Jarras> nodo) {// revisa si un Nodo esta activo
		return nodo.getLlave().isActivo();
	}
	
	public int cantAgua4L(Nodo<Jarras> n) {//mucho texto
		return n.getLlave().getJarra4L().getCantAgua();
	}
	
	public int cantAgua3L(Nodo<Jarras> n) {//mucho texto
		return n.getLlave().getJarra3L().getCantAgua();
	}

	// tambien es necesario pensar en una manera de devolver la respuesta, ya sea
	// con un String o un System.out.print();
	
	public boolean verificarRepetido(Nodo<Jarras> n) {//verifica si ya existe el nodo, devuelve true si no esta repetido
		Nodo<Jarras> aux = arbol.buscarNodo(n.getLlave());
		if (aux != null) 
			return false;
		return true;
	}

}
