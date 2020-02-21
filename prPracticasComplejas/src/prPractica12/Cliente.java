package prPractica12;

import java.util.HashSet;
import java.util.Iterator;

public class Cliente implements Comparable <Cliente> {
	
	/*
	 * Atributos
	 */
	private String nombre;
	private HashSet <DVD> peliculas;

	
	/*
	 * Constructor
	 */
	public Cliente(String nombre) {
		this.nombre = nombre;
		peliculas = new HashSet<DVD>();
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


	public HashSet<DVD> getPeliculas() {
		return peliculas;
	}


	public void setPeliculas(HashSet<DVD> peliculas) {
		this.peliculas = peliculas;
	}
	
	/*
	 * Metodos de utilidad
	 */
	
	public void alquila(DVD p) {
		if (!peliculas.add(p))
			throw new DVDClubException("No se ha podido alquilar la película");
		}
	
	public DVD devuelve (String t) {
		
		Iterator<DVD> it = peliculas.iterator();
		DVD peli = null;
		boolean encontrado = false;
		
		while(it.hasNext() && !encontrado) {
			peli = it.next();
			if (peli.getTitulo().equalsIgnoreCase(t)) {
				encontrado=true;
				peliculas.remove(peli);
			} 
				
		}
		
		return encontrado?peli:null;
	}

	/*
	 * Metodos redefinidos
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((peliculas == null) ? 0 : peliculas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Cliente cl = (Cliente) obj;
		return this.getNombre().equalsIgnoreCase(cl.getNombre());
	}

	@Override
	public int compareTo(Cliente arg0) {
		return this.getNombre().compareToIgnoreCase(arg0.getNombre());
	}
	
	
	
	
}
