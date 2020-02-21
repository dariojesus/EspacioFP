package prPractica6;

import java.util.Random;

public class Ejercicio08 {
	
	//Método para cargar un array de números enteros aleatorios
	private static void cargaArray(int [] arry) {
		
		Random rn = new Random();
		
		for(int i = 0 ; i < arry.length ; i++) {
			arry[i]=rn.nextInt(100)+1;
		}
	}
	
	//Método para insertar elementos pares y mayores de 25 del array dado en un array auxiliar
	private static int [] paresymayores25(int [] arry) {
		
		int [] aux = new int [arry.length];
		
		for(int i = 0 ; i < arry.length ; i++) {
			if (arry[i]>25 && arry[i]%2 == 0) {
				int inx = indice(aux);
				aux[inx] = arry[i];
			}
		}
		
		return aux;
	}
	
	//Método auxiliar para encontrar el primer indice del array sin elemento
	private static int indice (int [] arry) {
		int cont = 0;
		boolean encontrado = false;
		
		do {
			if (arry[cont]==0)encontrado = true;
			else cont++;
		}
		while(cont < arry.length && !encontrado);
		
		if (encontrado)return cont;
		else return -1;
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
	
	//Muestra el array simple sin el autorrelleno de 0
	private static void mostrarArrayCorto (int [] arry) {
		int cont = 0;
				
		System.out.print("Array = [");
		
		while (cont < arry.length && arry[cont]!=0) {
			System.out.print(arry[cont]+",");
			cont++;
		}
		
		System.out.print("]");
		
	}
	
	
	public static void main(String[] args) {
		int [] enteros = new int [12];
		int [] segundo = new int [12];
	
		cargaArray(enteros);
		segundo = paresymayores25(enteros);
		mostrarArray(enteros);
		System.out.println();
		mostrarArrayCorto(segundo);
	}
	
	

}
