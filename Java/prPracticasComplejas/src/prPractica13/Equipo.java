package prPractica13;

public class Equipo implements Comparable <Equipo> {
	
	/*
	 * Atributos
	 */
	private String nombre;
	private int ganados;
	private int empatados;
	private int perdidos;
	private int golesRecibidos;
	private int golesMarcados;

	/*
	 * Constructores
	 */
	
	public Equipo(String nombre, int ganados, int empatados, int perdidos, int golesRecibidos, int golesMarcados) {
		super();
		this.nombre = nombre;
		this.ganados = ganados;
		this.empatados = empatados;
		this.perdidos = perdidos;
		this.golesRecibidos = golesRecibidos;
		this.golesMarcados = golesMarcados;
	}
	
	/*
	 * Getters y setters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getEmpatados() {
		return empatados;
	}

	public void setEmpatados(int empatados) {
		this.empatados = empatados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}

	public int getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	public int getGolesMarcados() {
		return golesMarcados;
	}

	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}
	
	/*
	 * Métodos útiles
	 */
	
	public int partidosJugados() {return this.getGanados()+this.getPerdidos()+this.getEmpatados();}
	
	public int puntosAcumulados() {return (this.getGanados()*3) + (this.getEmpatados()*1);}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Equipo))
			return false;
		Equipo other = (Equipo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}
	
	public static boolean sonIguales(Equipo e1, Equipo e2) {return e1.equals(e2);}
	
	public void incGanado() {this.setGanados(this.getGanados()+1);}
	
	public void incEmpatado() {this.setEmpatados(this.getEmpatados()+1);}
	
	public void incPerdido() {this.setPerdidos(this.getPerdidos()+1);}
	
	public void incGolRecibido() {this.setGolesRecibidos(this.getGolesRecibidos()+1);}
	
	public void incGolMarcado() {this.setGolesMarcados(this.getGolesMarcados()+1);}
	
	@Override
	public String toString() {
		return this.getNombre()+"\n"
				+" Partidos Jugados: "+this.partidosJugados()+"\n"
				+" Partidos Ganados: "+this.getGanados()+"\n"
				+" Partidos Empatados: "+this.getEmpatados()+"\n"
				+" Partidos Perdidos: "+this.getPerdidos()+"\n"
				+" Goles a favor: "+this.getGolesMarcados()+"\n"
				+" Goles en contra: "+this.getGolesRecibidos()+"\n"
				+" Puntos acumulados: "+this.puntosAcumulados()+"\n";
	}
	
	public String toStringLineal() {
		return this.partidosJugados()+"  "+this.getGanados()+"  "+this.getEmpatados()+"  "+this.getPerdidos()+"  "
			  +this.getGolesMarcados()+"  "+this.getGolesRecibidos()+"   "+this.puntosAcumulados()+"    "+this.getNombre();
	}

	@Override
	public int compareTo(Equipo o) {
		return this.getNombre().compareToIgnoreCase(o.getNombre());
	}
	
	
	
	

}
