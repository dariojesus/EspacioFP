package prPractica11;


public class Propiedad implements Comparable<Propiedad>{
	
	private int codigo;
	private tipoPropiedad tipo;
	private String direccion;
	private int metrosCuadrados;
	private String descripcion;
	private float precio;
	
	//Constantes
	private static final float porBen = (float)0.0075;
	private static final int gastoGestion = 150;
	
	//Constructores
	public Propiedad(int codigo, String direccion, int metrosCuadrados, String descripcion, float precio) {
		this.codigo = codigo;
		this.direccion = direccion;
		this.metrosCuadrados = metrosCuadrados;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public Propiedad(int codigo, String direccion, int metrosCuadrados, String descripcion, float precio, tipoPropiedad tipo) {
		this(codigo,direccion,metrosCuadrados,descripcion,precio);
		this.tipo = tipo;
	}
	
	//Getters y setters
	
	public int getCodigo() {return codigo;}

	public void setCodigo(int codigo) {this.codigo = codigo;}

	public tipoPropiedad getTipo() {return tipo;}

	public void setTipo(tipoPropiedad tipo) {this.tipo = tipo;}

	public String getDireccion() {return direccion;}

	public void setDireccion(String direccion) {this.direccion = direccion;}

	public int getMetrosCuadrados() {return metrosCuadrados;}

	public void setMetrosCuadrados(int metrosCuadrados) {this.metrosCuadrados = metrosCuadrados;}

	public String getDescripcion() {return descripcion;}

	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

	public float getPrecio() {return precio;}

	public void setPrecio(float precio) {this.precio = precio;}
	
	//Metodos pedidos
	
	public float beneficio() {return this.getPrecio()*porBen + gastoGestion;}

	@Override
	public int compareTo(Propiedad p) {
		
		if (this.equals(p))return 0;
		else if (this.getCodigo()>p.getCodigo())return 1;
		else return -1;
	}
	
/*
	//Metodo de orden alternativo
	public class ordenPrecio implements Comparator<Propiedad>{

		public int compare(Propiedad p1, Propiedad p2) {
			if (p1.getPrecio()<p2.getPrecio())return 1;
			else if (p1.getPrecio()>p2.getPrecio())return -1;
			else return 0;
		}
	}
	*/
	
	/*
	 * Redefinidos
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Propiedad p = (Propiedad) obj;
		return this.getCodigo()==p.getCodigo();
	}
	
	@Override
	public String toString() {
		return tipo.getDescripccion()
					+"\n Beneficio obtenido: "+this.beneficio()
					+"\n Código: "+this.getCodigo()
					+"\n Superficie: "+this.getMetrosCuadrados()
					+"\n Descripción: "+this.getDescripcion()
					+"\n Dirección: "+this.getDireccion()
					+"\n Precio: "+this.getPrecio();
	}

}
