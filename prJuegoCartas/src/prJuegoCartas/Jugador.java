package prJuegoCartas;

public class Jugador {
	
	/*
	 * Variables de instancia
	 */
	
	private String nombre;
	private int puntuacion;
	
	/*
	 * Constructor
	 */
	
	public Jugador(String nombre) {
		this.nombre=nombre;
		this.puntuacion=0;
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

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	/*
	 * Método para mostrar por pantalla la informacion del jugador
	 */
	
	@Override
	public String toString() {
		return "Jugador: "+this.getNombre()+"\nPuntuación: "+this.getPuntuacion();
	}
	

}
