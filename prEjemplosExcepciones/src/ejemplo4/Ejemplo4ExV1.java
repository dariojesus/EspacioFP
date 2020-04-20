package ejemplo4;
import java.io.*;

public class Ejemplo4ExV1 {

	/**
	 * Método que permite leer un fichero y mostrar su contenido
	 * en consola, lleva el control de excepciones
	 * @param nombre
	 */
	public static void leerFichero(String nombre) 
	{ 
		FileInputStream fichero=null; 
		BufferedReader br=null; 
		String línea=null; 
		
		// ------------------------------------------------------------
		// --------------- Apertura del fichero -----------------------
		// ------------------------------------------------------------
		try { 
			// Crear un objeto para poder acceder al fichero
			fichero=new FileInputStream(nombre);
			br=new BufferedReader(new InputStreamReader(fichero));
		} 
		catch (FileNotFoundException e) { 
			System.out.println("FICHERO NO ENCONTRADO");
			e.printStackTrace(); 
		} 

		// ------------------------------------------------------------
		// ---------- Lectura de la primera línea del fichero ---------
		// ------------------------------------------------------------
		try { 
			// Leer la primera línea del fichero
			línea=br.readLine(); 
		} 
		catch (IOException e) { 
			System.out.println("SE HA PRODUCIDO UN ERROR EN LA LECTURA");
			e.printStackTrace(); 
		} 

		// ------------------------------------------------------------
		// ---------- Lectura del resto de líneas del fichero ---------
		// ------------------------------------------------------------
		while (línea!=null)  { // Recorrer el fichero hasta que no haya más líneas
			
			System.out.println(línea); // Imprimo en consola la línea leída
			try { 
				línea=br.readLine(); // Leo una nueva línea
			} 
			catch (IOException e) { 
				System.out.println("SE HA PRODUCIDO UN ERROR EN LA LECTURA");
				e.printStackTrace(); 
			} 
		} 
		
		
		// ------------------------------------------------------------
		// ----------------------- Cierre del fichero -----------------
		// ------------------------------------------------------------
		if (br!=null) {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("SE HA PRODUCIDO UN ERROR AL CERRAR EL FICHERO");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {

		leerFichero("datos.txt");

	}

}
