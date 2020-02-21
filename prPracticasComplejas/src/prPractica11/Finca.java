package prPractica11;

public class Finca extends Propiedad {
	
	private tipoTerreno tipoT;
	private boolean luz;
	private boolean agua;
	private boolean vivienda;
	
	
	/*
	 * Constante
	 */
	private static final float porFinca = (float)0.005;
	
	/*
	 * Constructor
	 */
	public Finca(int codigo, String direccion, int metrosCuadrados, String descripcion, float precio, 
				tipoTerreno tipoT,boolean luz, boolean agua,boolean vivienda) {
					super(codigo, direccion, metrosCuadrados, descripcion, precio, tipoPropiedad.FINCA);
					this.tipoT=tipoT;
					this.luz=luz;
					this.agua=agua;
					this.vivienda=vivienda;
		
	}

	/*
	 * Getters y setters 
	 */
	public tipoTerreno getTipoT() {return tipoT;}

	public void setTipoT(tipoTerreno tipoT) {this.tipoT = tipoT;}

	public boolean isLuz() {return luz;}

	public void setLuz(boolean luz) {this.luz = luz;}

	public boolean isAgua() {return agua;}

	public void setAgua(boolean agua) {this.agua = agua;}

	public boolean isVivienda() {return vivienda;}

	public void setVivienda(boolean vivienda) {this.vivienda = vivienda;}
	
	/*
	 * Redefinidos
	 */
	
	@Override
	public String toString () {
		return super.toString()
				+"\n Terreno: "+this.getTipoT()
				+"\n Luz: "+(this.isLuz()?"Si":"No")
				+"\n Agua: "+(this.isAgua()?"Si":"No")
				+"\n Vivienda: "+(this.isVivienda()?"Si":"No");
	}
	
	@Override
	public float beneficio() {return super.beneficio()+porFinca*super.getPrecio();}
	
	
	
	

}
