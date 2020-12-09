package prPractica13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TestClasificacion {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		///////////////////////////FECHAS///////////////////////////////////////////////////////
		Scanner sc = new Scanner (System.in);
		System.out.println("Introducir la fecha del partido: ");
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
		Date fecha = null;
		
		try {
			formatoFecha.setLenient(false); //Controla los a�os bisiestos
			fecha = formatoFecha.parse(sc.next());
			c.setTime(fecha);
		} catch (ParseException e) {System.out.println("Error de parseo");
		
		}catch (NullPointerException e) {System.out.println("Puntero a nulo");}
		
		sc.close();
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		Clasificacion copa = new Clasificacion();
		
		Equipo eq1 = new Equipo("ANTEQUERA CF",0,0,0,0,0);
		Equipo eq2 = new Equipo("M�LAGA CF",3,0,0,2,4);
		Equipo eq3 = new Equipo("MADRID CF",4,5,1,2,8);
		Equipo eq4 = new Equipo("DAW CF",0,0,0,0,0);
		
		copa.a�adirEquipo(eq1);
		copa.a�adirEquipo(eq2);
		copa.a�adirEquipo(eq3);
		copa.a�adirEquipo(eq4);
		
		Partido fase1 = new Partido(eq2,eq1,fecha);
		fase1.setMarcados(4);
		fase1.setRecibidos(1);
		
		Partido fase2 = new Partido(eq4,eq3,new Date("15/01/2020"));
		fase2.setMarcados(3);
		fase2.setMarcados(1);
	
		
		copa.a�adirPartido(fase1);
		
		copa.a�adirPartido(fase2);
		
		System.out.println(copa);
		
		System.out.println(copa.toStringFecha(new Date("15/01/2020")));

		
	


	}

}
