package model;

public class NombreHilo extends Thread{

	private String nombre;
	
	public NombreHilo() {}
	
	public NombreHilo(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void run() {
		
		for (int i = 0; i<=15; i++) {
			
			System.out.println("Hilo del nombre:" + nombre);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
