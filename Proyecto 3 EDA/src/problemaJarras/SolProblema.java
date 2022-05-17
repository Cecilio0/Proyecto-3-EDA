package problemaJarras;

import java.util.*;
import arbolAPS.*;

public class SolProblema {// esta clase se ocupa de resolver el problema de las Jarras

	private APS<Jarras> arbol;

	public SolProblema(APS<Jarras> arbol) throws ExceptionNodo {
		this.arbol = arbol;
		resolver();//al crearse el arbol inmediatamente crea la solucion al problema
	}

	public void resolver() throws ExceptionNodo {// se encarga de hacer la solucion para el acertijo
		resolver(arbol.getRaiz());
	}

	public void resolver(Nodo<Jarras> n) throws ExceptionNodo {// se encarga de hacer la solucion para el acertijo
		if (cantAgua3L(n) == 2 || cantAgua4L(n) == 2)
			mostrarRuta(n);
		else if (n.getLlave().isActivo()) {//unicamente crea generaciones si esta activo el nodo que se le envio
			ArrayList<Nodo<Jarras>> nuevosHijos = nuevaGeneracion(n);
			for (int i = 0; i < nuevosHijos.size(); i++)
				resolver(nuevosHijos.get(i));//se envia el ArrayList de los hijos de la nueva generacion al metodo resolver
		}
	}

	public ArrayList<Nodo<Jarras>> nuevaGeneracion(Nodo<Jarras> n) throws ExceptionNodo {// crea una nueva generacion el el arbol variando un solo																		// dato
		ArrayList<Nodo<Jarras>> nuevosHijos = new ArrayList<Nodo<Jarras>>();
		
		if (cantAgua3L(n) != 3) {//llenar 3L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(cantAgua4L(n), 3, " se llena la jarra de 3L ")));	
		}
		if (cantAgua4L(n) != 4) {//llenar 4L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(4, cantAgua3L(n), " se llena la jarra de 4L ")));
		}
		if (cantAgua3L(n) != 0) {//Vaciar 3L
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(cantAgua4L(n), 0, " se vacia la jarra de 3L ")));
		}
		if (cantAgua4L(n) != 0) {//Vaciar 4L 
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(0, cantAgua3L(n), " se llena la jarra de 4L ")));
		}
		if (cantAgua4L(n) != 4 && cantAgua3L(n) != 0) {//Trasvasar 3L a 4L 
			int aux3L = cantAgua3L(n);
			int aux4L = cantAgua4L(n);
			while (aux3L != 0 && aux4L != 4) {
				aux4L++;
				aux3L--;
			}
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(aux4L, aux3L, " se trasvasa de la jarra 3L a la de 4L ")));
		}
		if (cantAgua4L(n) != 0 && cantAgua3L(n) != 3) {//Trasvasar 4L a 3L
			int aux3L = cantAgua3L(n);
			int aux4L = cantAgua4L(n);
			while (aux3L != 3 && aux4L != 0) {
				aux4L--;
				aux3L++;
			}
			nuevosHijos.add(new Nodo<Jarras>(new Jarras(aux4L, aux3L, " se trasvasa de la jarra 4L a la de 3L ")));
		}
		boolean aux;
		for (int i = 0; i < nuevosHijos.size(); i++) {
			if (aux = verificarRepetido(nuevosHijos.get(i), n)) {//para no insertar nodos repetidos
				arbol.insertNodo(nuevosHijos.get(i), n);
			}
			nuevosHijos.get(i).getLlave().setActivo(aux);//los pone inactivos para que no se usen en resolver
		}
		return nuevosHijos;//devuelve el ArrayList con todos los de la posible nueva generacion
	}

	// para mostrar la ruta hacia un Nodo especifico, para facilitar hacer
	public void mostrarRuta(Nodo<Jarras> n) {
		Stack<Nodo<Jarras>> camino = new Stack<Nodo<Jarras>>();//crea una pila
		Nodo<Jarras> nodo = n;
		while (nodo.getPadre() != null) {//recorre todos los padres hasta que el padre sea nulo
			camino.push(nodo);
			while (nodo.getPadre() != null && nodo.getPadre().getSigHermano() == nodo) {
				nodo = nodo.getPadre(); 
			}
			nodo = nodo.getPadre();
		}
		camino.push(nodo);//se inserta el ultimo nodo
		System.out.println("Cantidad de pasos de la ruta(contando estado inicial): "+camino.size());
		while (!camino.empty()) {
			nodo = camino.pop();
			System.out.print(nodo.getLlave().getAccion() + nodo.getLlave().toString());//se imprime la ruta 
		}
		System.out.println();
		System.out.println();
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
	
	public boolean verificarRepetido(Nodo<Jarras> n, Nodo<Jarras> r) {//verifica si ya existe el nodo, devuelve true si no esta repetido
		/*
		Nodo<Jarras> aux = arbol.buscarNodo(n.getLlave());
		if (aux != null) //si es distinto de nulo quiere decir que si encontro un nodo con esa llave
			return false;
		return true;
		*/
		Nodo<Jarras> nodo = r;
		while (nodo != null && nodo.getLlave().compareTo(n.getLlave()) != 0) {//que existan mas padres y que no sean iguales
			while (nodo.getPadre() != null && nodo.getPadre().getSigHermano() == nodo) {
				nodo = nodo.getPadre(); 
			}
			nodo = nodo.getPadre();
		}
		if (nodo != null)//distinto de nulo, es decir, si lo encontro
			return false;
		return true;
		
	}

}
