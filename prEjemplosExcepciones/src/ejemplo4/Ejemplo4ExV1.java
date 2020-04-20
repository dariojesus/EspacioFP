package ejemplo4;
import java.io.*;

public class Ejemplo4ExV1 {

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
		// ---------- Lectura de la primera l�nea del fichero ---------
		// ------------------------------------------------------------
		try { 
			// Leer la primera l�nea del fichero
			l�nea=br.readLine(); 
		} 
		catch (IOException e) { 
			System.out.println("SE HA PRODUCIDO UN ERROR EN LA LECTURA");
			e.printStackTrace(); 
		} 

		// ------------------------------------------------------------
		// ---------- Lectura del resto de l�neas del fichero ---------
		// ------------------------------------------------------------
		while (l�nea!=null)  { // Recorrer el fichero hasta que no haya m�s l�neas
			
			System.out.println(l�nea); // Imprimo en consola la l�nea le�da
			try { 
				l�nea=br.readLine(); // Leo una nueva l�nea
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
	 * M�todo principal
	 * @param args
	 */
	public static void main(String[] args) {

		leerFichero("datos.txt");

	}

}
