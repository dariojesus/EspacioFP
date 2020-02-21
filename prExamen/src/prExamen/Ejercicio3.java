package prExamen;

import java.util.Scanner;
/*
 * AUTHOR : DARIO JESUS FLORES SEVILLA
 * 
 * EJERCICIO 3 (PROGRAMA : PI)
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		
		double pi;
		int terminos,acumulador=3;
		double term =0.0;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Número de terminos para el cálculo de la serie: ");
		terminos=sc.nextInt();
		sc.close();
		
		if (terminos==1)term=terminos;
		
		else {
			for (int i = 1 ; i<terminos ; i++) {
				
				if(i%2 != 0) {term=term+((double)1/Math.negateExact(acumulador));}
				else {term=term+((double)1/acumulador);}
				
				acumulador = acumulador + 2;
				
				
			}
			
		}
		
		term = term + 1;
		pi = (4.0)*term;
		
		System.out.println("Número PI: "+pi);

	}

}
