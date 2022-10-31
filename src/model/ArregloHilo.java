package model;

public class ArregloHilo extends Thread{

	private int[] arreglo;
	
	public ArregloHilo() {}
	
	public ArregloHilo(int[] arreglo) {
		this.arreglo = arreglo;
	}
	
	
	public void run() {
		
		for (int i = 0; i< arreglo.length; i++) {
			
			System.out.println("Hilo del arreglo" + arreglo[i]);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
