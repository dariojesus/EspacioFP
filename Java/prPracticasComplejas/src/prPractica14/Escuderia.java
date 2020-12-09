package prPractica14;

public class Escuderia implements Comparable<Escuderia> {
	private String nombre;
	private int puntos;
	
	public Escuderia (String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public int getPuntos() {return puntos;}

	public void setPuntos(int puntos) {this.puntos = puntos;}

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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escuderia other = (Escuderia) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public String toString() {return "Escuderia : " +this.getNombre()+" - Puntos : "+this.getPuntos();}

	@Override
	public int compareTo(Escuderia o) {
		return this.getNombre().compareToIgnoreCase(o.getNombre());
	}
	
	

}
