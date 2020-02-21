package prPractica6;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		int sum = 0;
		boolean par = true;
		int [] vector = new int [20];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0 ; i < vector.length ; i++) {
			System.out.println("Introduzca el número a insertar en el vector : ");
			vector[i]=sc.nextInt();
		}
		
		sc.close();
		vector.toString();
		
		for(int i = 0; i < vector.length ; i++) {
			if (par) sum += i;
			par = !par;
		}
		
		System.out.println("La suma de los numeros pares del vector es : "+sum);
	}

}
