package prPractica6;

import java.util.Random;
import java.util.Scanner;

public class LibreriaArrayObjeto {
	
	/*
	 * Variables de instancia
	 */

	private int [] arry;
	
	/*
	 * Contrsuctores
	 */
	
	public LibreriaArrayObjeto(int tam) {
		this.arry = new int [tam];
	}
	
	public LibreriaArrayObjeto() {
		this(10);
	}
	
	public void cargaTeclado (Scanner sc) {
		
		System.out.println("Introduzca valores (array capacidad "+arry.length+")");
		
		for (int i = 0 ; i < arry.length ; i++) {
			System.out.println("Valor "+(i+1)+" introduzca :");
			arry[i]=sc.nextInt();
		}
		
	}
	
	public void cargaAleatoria () {
		
		Random rnd = new Random();
		
		System.out.println("Se va a cargar el array de números aleatorios");
		
		for (int i = 0 ; i < arry.length ; i++) 
			arry[i]=rnd.nextInt(100)+1;
		
	}
	
	@Override
	public String toString() {
		
		String res = "Array = [";
		
		for (int i = 0 ; i < arry.length ; i++) 
			res+=arry[i]+",";
		
		
		return res+"]";
	}
	
	public int elementosMax () {
		int resul = arry[0];
		
		for (int i = 1 ; i < arry.length ; i++) 
			if (arry[i]>resul)resul=arry[i];
		
		
		return resul;
	}
	
	public int elementosMin () {
		int resul = arry[0];
		
		for (int i = 1 ; i < arry.length ; i++) 
			if (arry[i]<resul)resul=arry[i];
		
		
		return resul;
	}
	
	public int elementosSuma() {
		int sum = 0;
		
		for (int i = 0 ; i < arry.length ; i++)
			sum += arry[i];
		
		return sum;
	}
	
	public int busquedaLineal(int elem) {
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
	
	public int busquedaBinaria(int elem) {
		
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
	
	public void ordenBurbuja () {
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
	
	public void ordenSeleccion () {
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
	
	public void ordenInsercion () {
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
	
	public void ordenShell () {
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

	public void desorden () {
		
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
}
