package problemaJarras;


class JarraLlena extends Exception {

	private static final long serialVersionUID = 1L;

	public JarraLlena() {
		super("La jarra ya esta llena");
	}
}

class JarraVacia extends Exception {

	private static final long serialVersionUID = 1L;

	public JarraVacia() {
		super("La jarra ya esta vacia");
	}
}

class JarraE extends Exception {

	private static final long serialVersionUID = 1L;

	public JarraE() {
		super("La jarra a la que se le quiere pasar esta llena o la que le va a pasar esta vacia");
	}
}

public class Jarras {// funciona como el objeto que existira dentro del Nodo

	private Jarra jarra4L;
	private Jarra jarra3L;
	private boolean activo;// para determinar si se debe seguir usando para la creacion de nuevas
							// generaciones

	public Jarras(int size1, int size2, int cantAgua4L, int cantAgua3L) {
		jarra4L = new Jarra(size1, cantAgua4L);
		jarra3L = new Jarra(size2, cantAgua3L);
		activo = true;
	}

	public Jarra getJarra4L() {
		return jarra4L;
	}

	public Jarra getJarra3L() {
		return jarra3L;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {// se debera cambiar cuando se repita este Nodo dentro del arbol
		this.activo = activo;
	}
	
	//al final estos metodos no parece que vayan a ser necesarios
	public static void llenar(Jarra jarra1) throws JarraLlena {// llena una jarra en especifico
		if (jarra1.getCantAgua() < jarra1.getSize()) {
			jarra1.setCantAgua(jarra1.getSize());
		} else {
			// Excepcion Jarra esta llena
			throw new JarraLlena();
		}
	}

	public static void vaciar(Jarra jarra1) throws JarraVacia {// vaciar una jarra en especifico
		if (jarra1.getCantAgua() > 0) {
			jarra1.setCantAgua(0);
		} else {
			// Excepcion jarra ya esta vacia
			throw new JarraVacia();
		}
	}

	// para este metodo se debe restar de la jarra 1 y añadir a la jarra 2 pero nada
	// mas en la medida que
	// quepa liquido y si cabe todo pasarlo completamente a la jarra 2 y restarlo
	// todo de la jarra1
	public static void trasvasar(Jarra jarra1, Jarra jarra2) throws JarraE {// pasa liquido de una jarra a otra

		// Pasar de jarra1 a jarra 2
		if (jarra1.getCantAgua() < jarra1.getSize() && jarra2.getCantAgua() > 0) { // La jarra tiene espacio y la
																					// otra
																					// tiene liquido
			// Agua de 1 + agua de 2 <= tamano de 1
			if ((jarra1.getCantAgua() + jarra2.getCantAgua()) <= jarra1.getSize()) { // El trasvaso es <= al tamano
																						// de 1
				jarra1.setCantAgua(jarra1.getCantAgua() + jarra2.getCantAgua());
				jarra2.setCantAgua(0);
			} else {
				// Agua de 1 + agua de 2 > tamano de 1
				int temp = jarra1.getSize() - jarra1.getCantAgua();
				jarra1.setCantAgua(jarra1.getCantAgua() + temp);
				jarra2.setCantAgua(jarra2.getCantAgua() - temp);
			}
		} else {
			// Excepcion jarra ya esta llena o vacia
			throw new JarraE();
		}
	}

	// Main Prueba
	public static void main(String[] args) {

//		// arra1 size, jarra2 size , jarra1 cant, jarar2 cant
//		Jarras j = new Jarras(4, 3, 3, 2);
//
//		// Vaciar Prueba
//		System.out.println("Vaciar");
//		System.out.println("Jarra 4l: " + j.getJarra4L().getCantAgua());
//		try {
//			vaciar(j.getJarra4L());
//		} catch (JarraVacia e) {
//			e.getMessage();
//		}
//		System.out.println("Jarra 4l: " + j.getJarra4L().getCantAgua());
//		System.out.println();
//
//		// Llenar
//		System.out.println("LLenar");
//		try {
//			llenar(j.getJarra4L());
//		} catch (JarraLlena e) {
//			e.getMessage();
//		}
//		System.out.println("Jarra 4l: " + j.getJarra4L().getCantAgua());
//		System.out.println();
//
//		// Trasvaso
//		System.out.println("Trasvaso");
//		System.out.println("Jarra4L: " + j.getJarra4L().getCantAgua());
//		System.out.println("Jarra3L: " + j.getJarra3L().getCantAgua());
//		try {
//			trasvasar(j.getJarra4L(), j.getJarra3L());
//		} catch (JarraE e) {
//			e.getMessage();
//		}
//		System.out.println("Jarra 4l: " + j.getJarra4L().getCantAgua());
//		System.out.println("Jarra3L: " + j.getJarra3L().getCantAgua());
	}

}
