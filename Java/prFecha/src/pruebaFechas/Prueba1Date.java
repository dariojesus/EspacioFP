package pruebaFechas;

import java.util.Date;

public class Prueba1Date {

	public static void main(String[] args) {
		
		// Crear varios objetos tipo Date
		Date fec1 = new Date();
		Date fec2 = new Date(1998, 10, 23);
		Date fec3 = new Date(1518188744443L);
		
		System.out.println("Fecha 1:"+fec1);
		System.out.println("Fecha 2:"+fec2);
		System.out.println("Fecha 3:"+fec3);
		
		System.out.println("Fecha 1 en milisegundos "+fec1.getTime());
		
		if (fec1.before(fec3))
			System.out.println("La fecha 1 es anterior a la fecha 3");
		else
			System.out.println("La fecha 3 es anterior a la fecha 1");
		
		if (fec1.after(fec3))
			System.out.println("La fecha 1 es posterior a la fecha 3");
		else
			System.out.println("La fecha 3 es posterior a la fecha 1");
	}
}
