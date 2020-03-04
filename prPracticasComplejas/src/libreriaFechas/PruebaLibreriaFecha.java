package libreriaFechas;

import java.util.Calendar;

public class PruebaLibreriaFecha {

	public static void main(String[] args) {
		
		System.out.println(LFecha.formatea(LFecha.convierteCalendar("18/07/1997")));
		
		//Metodo para probar copia de fecha
		//System.out.println(LFecha.copiaFecha("15/02/1986"));
		
		//Se prueba el sumado de fecha
		Calendar c = LFecha.convierteCalendar("18/07/1997");
		LFecha.sumaDias(c, 5);
		System.out.println("Fecha con 5 dias sumados: "+LFecha.formatea(c));
		
		LFecha.restaDias(c, 13);
		System.out.println("Fecha con 13 dias restados: "+LFecha.formatea(c));
		
		//Se prueba la edad
		System.out.println("Mi edad es de : "+LFecha.getEdad(c)+" años");

	}

}
