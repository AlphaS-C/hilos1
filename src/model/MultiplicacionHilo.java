package model;

public class MultiplicacionHilo extends Thread{

	private int entero;
	
	public MultiplicacionHilo() {}
	
	public MultiplicacionHilo(int entero) {
		this.entero = entero;
	}
	
	
	public void run() {
		
		int mult = entero;
		for (int i = 0; i<10; i++) {
			
			System.out.println("Hilo de multiplicacion: " + mult);
			mult *= entero;
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
