package prPractica14;

import java.util.Arrays;
import java.util.Scanner;

public class PilotosF1 {
	
	private Piloto [] pilotos;
	private int posLibre = 0;
	
	public PilotosF1() {
		pilotos = new Piloto [22];
	}

	public Piloto[] getPilotos() {return pilotos;}

	public void setPilotos(Piloto[] pilotos) {this.pilotos = pilotos;}

	public int getPosLibre() {return posLibre;}

	public void setPosLibre(int posLibre) {this.posLibre = posLibre;}
	
	public boolean addPiloto(Piloto p) {
		int pos = this.getPosLibre();
		
		if ( pos < 22) {
			pilotos[pos]=p;
			this.setPosLibre(pos+1);
			return true;
		}
		
		else return false;
	}
	
	public int obtenerPuntos(int puesto) {
		switch (puesto) {
			case 1: return 25;
			case 2: return 18;
			case 3: return 15;
			case 4: return 12;
			case 5: return 10;
			case 6: return 8;
			case 7: return 6;
			case 8: return 4;
			case 9: return 2;
			case 10: return 1;
			default: return 0;
		}
	}
	
	public boolean addCarreraPiloto(String nombre, int puesto) {
		Piloto p = buscaPiloto(nombre);
		
		if (p != null) {
			p.setPuntuacion(p.getPuntuacion()+this.obtenerPuntos(puesto));
			return true;
		}
		
		else return false;
		
		
	}
	
	private Piloto buscaPiloto(String nombre) {
		boolean encontrado = false;
		int cont = 0;
		
		while (!encontrado && cont < this.getPosLibre()) {
			if (pilotos[cont].getNombre().equalsIgnoreCase(nombre))encontrado=true;
			else cont++;
		}
		
		return encontrado?pilotos[cont]:null;
	}
	
	public void addGranPremio(String ganadores) {
		int puesto = 1;
		Scanner sc = new Scanner (ganadores);
		sc.useDelimiter(";");
		
		
		while (sc.hasNext()) {
			this.addCarreraPiloto(sc.next(),puesto);
			puesto++;
		}
		
		sc.close();
	}
	
	public String clasificacionPorPilotos() {
		
		Arrays.parallelSort(this.getPilotos(), 0, this.getPosLibre());
		
		String cad = "";
		
		for (int i = 0 ; i < this.getPosLibre() ; i++) cad+=pilotos[i].toString()+"\n";

		return cad;
	}
	
}
