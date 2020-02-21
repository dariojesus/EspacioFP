package prPractica6;

import java.util.Random;

public class Ejercicio09 {
	
	//Método para cargar un array de números enteros aleatorios
	private static void cargaArray(int [] arry) {
		
		Random rn = new Random();
		
		for(int i = 0 ; i < arry.length ; i++) {
			arry[i]=rn.nextInt(100)+1;
		}
	}
	
	//Método para invertir array dado
	private static void invierte(int [] arry) {
		int aux;
		int elfinal = arry.length-1;
		
		for (int i = 0 ; i < (arry.length/2) ; i++) {
			aux = arry[i];
			arry[i] = arry[elfinal];
			arry[elfinal] = aux;
			
			elfinal--;
		}
	}
	
	/*Metodo privado que muestra el array
	 * 
	 * @param []arry recibe el array que desea mostrar el metodo
	 */
	private static void mostrarArray(int [] arry) {
		System.out.print("Array = [");
		for (int x = 0 ; x < arry.length ; x++) System.out.print(arry[x]+",");
		System.out.print("]");
	}

	
	public static void main(String[] args) {
		
		int [] vector = new int [15];
		
		cargaArray(vector);
		mostrarArray(vector);
		System.out.println();
		System.out.println("-----------------------Inverso-------------------------");
		invierte(vector);
		mostrarArray(vector);

	}

}
