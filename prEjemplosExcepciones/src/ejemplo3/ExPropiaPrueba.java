package ejemplo3;
/**
 *  Clase para probar la clase ExPropiaClase
 */

public class ExPropiaPrueba {

	public static void main (String[] args) {
		System.out.println("Hola");
		do 
			try {
				ExPropiaClase objeto = new ExPropiaClase();
				objeto.metodo();
			}
			catch(ExPropia e) {
				System.out.println(e);
			}
		while(true);
	}
}
