package ejemplo5;

import Lectura.Leer;

/**
 * Clase para probar el funcionamiento de las clase ExMatriculaValidar
 *
 */
public class ExMatriculaPrincipal {

	public static void main (String[] args) {
		ExMatriculaValidar LaMatricula = new ExMatriculaValidar();

		do 
			try {
				System.out.println("Introduce la matricula: ");
				String Matricula = Leer.leeCadena();
				LaMatricula.validar(Matricula);
			}
			catch(ExMatricula e) {
				switch (e.getMalFormada()) {
					case ExMatricula.MAL_TAMANIO: System.out.println("Tamaño incorrecto"); break;
					case ExMatricula.MAL_LETRA:   System.out.println("Letra inicial no incluida"); break;
			}
		}
		while(true);
	}
}



