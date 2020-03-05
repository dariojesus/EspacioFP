package prPractica15;

import java.util.ArrayList;
import java.util.List;

public class Parcela {
	
	private String localizacion;
	private int metros;
	private int precio;
	private boolean barbecho;
	private List<String> recomendados;
	private List<Siembra> cultivos;
	
	public Parcela(String localizacion, int metros, int precio, boolean barbecho) {
		
		this.localizacion = localizacion;
		this.metros = metros;
		this.precio = precio;
		this.barbecho = barbecho;
		recomendados = new ArrayList <String>();
		cultivos = new ArrayList <Siembra>();
	}

	public String getLocalizacion() {return localizacion;}

	public void setLocalizacion(String localizacion) {this.localizacion = localizacion;}

	public int getMetros() {return metros;}

	public void setMetros(int metros) {this.metros = metros;}

	public int getPrecio() {return precio;}

	public void setPrecio(int precio) {this.precio = precio;}

	public boolean isBarbecho() {return barbecho;}

	public void setBarbecho(boolean barbecho) {this.barbecho = barbecho;}

	public List<String> getRecomendados() {return recomendados;}

	public void setRecomendados(List<String> recomendados) {this.recomendados = recomendados;}

	public List<Siembra> getCultivos() {return cultivos;}

	public void setCultivos(List<Siembra> cultivos) {this.cultivos = cultivos;}
	
	public boolean addCultivoRecomendado(String cultivo) {return recomendados.add(cultivo);}
	
	public boolean addSiembra(Siembra s) {return cultivos.add(s);}
	
	public int precioParcela() {return this.getMetros()*this.getPrecio();}
	
	public String toString() {
		return "LOCALIZACION: "+this.getLocalizacion()+"\n"
				+"METROS: "+this.getMetros()+"\n"
				+"PRECIO POR METRO: "+this.getPrecio()+"\n"
				+"PRECIO DEL ARRENDAMIENTO: "+this.precioParcela()+"\n"
				+"ESTADO: "+(this.isBarbecho()?"Terreno en barbecho":"Terreno disponible para siembra")+"\n"
				+"CULTIVOS RECOMENDADOS: "+this.getRecomendados().toString()+"\n"
				+"SIEMBRAS REALIZADAS EN ESTAS PARCELAS: "+this.getCultivos().toString();
	}
	
	

}
