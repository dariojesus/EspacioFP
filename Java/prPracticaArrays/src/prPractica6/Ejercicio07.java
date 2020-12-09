package prPractica6;

import java.util.Random;

public class Ejercicio07 {
	
	/*
	 * Metodo privado que devuelve true si el valor que se intenta insertar ya esta en el array
	 * 
	 * @params 
	 * 			arry : array a rellenar
	 * 			num : numero que se intenta meter en el array
	 * 			posactual : posicion hasta la que esta lleno el array
	 */
	private static boolean repetido(int posactual,int num, int [] arry) {
		
		int cont = 0;
		boolean repetido = false;
		
		do {
			
			if (arry[cont]==num)repetido = true;
			
			else cont++;
			
		}while (!repetido && cont < posactual);
		
		return repetido;
	}
	
	/*
	 * Metodo privado que muestra el array
	 * 
	 * @param []arry recibe el array que desea mostrar el metodo
	 */
	private static void mostrarArray(int [] arry) {
		System.out.print("Array = [");
		for (int x = 0 ; x < arry.length ; x++) System.out.print(arry[x]+",");
		System.out.print("]");
	}


	public static void main(String[] args) {
		
		int [] vector = new int [50];
		int num;
		Random rnd = new Random ();
		
		vector[0] = rnd.nextInt(100); //Se inicia la pos 0 con un valor random
		
		for (int i = 1 ; i < vector.length ; i++ ) { //Recorremos el array desde la pos 1
			
			do {
				num = rnd.nextInt(100); //Se crea un valor random
				
			}while (!repetido(i,num,vector)); //Si el valor no se ha insertado por que ya existia se vuelve a intentar crear otro distinto
			
			vector[i]=num;
			
		}
		mostrarArray(vector);
	}
	
}


