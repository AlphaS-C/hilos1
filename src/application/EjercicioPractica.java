package application;

import java.util.Scanner;

public class EjercicioPractica {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Ingrese la palabra a concatenar");
        Scanner in = new Scanner(System.in);
        // "s" es la palabra input de la consola 
        String s = in.nextLine();
        Hilo3 t3 = new Hilo3(s);
        t3.start();
		
	}

}

	// ---------------- Clase Hilo3 --------------------------

// Hilo que ejecuta el hilo 1 y el hilo 2 uno despues de otro
class Hilo3 extends Thread {

	private String mensaje;
	
	// el hilo 3 necesita el mensaje a concatenar
	// porque luego lo usa para crear el hilo 1, que es el que concatena.
	public Hilo3(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public void run() {
		long tac = System.currentTimeMillis() + 30000;
		System.out.println("Hilo 3 en funcionamiento..");
		while(System.currentTimeMillis() < tac) {
			Hilo1 t1 = new Hilo1(mensaje);
			t1.start();
			try {
				t1.join();
				// el hilo 2 lee el hilo 1 con el mensaje 
				// ya concatenado
				Hilo2 t2 = new Hilo2(t1);
				t2.start();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

// ---------------- Clase Hilo1 --------------------------


// El hilo 1 concatena el String por 6 segundos
class Hilo1 extends Thread {
	
	private String mensaje;
	public Hilo1(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public void run() {
		long tac = System.currentTimeMillis() + 6000;
		System.out.println("Concatenando...");
		while(System.currentTimeMillis() < tac) {
			mensaje += mensaje;
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}


// ---------------- Clase Hilo2 --------------------------

// el hilo 2 lee el mensaje concatenado del hilo 1
// lo muestra y lo elimina.
class Hilo2 extends Thread {
	
	private Hilo1 t1;
	// como argumento entra el hilo 1.
	public Hilo2(Hilo1 t1) {
		super();
		this.t1 = t1;
	}
	
	public void run() {
		System.out.println(t1.getMensaje());
		System.out.println("Borrando...");
		t1.setMensaje("");
	}
}

