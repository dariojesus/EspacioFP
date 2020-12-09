package prPractica12;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DVDClub {
	
	/*
	 * Atributos
	 */
	SortedSet <DVD> peliculas;
	SortedSet <Cliente> socios;
	
	/*
	 * Constructor
	 */
	
	public DVDClub() {
		peliculas = new TreeSet <DVD>();
		socios = new TreeSet <Cliente>();
	}
	
	/*
	 * Getters y setters
	 */

	public SortedSet<DVD> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(SortedSet<DVD> peliculas) {
		this.peliculas = peliculas;
	}

	public SortedSet<Cliente> getSocios() {
		return socios;
	}

	public void setSocios(SortedSet<Cliente> socios) {
		this.socios = socios;
	}
	
	/*
	 * Métodos útiles
	 */
	
	public void añadeCliente(Cliente c) {
		if(!socios.add(c))
			throw new DVDClubException("No se ha podido añadir el cliente.");}
	
	public void añadePelicula(DVD p) {
		if(!peliculas.add(p))
			throw new DVDClubException("No se ha podido añadir la película.");}
	
	public DVD sacarPelicula (String titulo) {
		Iterator <DVD> it = peliculas.iterator();
		boolean esta = false;
		DVD pel = null;
		
		while(it.hasNext() && !esta) {
			pel=it.next();
				if (pel.getTitulo().equalsIgnoreCase(titulo))
					esta=true;
		}
		
		if (esta) {
			peliculas.remove(pel);
			return pel;
		}
		
		else return null;
		
		
	}
	
	public Cliente cliente(String nombre) {
		Iterator <Cliente> it = socios.iterator();
		boolean esta = false;
		Cliente cl = null;
		
		while(it.hasNext() && !esta) {
			cl=it.next();
				if (cl.getNombre().equalsIgnoreCase(nombre))
					esta=true;
		}
		
		return esta?cl:null;
	}
	
	public void alquila (String titulo, String nombre) {
		DVD p = this.sacarPelicula(titulo);
		Cliente c = this.cliente(nombre);
		
		if (p==null) {
			throw new DVDClubException("No se ha podido encontrar la pelicula.");
		}
		
		if (c==null) {
			this.añadePelicula(p);
			throw new DVDClubException("No se ha podido encontrar el cliente");
		}
		
	    c.alquila(p);
	}
	
	public void devuelve (String titulo, String nombre) {
		Cliente c = this.cliente(nombre);
		DVD p = c.devuelve(titulo);
		
		if ( p != null) {
			peliculas.add(p);
		}
		
		else 
			throw new DVDClubException("No se ha devuelto la pelicula correctamente");
	}
	
	public String disponible () {
		String cad = "";
		
		for (DVD pelis : peliculas) {
			cad+=pelis+"\n";
		}
		
		return cad;
	}
	
	public String alquiladas(String nombre) {return this.cliente(nombre).getPeliculas().toString();}
	
	public SortedSet<DVD> copias(String titulo){
		
		SortedSet <DVD> iguales = new TreeSet<DVD>();
		
		for (DVD pelis: this.getPeliculas()) {
			if (pelis.getTitulo().compareToIgnoreCase(titulo)==0)
				iguales.add(pelis);
		}
		
		return iguales;
	}
	
	public Set<DVD> getPeliculasCliente(String nomCli){
		
		Set<DVD> peliCliente = new TreeSet <DVD>();
		Cliente c = this.cliente(nomCli);
		
		for(DVD pelis : c.getPeliculas())
			peliCliente.add(pelis);
		
		return peliCliente;
		
	}

}
