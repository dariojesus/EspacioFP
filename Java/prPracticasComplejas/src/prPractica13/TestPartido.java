package prPractica13;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class TestPartido {

	public static void main(String[] args) {
	
		///////////////////////////FECHAS///////////////////////////////////////////////////////
		Scanner sc = new Scanner (System.in);
		System.out.println("Introducir la fecha del partido: ");
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
		Date fecha = null;
		
		try {
			formatoFecha.setLenient(false); //Controla los años bisiestos
			fecha = formatoFecha.parse(sc.next());
			c.setTime(fecha);
		} catch (ParseException e) {System.out.println("Error de parseo");
		
		}catch (NullPointerException e) {System.out.println("Puntero a nulo");}
		
		sc.close();
		////////////////////////////////////////////////////////////////////////////////////////
		
		Equipo eq = new Equipo("ANTEQUERA CF",3,2,1,3,10);
		Equipo eq1 = new Equipo("MÁLAGA CF",5,2,4,2,15);
		
		Partido match = new Partido(eq,eq1,fecha);
		
		match.setMarcados(2);
		match.setRecibidos(3);
		System.out.println(match.toString());
		System.out.println(match.quiniela());

	}

}
