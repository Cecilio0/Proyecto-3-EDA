package problemaJarras;

public class Jarras implements Comparable<Jarras>{// funciona como el objeto que existira dentro del Nodo

	private Jarra jarra4L;
	private Jarra jarra3L;
	private boolean activo;//para determinar si se debe seguir usando para la creacion de nuevas generaciones
	private String accion;//accion que se desarrollo del paso anterior a este

	public Jarras( int cantAgua4L, int cantAgua3L, String accion) {
		jarra4L = new Jarra(4, cantAgua4L);
		jarra3L = new Jarra(3, cantAgua3L);
		activo = true;
		this.accion = accion;
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

	public void setActivo(boolean activo) {//se debera cambiar cuando se repita este Nodo dentro del arbol
		this.activo = activo;
	}
  
	public String getAccion() {
		return accion;
	}
	
	@Override
	public String toString() {
		return "[jarra4L=" + jarra4L.getCantAgua() + ", jarra3L=" + jarra3L.getCantAgua() + "]";
	}

	@Override
	public int compareTo(Jarras o) {//si las cantidades de agua ambas jarras dentro de Jarras son iguales devuelve 0, de resto 1
		if (this.getJarra3L().getCantAgua() == o.getJarra3L().getCantAgua() && this.getJarra4L().getCantAgua() == o.getJarra4L().getCantAgua()) {
			return 0;
		}
		return 1;
	}
	
}
