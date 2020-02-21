package prPractica6;

import java.util.Scanner;

public class PruebaLibreria {

	public static void main(String[] args) {
		int [] array = new int [5];
		
		/*Se ha probado carga aleatoria, string, todos los ordenes, desorden
		 * 
		 * LibreriaArray.cargaAleatoria(array);
		 *
		
		System.out.println(LibreriaArray.toString(array));
		
		System.out.println();
		System.out.println("--------Se va a ordenar el array--------");
		LibreriaArray.ordenInsercion(array);
		
		System.out.println(LibreriaArray.toString(array));
		
		System.out.println();
		System.out.println("--------Se va a desordenar el array--------");
		LibreriaArray.desorden(array);
		
		System.out.println(LibreriaArray.toString(array));
		*/
		
		//Se ha testeado la carga desde teclado
		Scanner sc = new Scanner (System.in);
		LibreriaArray.cargaTeclado(array, sc);
		System.out.println(LibreriaArray.toString(array));
		
		/*
		 * Se han testeado minimos, maximos, suma y posicion
		 * 
		System.out.println("Su posicion es : "+LibreriaArray.busquedaLineal(array,12));
		LibreriaArray.ordenInsercion(array);
		System.out.println(LibreriaArray.toString(array));
		System.out.println("Su posicion es : "+LibreriaArray.busquedaBinaria(array,12));
		
		System.out.println();
		System.out.println("El valor máximo es : "+LibreriaArray.elementosMax(array));
		System.out.println("El valor mínimo es : "+LibreriaArray.elementosMin(array));
		System.out.println("La suma de los valores es : "+LibreriaArray.elementosSuma(array));
		*/
		System.out.println("Introduzca la posicion y el número a insertar");
		LibreriaArray.insertar(array, sc.nextInt(), sc.nextInt());
		sc.close();
		System.out.println(LibreriaArray.toString(array));
		
	}

}
