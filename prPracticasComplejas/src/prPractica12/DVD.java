package prPractica12;

import java.util.List;

public class DVD implements Comparable <DVD> {

	/*
	 * Atributos
	 */
	private String codigo;
	private String titulo;
	private String director;
	private List<String> actores;
	
	/*
	 * Constructor
	 */
	public DVD(String codigo, String titulo, String director, List<String> actores) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.actores = actores;
	}

	
	/*
	 * Getters y setters
	 */
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) {
		this.actores = actores;
	}
	
	/*
	 * Redefiniciones de metodos
	 */
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actores == null) ? 0 : actores.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {return this.getCodigo()==((DVD) obj).getCodigo();}
	
	@Override
	public String toString() {return this.getCodigo()+": "+this.getTitulo()+
								"( dirigida por "+this.getDirector()+" e interpretada por "+this.getActores().toString()+")";}

	@Override
	public int compareTo(DVD arg0) {return this.getCodigo().compareTo(arg0.getCodigo());}
	
	
}
