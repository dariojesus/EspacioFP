package prPractica15;

import java.util.Calendar;

import libreriaFechas.LFecha;

public class Siembra implements Comparable<Siembra> {
	
	private String producto;
	private Calendar fecInicio;
	private Calendar fechFin;
	private String persona;
	
	public Siembra (String producto, String fecInicio, String persona) {
		this.producto=producto;
		this.fecInicio=LFecha.convierteCalendar(fecInicio);
		this.persona=persona;
	}

	public String getProducto() {return producto;}

	public void setProducto(String producto) {this.producto = producto;}

	public Calendar getFecInicio() {return fecInicio;}

	public void setFecInicio(Calendar fecInicio) {this.fecInicio = fecInicio;}

	public Calendar getFechFin() {return fechFin;}

	public void setFechFin(String fechFin) {this.fechFin = LFecha.convierteCalendar(fechFin);}

	public String getPersona() {return persona;}

	public void setPersona(String persona) {this.persona = persona;}
	
	public int diasDeSiembra() {
		return (int) ((this.getFechFin().getTimeInMillis()-this.getFecInicio().getTimeInMillis())/86400000L);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecInicio == null) ? 0 : fecInicio.hashCode());
		result = prime * result + ((fechFin == null) ? 0 : fechFin.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		Siembra other = (Siembra) obj;
		if (fecInicio == null) {
			if (other.fecInicio != null)
				return false;
		} else if (!fecInicio.equals(other.fecInicio))
			return false;
		if (fechFin == null) {
			if (other.fechFin != null)
				return false;
		} else if (!fechFin.equals(other.fechFin))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	public String toString() {
		return "\nSiembra: "+this.getProducto()+" se sembró el "+LFecha.formatea(this.getFecInicio())+" y se recogió "+LFecha.formatea(this.getFechFin())+".\n"
			   +"La cosecha duró "+this.diasDeSiembra()+" días.\n"
			   +"Arrendatario: "+this.getPersona()+"\n";
	}

	@Override
	public int compareTo(Siembra s) {
		return this.getFecInicio().compareTo(s.getFecInicio());
	}
	
	
	

}
