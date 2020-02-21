package prExamen;

import java.util.Scanner;

public class Ejercicio4 {
	
	/*
	 * AUTHOR : DARIO JESUS FLORES SEVILLA
	 * 
	 * EJERCICIO 4 DEL EXAMEN (PROGRAMA : CINE)
	 * 
	 */

	public static void main(String[] args) {
		int total;
		float descuento = (float) 0.0;
		byte nEntradas, dia;
		char tarjeta,sig;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			//Pedimos los datos
			System.out.println("Numero de entradas :");
			nEntradas = sc.nextByte();
			System.out.println("Diá de la semana :");
			dia=sc.nextByte();
			System.out.println("¿Tiene tarjeta AmigosCine? (s/n)");
			tarjeta=sc.next().charAt(0);

			System.out.println("Aqui tiene sus entradas.Gracias por su compra.");

			//Segun el dia se realizan unos calculos u otros
			switch(dia) {

			case(3): total = 5 * nEntradas;
						System.out.println("Entradas individuales: "+nEntradas);
						System.out.println("Precio por entrada individual: 5€");
						break;

			case(4): byte pares = (byte) (nEntradas/2);

					System.out.println("Entradas de parejas: "+pares);
					total = pares * 11;
					System.out.println("Precio por entrada de parejas: 11€");
		
					if (nEntradas != pares*2) {
						byte restantes = (byte) (nEntradas - (pares*2));
						total = total + (restantes*8);
						System.out.println("Entradas individuales: "+restantes);
						System.out.println("Precio por entrada individual: 8€");
					}
					break;

			default: total = 8 * nEntradas;
					System.out.println("Entradas individuales: "+nEntradas);
					System.out.println("Precio por entrada individual: 8€");
					break;

			}

			//Aplicamos el descuento al total si tiene tarjeta AmigosCine
			if (tarjeta=='s') {
				descuento = (float) (0.1 * total);
			}

			//Salida de datos
			System.out.println("Total: "+total+" €");
			System.out.println("Descuento: "+descuento+" €");
			System.out.println("Total a pagar: "+(total-descuento)+" €");
			System.out.println("");
			
			//Preguntamos de nuevo
			System.out.println("¿Desea comprar mas entradas?(s/n)");
			sig=sc.next().charAt(0);
			
			total=0;
			descuento=(float) 0.0;
		
		}while(sig=='s');
		
		sc.close();
		System.out.println("Gracias por su compra, hasta pronto.");
		

	}

}
