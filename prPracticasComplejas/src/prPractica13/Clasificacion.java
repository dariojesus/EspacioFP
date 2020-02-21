package prPractica13;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clasificacion {
	
	/*
	 * Atributos
	 */
	private List <Equipo> equipos;
	private List <Partido> partidos;
	
	/*
	 * Constructor
	 */
	public Clasificacion() {
		equipos = new ArrayList <Equipo>();
		partidos = new ArrayList <Partido>();
	}
	
	/*
	 * Métodos útiles
	 */
	
	public boolean añadirEquipo(Equipo eq) {
		if (equipos.contains(eq))return false;
		else {
			equipos.add(eq);
			equipos.sort(null);
			return true;
		}
	}
	
	public boolean añadirPartido(Partido prt) {
		actualizarEquipos(prt);
		return partidos.add(prt);
	}
	
	private void actualizarEquipos(Partido pr) {
		Equipo eq1 = pr.getEq1();
		Equipo eq2 = pr.getEq2();
		
		eq1.setGolesMarcados(eq1.getGolesMarcados()+pr.getMarcados());
		eq1.setGolesRecibidos(eq1.getGolesRecibidos()+pr.getRecibidos());
		
		eq2.setGolesMarcados(eq2.getGolesMarcados()+pr.getRecibidos());
		eq2.setGolesRecibidos(eq2.getGolesRecibidos()+pr.getMarcados());
		
		switch(pr.quiniela()) {
		
		case "1":eq1.setGanados(eq1.getGanados()+1);
				 eq2.setPerdidos(eq2.getPerdidos()+1);
				 break;
				 
		case "2":eq2.setGanados(eq2.getGanados()+1);
		 		 eq1.setPerdidos(eq1.getPerdidos()+1);
		 		 break;
		 		 	 		 
		case "X":eq1.setEmpatados(eq1.getEmpatados()+1);
				 eq2.setEmpatados(eq2.getEmpatados()+1);
				 break;
		}
	}
	
	public String toString() {
		String cad = "CLASIFICACIÓN\n"
				                    +"PJ PG PE PP GF GC Puntos Equipo\n";
		
		for (Equipo e : equipos) {
			cad+=e.toStringLineal()+"\n";
		}
		
		return cad;
	}
	
	public String toStringFecha (Date fecha) {
		@SuppressWarnings("deprecation")
		String cad = "Partidos jugados el "+fecha.getDay()+"-"+fecha.getMonth()+"-"+fecha.getYear()+"\n";
		
		for (Partido p : partidos) {
			if (p.getFecha().equals(fecha)) {
				cad+=p.toString();
			}
		}
		
		return cad;
	}
	

}
