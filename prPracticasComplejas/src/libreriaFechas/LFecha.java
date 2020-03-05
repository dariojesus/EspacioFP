package libreriaFechas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LFecha {

	public static byte getEdad(Calendar fechaNac) {
		Calendar hoy = Calendar.getInstance();
		Long miliDia = 86400000L;
		return (byte) ((hoy.getTimeInMillis()-fechaNac.getTimeInMillis())/(miliDia*365));

	}
	
	public static void restaDias(Calendar c, int dias) {
		LFecha.sumaDias(c, (dias*-1));
	}
	
	public static void sumaDias(Calendar c, int dias) {
		c.add(Calendar.DAY_OF_MONTH, dias);
	}

	public static Calendar copiaFecha(String fecha) {
		return (Calendar) LFecha.convierteCalendar(fecha).clone();
		
	}
	
	public static Calendar convierteCalendar (String fecha){
	
		Calendar cal = null;
		
		try {
			cal = LFecha.valida(fecha).getCalendar();
		
		   }catch (NullPointerException e) {System.out.println("Puntero a nulo");}

		return cal;
	}
	
	private static DateFormat valida (String fecha) {
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy", Locale.getDefault());
		
		df.setLenient(false); //Quitamos el lenient para evitar sumas de fechas cuando es incorrecta
		
		try {
			
			df.parse(fecha);
		
			} catch (ParseException e) {
			return null;
		}
		
		return df;
	}
	
	public static String formatea (Calendar c) {
		SimpleDateFormat formato = new SimpleDateFormat("EEEE dd-MMM-yyyy");
		return formato.format(c.getTime());
	}
	
}
