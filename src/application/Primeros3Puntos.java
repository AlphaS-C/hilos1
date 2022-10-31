package application;

import model.ArregloHilo;
import model.MultiplicacionHilo;
import model.NombreHilo;

public class Primeros3Puntos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arreglo[] = {1,3,3};
		ArregloHilo hilo1 = new ArregloHilo(arreglo);
		MultiplicacionHilo hilo2 = new MultiplicacionHilo(2);
		NombreHilo hilo3 = new NombreHilo("Hilo3");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
	}

}
