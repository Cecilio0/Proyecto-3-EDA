package arbolAPS;

public class APS <T extends Comparable<T>>{

	protected Nodo<T> raiz;

	public APS(Nodo<T> raiz) {
		super();
		this.raiz = raiz;
	}

	public APS() {
		super();
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void insertNodo(T llaveN, Nodo<T> padre) {

		raiz = insertNodo(new Nodo<T>(llaveN), padre);
	}

	public Nodo<T> insertNodo(Nodo<T> n, Nodo<T> padre) {//es necesario corregir este metodo
		if (padre == null) {
			padre = n;
		} else {

			Nodo<T> Nodoaux = buscarNodo(padre.getLlave());
			if (Nodoaux.getHijo() == null) {
				Nodoaux.setHijo(Nodoaux);
			} else {
				Nodoaux = Nodoaux.getHijo().getSigHermano();
				while (Nodoaux.getSigHermano() != null) {
					Nodoaux = Nodoaux.getSigHermano();
				}
				Nodoaux.setSigHermano(n);
			}

		}
		return padre;
	}

	public Nodo<T> buscarNodo(T llaveN) {
		return buscarNodo(new Nodo<T>(llaveN), raiz);
	}

	protected Nodo<T> buscarNodo(Nodo<T> n, Nodo<T> r) {
		/*No es necesario para el arbol generico
		int r4 = r.getLlave().getJarra4L().getCantAgua();
		int r3 = r.getLlave().getJarra3L().getCantAgua();
		int n4 = n.getLlave().getJarra4L().getCantAgua();
		int n3 = n.getLlave().getJarra3L().getCantAgua();
		*/
		Nodo<T> a = null;
		Nodo<T> b=null;
		if (r.getLlave().compareTo(n.getLlave()) == 0) {
			return r;
		}  if (r.getLlave() == null && r.getSigHermano() == null) {
			return null;
		}  if (r.getSigHermano() != null) {
			 a = buscarNodo(n, r.getSigHermano());
		}  if (r.getHijo() != null) {
			 b = buscarNodo(n, r.getHijo());
		}
		if(a!=null) return a; else return b;
	}
	/*
	public static void main(String[] args) {
		//esto deja de ser necesario
		Nodo<T> n1 = new Nodo<T>(new Jarras(0, 0));
		Nodo<T> n2 = new Nodo<T>(new Jarras(4, 3));
		Nodo<T> n3 = new Nodo<T>(new Jarras(2, 3));
		Nodo<T> n4 = new Nodo<T>(new Jarras(1, 2));
		Nodo<T> n5 = new Nodo<T>(new Jarras(4, 2));
		
		APS<T> ab = new APS(n1);
		n1.setHijo(n2);	
		n2.setHijo(n4);
		n2.setSigHermano(n3);

		try {
			System.out.println(ab.buscarNodo(n4.getLlave()));
			ab.insertNodo(n5, n1);
			System.out.println(ab.buscarNodo(n5.getLlave()));
		} catch ( e1) {

			e1.printStackTrace();
		}

	}
	*/
	
	
}