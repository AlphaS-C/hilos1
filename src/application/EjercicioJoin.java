package application;


public class EjercicioJoin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int n = 10;
		String palabra = "otorrinolaringologia";
		// Creo las clases aparte debido a que implementan de Runnable
		NumeroFibonnacci r1 = new NumeroFibonnacci(n);
		ContarConsonantes r2 = new ContarConsonantes(palabra);
		Thread t1 = new Thread( r1 );
		Thread t2 = new Thread( r2 );
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		int resultadoFinal = r1.getResultado() * r2.getNumero();
		
		System.out.println("El numero fibonaccii fue: " + r1.getResultado());
		
		System.out.println("El numero de consontantes fue: " + r2.getNumero());
		System.out.println(resultadoFinal);
	}

}

 // ------------------- clase de numero fibonnaccci -----------------

class NumeroFibonnacci implements Runnable {
	
	private int n;
	private int resultado;
	
	public NumeroFibonnacci (int n) {
		this.n = n;
	}

	@Override
	public void run() {

		int ant = 0;
		int ant2 = 1;
		
		for (int i = 0; i < n; i++) {
			resultado = ant + ant2;
			ant = ant2;
			ant2 = resultado;			
		}
		
	}
	
	public int getResultado() {
		return resultado;
	}
	
}

// ------------------- clase de contar consonantes  -----------------

class ContarConsonantes implements Runnable {

	private String palabra;
	private int numeroConsontantes;
	
	public ContarConsonantes (String palabra) {
		this.palabra = palabra;
	}
	
	@Override
	public void run() {
		numeroConsontantes = 0;
		for (int i = 0; i < palabra.length(); i++) {
			char aux = palabra.charAt(i);
			if (aux != 'a' && aux != 'e' && aux != 'i' && aux != 'o' && aux != 'u' ) {
				numeroConsontantes++;
			}
		}
		
	}
	
	public int getNumero() {
		return numeroConsontantes;
	}
	
}
