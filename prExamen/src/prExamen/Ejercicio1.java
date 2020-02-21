package prExamen;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int secreto = 1234;
		int num;
		int errores = 0;
		boolean correcto = false;
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduzca el código de la caja fuerte :");
			num=sc.nextInt();
			
			if (num < 1000 || num > 9999) System.out.println("El código debe tener 4 dígitos.");
			
			else {
				if (num==secreto)correcto=true;
				else {
					System.out.println("Numero secreto incorrecto");
					errores++;
					System.out.println("Lleva "+errores+" intentos");
				}
			}
			
		}while(!correcto && errores<=3);
		
		sc.close();
		
		System.out.println(correcto?"Caja fuerte abierta":"Caja fuerte bloqeuada");
	}

}
