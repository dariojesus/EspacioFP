package prPractica11;

public class Vivienda extends Propiedad {
	/*
	 * Atributos
	 */
	private tipoVivienda tv;
	private int ba�os;
	private int dormitorios;
	
	/*
	 * Constante
	 */
	private static final float porVivienda=(float)0.0025;
	
	/*
	 * Constructor
	 */
	public Vivienda(int codigo, String direccion, int metrosCuadrados, String descripcion, float precio, 
			tipoVivienda tv, int ba�os, int dormitorios) {
		super(codigo, direccion, metrosCuadrados, descripcion, precio, tipoPropiedad.VIVIENDA);
		this.tv=tv;
		this.ba�os=ba�os;
		this.dormitorios=dormitorios;
	}
	
	/*
	 * Getters y setters 
	 */
	public tipoVivienda getTv() {return tv;}

	public void setTv(tipoVivienda tv) {this.tv = tv;}

	public int getBa�os() {return ba�os;}

	public void setBa�os(int ba�os) {this.ba�os = ba�os;}

	public int getDormitorios() {return dormitorios;}

	public void setDormitorios(int dormitorios) {this.dormitorios = dormitorios;}
	
	/*
	 * Redefinidos
	 */
	
	@Override
	public String toString() {
		return super.toString()
				+"\n Tipo de vivienda: "+this.getTv()
				+"\n Ba�os: "+this.getBa�os()
				+"\n Dormitorios: "+this.getDormitorios();
	}
	
	@Override
	public float beneficio() {return super.beneficio()+porVivienda*super.getPrecio();}
	
	

}
