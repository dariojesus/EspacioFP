package ejemplo2;

import Lectura.Leer;

/** Clase para probar excepciones
 * 
 *   Utiliza varios bloques catch, uno para controlar las divisiones por cero,
 *   y otro para controlar posiciones no válidas en el array
 */
   
public class Excepcion2 {
   public static void main(String[] args) {
   
	   int posicion=0;
    
	   do{
		   try {
			   float[] valores = new float[5];

			   System.out.print("Posicion: ");
			   posicion = Leer.leeInt();

			   System.out.print("Valor: ");
			   int valor = Leer.leeInt();

			   float auxiliar = 8/valor;

			   valores[posicion] = auxiliar;
		   }

		   catch (ArithmeticException e) {
			   System.out.println("Division por cero");
			   e.printStackTrace();
			   System.out.println("Motivo del error: "+e.getMessage());
			   // El método printStackTrace provoca la impresión de un breve mensaje acerca de
			   // la excepcion, seguido de la pila de ejecucion de los métodos del programa 
			   // (en este caso sólo el método main)
		   }

		   catch(IndexOutOfBoundsException e) {  // Indice fuera del array
			   System.out.println("Indice fuera del array");
			   e.printStackTrace();
		   }

		   System.out.println("Hola");

	   } 
	   while (posicion!=10);
   }
}