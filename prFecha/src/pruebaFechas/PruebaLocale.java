package pruebaFechas;
import java.text.DateFormat;
import java.util.*;

public class PruebaLocale {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		c.set(1989, 1, 21); // Febrero 21, 1989
							// el mes se basa en 0, o sea Enero = 0
							// esa fecha es el día que nací
		
		Date d = c.getTime();
		Locale locIT = new Locale("it", "IT"); // Italy
		Locale locPT = new Locale("pt"); // Portugal
		Locale locBR = new Locale("pt", "BR"); // Brazil
		Locale locIN = new Locale("hi", "IN"); // India
		Locale locMEX = new Locale("es", "MX"); // México
		
		DateFormat dfUS = DateFormat.getInstance();
		System.out.println("US " + dfUS.format(d));
		
		DateFormat dfUSfull = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("US largo " + dfUSfull.format(d));
		
		DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
		System.out.println("Italy " + dfIT.format(d));
		
		DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL, locPT);
		System.out.println("Portugal " + dfPT.format(d));
		
		DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
		System.out.println("Brazil " + dfBR.format(d));
		
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
		System.out.println("India " + dfIN.format(d));
		
		DateFormat dfMX = DateFormat.getDateInstance(DateFormat.FULL, locMEX);
		System.out.println("México " + dfMX.format(d));
	}

}
