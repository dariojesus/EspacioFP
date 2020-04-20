package ejemplo4;
import java.io.*;

public class Ejemplo4ExV2 {

	/**
	 * M�todo que permite leer un fichero y mostrar su contenido
	 * en consola, lleva el control de excepciones
	 * @param nombre
	 */
	public static void leerFichero(String nombre) 
	{ 
		FileInputStream fichero=null; 
		BufferedReader br=null; 
		String l�nea=null; 
		try 
		{ 
			// Crear un objeto para poder acceder al fichero
			fichero=new FileInputStream(nombre);
			br=new BufferedReader(new InputStreamReader(fichero));

			// Leer la primera l�nea del fichero
			l�nea=br.readLine(); 

			// Leer resto de l�neas del fichero
			while (l�nea!=null) { 
				System.out.println(l�nea); 
				l�nea=br.readLine();
			}

			// Cerrar el fichero
			if (br!=null) {
				br.close();
			}
		}
		
		catch (FileNotFoundException e) { 
			System.out.println("FICHERO NO ENCONTRADO");
			e.printStackTrace(); 
		} 
		
		catch (IOException e) { 
			System.out.println("SE HA PRODUCIDO UN ERROR EN EL ACCESO AL FICHERO");
			e.printStackTrace(); 
		} 
		
		// IMPORTANTE!! El orden de los catch tiene que ir de los m�s espec�ficos a los
		// m�s gen�ricos, pod�is hacer la prueba en este ejemplo cambi�ndolos de orden
	}

	/**
	 * M�todo principal
	 * @param args
	 */
	public static void main(String[] args) {

		leerFichero("datos.txt");

	}

}
