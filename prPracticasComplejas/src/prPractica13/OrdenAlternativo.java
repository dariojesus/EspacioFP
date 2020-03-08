package prPractica13;

import java.util.Comparator;

public class OrdenAlternativo implements Comparator<Equipo> {

	@Override
	public int compare(Equipo e1, Equipo e2) {

		int difPuntos = e2.puntosAcumulados()-e1.puntosAcumulados();
		int difGoles = (e2.getGolesMarcados()-e2.getGolesRecibidos()) - (e1.getGolesMarcados()-e1.getGolesRecibidos());
		
		if (difPuntos==0) {
			
			if (difGoles==0) {
				
				return e2.getNombre().compareToIgnoreCase(e1.getNombre());
			}
			
			return difGoles;
		}
		
		return difPuntos;
	}

}
