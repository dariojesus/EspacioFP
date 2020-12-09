package prPractica6;

import java.util.Random;
import java.util.Scanner;

public class LibreriaArray {
	
	public static void cargaTeclado (int [] arry, Scanner sc) {
		
		System.out.println("Introduzca valores (array capacidad "+arry.length+")");
		
		for (int i = 0 ; i < arry.length ; i++) {
			System.out.println("Valor "+(i+1)+" introduzca :");
			arry[i]=sc.nextInt();
		}
		
	}
	
	public static void cargaAleatoria(int [] arry) {
		
		Random rnd = new Random();
		
		System.out.println("Se va a cargar el array de números aleatorios");
		
		for (int i = 0 ; i < arry.length ; i++) 
			arry[i]=rnd.nextInt(100)+1;
		
	}
	
	public static String toString(int [] arry) {
		
		String res = "Array = [";
		
		for (int i = 0 ; i < arry.length ; i++) 
			res+=arry[i]+",";
		
		
		return res+"]";
	}
	
	public static int elementosMax (int [] arry) {
		int resul = arry[0];
		
		for (int i = 1 ; i < arry.length ; i++) 
			if (arry[i]>resul)resul=arry[i];
		
		
		return resul;
	}
	
	public static int elementosMin (int [] arry) {
		int resul = arry[0];
		
		for (int i = 1 ; i < arry.length ; i++) 
			if (arry[i]<resul)resul=arry[i];
		
		
		return resul;
	}
	
	public static int elementosSuma(int [] arry) {
		int sum = 0;
		
		for (int i = 0 ; i < arry.length ; i++)
			sum += arry[i];
		
		return sum;
	}
	
	public static int busquedaLineal(int [] arry, int elem) {
		int cont = 0;
		int resul = -1;
		boolean encontrado = false;
		
		while (cont < arry.length && !encontrado) {
			if (arry[cont]==elem) {
				encontrado=true;
				resul = cont;
			}
			
			cont++;
		}
		
		return resul;
	}
	
	public static int busquedaBinaria(int [] arry, int elem) {
		
		boolean sw = false;
		int mitad, primero = 0, ultimo = arry.length-1;
		
		do{
			mitad = (primero + ultimo)/2;
			
				if(arry[mitad]==elem)
				sw = true;
				
				else if(arry[mitad]<elem)
				primero = mitad+1;
				
				else
				ultimo = mitad-1;
				
		}
		while ((sw == false) && (primero <= ultimo));
		
		if(sw == false)
		return -1;
		return mitad;

	}
	
	public static void ordenBurbuja (int [] arry) {
		int i=1, temp;
		boolean ordenado=false;
		
		while(i<arry.length && ordenado == false){
			ordenado = true;
			
			for(int j=arry.length-1; j>=i; j--){
				
				if(arry[j]<arry[j-1]){
					temp=arry[j];
					arry[j]=arry[j-1];
					arry[j-1]=temp;
					ordenado = false;
				}
			}
		i++;
		}

	}
	
	public static void ordenSeleccion (int [] arry) {
		int pos_menor, menor;
		
			for(int i=0; i<=arry.length-2; i++){
				pos_menor=i;
				menor = arry[i];
				
				for(int j= i+1; j<=arry.length-1; j--){
					
					if(arry[j]<menor){
					pos_menor = j;
					menor = arry[j];
				    }
				}
				
			arry[pos_menor]=arry[i];
			arry[i]=menor;
		}

	}
	
	public static void ordenInsercion (int [] arry) {
		int j, aux;
		
		for (int i = 1; i<(arry.length); i++) {
			
			aux = arry[i];
			j = i-1;
			
			while ((j >= 0) && (arry[j] > aux)) {
					
				arry[j+1] = arry[j];
				j--;
				}
			
			arry[j+1] = aux;
		}

	}
	
	public static void ordenShell (int [] arry) {
		int sw, i, salto, aux, n;
		n = arry.length-1;
		salto = n;
		
		while (salto != 1) {
			sw = 1;
			salto = salto/2;
			
			while (sw!=0) {
				i = 0;
				sw = 0;
				
				while (i <= (n-salto)) {
					
					if (arry[i] > arry[i+salto]) {
						aux = arry[i+salto];
						arry[i+salto] = arry[i];
						arry[i]= aux;
						sw = 1;
						}
					i++;
				}
			}
		}

	}

	public static void desorden (int [] arry) {
		
		Random rnd = new Random ();
		int aux;
		
		for (int i = 0 ; i < arry.length ; i++) {
			int ind = rnd.nextInt(arry.length);
			int cmb = rnd.nextInt(arry.length);
			
			aux = arry[ind];
			arry[ind] = arry[cmb];
			arry[cmb] = aux;
		}
	}
	
	public static boolean insertar (int [] arry, int pos, int num) {
		
		int posreal = pos-1;
		
		if (posreal < 0 || posreal > arry.length) return false;
		
		else {
			
				for (int i = arry.length-1 ; i > posreal ; i--) {
					arry[i]=arry[i-1];
				}
				arry[posreal]=num;
			
			
			return true;
		}
	}

}
