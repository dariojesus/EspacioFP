package prPractica11;

public class Vivienda extends Propiedad {
	/*
	 * Atributos
	 */
	private tipoVivienda tv;
	private int baños;
	private int dormitorios;
	
	/*
	 * Constante
	 */
	private static final float porVivienda=(float)0.0025;
	
	/*
	 * Constructor
	 */
	public Vivienda(int codigo, String direccion, int metrosCuadrados, String descripcion, float precio, 
			tipoVivienda tv, int baños, int dormitorios) {
		super(codigo, direccion, metrosCuadrados, descripcion, precio, tipoPropiedad.VIVIENDA);
		this.tv=tv;
		this.baños=baños;
		this.dormitorios=dormitorios;
	}
	
	/*
	 * Getters y setters 
	 */
	public tipoVivienda getTv() {return tv;}

	public void setTv(tipoVivienda tv) {this.tv = tv;}

	public int getBaños() {return baños;}

	public void setBaños(int baños) {this.baños = baños;}

	public int getDormitorios() {return dormitorios;}

	public void setDormitorios(int dormitorios) {this.dormitorios = dormitorios;}
	
	/*
	 * Redefinidos
	 */
	
	@Override
	public String toString() {
		return super.toString()
				+"\n Tipo de vivienda: "+this.getTv()
				+"\n Baños: "+this.getBaños()
				+"\n Dormitorios: "+this.getDormitorios();
	}
	
	@Override
	public float beneficio() {return super.beneficio()+porVivienda*super.getPrecio();}
	
	

}
