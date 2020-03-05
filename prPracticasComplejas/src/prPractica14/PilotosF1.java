package prPractica14;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PilotosF1 {
	
	private Piloto [] pilotos;
	private TreeSet<Escuderia> escuderias;
	private int posLibre = 0;
	
	public PilotosF1() {
		pilotos = new Piloto [22];
		escuderias = new TreeSet<Escuderia>();
	}

	public Piloto[] getPilotos() {return pilotos;}

	public void setPilotos(Piloto[] pilotos) {this.pilotos = pilotos;}

	public int getPosLibre() {return posLibre;}

	public void setPosLibre(int posLibre) {this.posLibre = posLibre;}
	
	public TreeSet<Escuderia> getEscuderias() {
		return escuderias;
	}

	public void setEscuderias(TreeSet<Escuderia> escuderias) {
		this.escuderias = escuderias;
	}

	public boolean addPiloto(Piloto p) {
		int pos = this.getPosLibre();
		
		if ( pos < 22) {
			
			pilotos[pos]=p;
			
			if(!escuderias.contains(new Escuderia (p.getEscuderia())))
				escuderias.add(new Escuderia (p.getEscuderia()));
			
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
			
			int ptoConseguido = this.obtenerPuntos(puesto);
			p.setPuntuacion(p.getPuntuacion()+ptoConseguido);
			escuderiaSumaPuntos(p,ptoConseguido);

			return true;
		}
		
		else return false;
		
		
	}
	
	private void escuderiaSumaPuntos (Piloto p, int pto) {
		
		for (Escuderia e: escuderias) {
			if (e.getNombre().equals(p.getEscuderia())) {
				e.setPuntos(e.getPuntos()+pto);
			}
		}
		
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
	
	public String OrdenarEscuderiaPorPuntos() {
		
		String cad = "";
		for (Escuderia e: this.getEscuderias()) {
			cad+=e.toString()+"\n";
		}
		
		return cad;
	}
	
}
