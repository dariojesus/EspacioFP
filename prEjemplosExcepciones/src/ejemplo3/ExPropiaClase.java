package ejemplo3;

import Lectura.Leer;

/**
 * Clase desde la que se lanza una excepcion del tipo "ExPropia"
 */

public class ExPropiaClase {
	public void metodo() throws ExPropia {
		System.out.println("Introduzca un n�mero, 0 lanza excepci�n");
		if (Leer.leeInt() == 0)
			throw new ExPropia();
	}

	// otros metodos
}