package problemaJarras;

public class Jarra {//para contener la informacion de cada Jarra
	
	private int size;
	private int cantAgua;
	
	public Jarra(int size, int cantAgua) {
		this.size = size;
		this.cantAgua = cantAgua;
	}
	
	public int getSize() {
		return size;
	}

	public int getCantAgua() {
		return cantAgua;
	}

	public void setCantAgua(int cantAgua) {
		this.cantAgua = cantAgua;
	}
	
	

}
