package prPractica14;

import java.util.Calendar;

import libreriaFechas.LFecha;

public class Piloto implements Comparable<Piloto>{
	
	private String nombre;
	private String nacionalidad;
	private Calendar fechaNac;
	private String escuderia;
	private int puntuacion;
	
	public Piloto(String nombre, String nacionalidad, String fechaNac, String escuderia, int puntuacion) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNac = LFecha.convierteCalendar(fechaNac);
		this.escuderia = escuderia;
		this.puntuacion = puntuacion;
	}
	
	public byte getEdad() {return LFecha.getEdad(this.getFechaNac());}
	
	public String getNombre() {return nombre;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getNacionalidad() {return nacionalidad;}
	
	public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
	
	public Calendar getFechaNac() {return fechaNac;}
	
	public void setFechaNac(String fechaNac) {this.fechaNac = LFecha.convierteCalendar(fechaNac);}
	
	public String getEscuderia() {return escuderia;}
	
	public void setEscuderia(String escuderia) {this.escuderia = escuderia;}
	
	public int getPuntuacion() {return puntuacion;}
	
	public void setPuntuacion(int puntuacion) {this.puntuacion = puntuacion;}
	
	public String toString () {
		return this.getPuntuacion()+" - "+this.getNombre()+" ("+this.getNacionalidad()+"), "+this.getEscuderia()+" - "+this.getEdad();
	}

	@Override
	public int compareTo(Piloto p) {
		return p.getPuntuacion()-this.getPuntuacion();
	}
	
}
