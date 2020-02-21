package prPractica6;

import java.util.Random;

public class Ejercicio05 {
	
	public static void main(String[] args) {
	
	Random rnd = new Random ();
	int [] vector = new int [20];
	int cont = 0;
	int sum = 0;
	
	//Rellenar el vector
	for (int i = 0 ; i < vector.length; i++ ) {
		vector[i]= rnd.nextInt(100);
	}
	
	//Mostrar los elementos junto a su posicion
	for (int i = 0 ; i < vector.length ; i+=2) {
		
		System.out.println("Posicion "+i+" número "+vector[i]);
		
		if (vector[i]%2 == 0) {
			cont++;
			sum += vector[i];
		}	
	}
	
	System.out.println("Suma de los numeros pares "+sum+" total elementos "+cont);
	
	}

}
