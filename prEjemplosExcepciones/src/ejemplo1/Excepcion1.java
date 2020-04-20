package ejemplo1;
/** Clase para probar excepciones
   
   � Captura una excepcion "ArithmeticException", aunque esta no es necesario tratarla
     en algunos casos puede resultar conveniente.
   
   � Implementa un bucle sin fin que recoge un valor entero suministrado por el usuario
     y lo utiliza como denominador en una divisi�n.
   
   � El bloque "catch" atiende �nicamente a excepciones de tipo "ArithmeticException"
     imprimiendo el mensaje "Divisi�n por cero".
*/

import Lectura.Leer;

public class Excepcion1 {
	public static void main(String[] args) {

		// System.out.println("Prueba "+(5/0));
		do {
			try {
				System.out.print("Introduzca valor num�rico: ");
				int valor = Leer.leeInt();
				float auxiliar = 8/valor;
				System.out.println(auxiliar);
			}
			catch (ArithmeticException e) {
				System.out.println("Division por cero");
			}
			System.out.println("Despues del catch");
		} 
		while (true);
	}
}
