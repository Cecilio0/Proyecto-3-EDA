package arbolAPS;


public class APS {

	protected Nodo raiz;

	public APS(Nodo raiz) {
		super();
		this.raiz = raiz;
	}

	public APS() {
		super();
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void insertNodo(Jarras llaveN, Nodo padre) throws ExceptionNodo {

		raiz = insertNodo(new Nodo(llaveN), padre);
	}

	public Nodo insertNodo(Nodo n, Nodo padre) throws ExceptionNodo {
		if (padre == null) {
			padre = n;
		} else {

			Nodo Nodoaux = buscarNodo(padre.getLlave());
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

	public Nodo buscarNodo(Jarras llaveN) throws ExceptionNodo {
		return buscarNodo(new Nodo(llaveN), raiz);
	}

	protected Nodo buscarNodo(Nodo n, Nodo r) throws ExceptionNodo {
		int r4 = r.getLlave().getJarra4L().getCantAgua();
		int r3 = r.getLlave().getJarra3L().getCantAgua();
		int n4 = n.getLlave().getJarra4L().getCantAgua();
		int n3 = n.getLlave().getJarra3L().getCantAgua();
		Nodo a = null;
		Nodo b=null;
		if (r3 == n3 && n4 == r4) {
			return r;
		}  if (r.getHijo() == null && r.getSigHermano() == null) {
			return null;
		}  if (r.getSigHermano() != null) {
			 a = buscarNodo(n, r.getSigHermano());
		}  if (r.getHijo() != null) {
			 b = buscarNodo(n, r.getHijo());
		}
		if(a!=null) return a; else return b;
	}

	public static void main(String[] args) {

		Nodo n1 = new Nodo(new Jarras(0, 0));
		Nodo n2 = new Nodo(new Jarras(4, 3));
		Nodo n3 = new Nodo(new Jarras(2, 3));
		Nodo n4 = new Nodo(new Jarras(1, 2));
		Nodo n5 = new Nodo(new Jarras(4, 2));

		APS ab = new APS(n1);
		n1.setHijo(n2);	
		n2.setHijo(n4);
		n2.setSigHermano(n3);

		try {
			System.out.println(ab.buscarNodo(n4.getLlave()));
			ab.insertNodo(n5, n1);
			System.out.println(ab.buscarNodo(n5.getLlave()));
		} catch (ExceptionNodo e1) {

			e1.printStackTrace();
		}

	}

	class ExceptionNodo extends Exception {
		public ExceptionNodo(String s) {
			super(s);
		}
	}
}