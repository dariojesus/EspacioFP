package prPractica6;

import java.util.Random;

public class Ejercicio06 {

	public static void main(String[] args) {
		
	  float [] vector = new float [20];
	  Random rnd = new Random();
	  float min, max , media = 0;
	  
		//Rellenar el vector
		for (int i = 0 ; i < vector.length; i++) {
			vector[i]= rnd.nextFloat()*10;
		}
		
		//Inicializamos valores
		min = vector[0];
		max = min;
		media = media + max;
		
		//Busqueda de valores clave
		
		for (int i = 1 ; i < vector.length; i++) {
			
			if (vector[i] < min) min = vector[i];
			
			else if (vector[i] > max) max = vector[i];
			
			media += vector[i];
		}
		
		//Salida
		
		for (int x  = 0 ; x < vector.length ; x++) System.out.print(vector[x]+" ");
		System.out.println();
		
		System.out.println("El valor maximo es "+max+
						   "\nEl valor minimo es "+min+
						   "\nLa media es "+media/vector.length);
		
		

	}

}
