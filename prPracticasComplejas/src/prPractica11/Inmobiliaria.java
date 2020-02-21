package prPractica11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inmobiliaria {
	
	/*
	 * Atributos
	 */
	private String nombre;
	private List <Propiedad> inmo;
	
	/*
	 * Constructores
	 */
	public Inmobiliaria(String nombre) {
		this.nombre=nombre;
		inmo = new ArrayList<Propiedad>();
	}
	
	/*
	 * Getters y setters
	 */

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public List<Propiedad> getInmo() {return inmo;}

	public void setInmo(ArrayList<Propiedad> inmo) {this.inmo = inmo;}
	
	/*
	 * Métodos pedidos por el ejercicio
	 */
	
	public boolean añade (Propiedad ob) {
		
		if(this.existe(ob))
			return false;
		
		else {
			inmo.add(ob);
			return true;}
			
	}
	
	public Propiedad buscar (int cod) {
		Propiedad p = null;
		boolean encontrada = false;
		Iterator <Propiedad> it = inmo.listIterator();
		
		while(it.hasNext() && !encontrada) {
			p = it.next();
				if (p.getCodigo()==cod) {
					encontrada=true;}		
		}
		
		return encontrada?p:null;
	}
	
	public boolean existe (Propiedad p) {return inmo.contains(p);}
	
	public boolean borra (int cod) {return this.borra(this.buscar(cod));}
	
	public boolean borra (Propiedad p) {
		
		if(!this.existe(p))
			return false;
		
		else {
			inmo.remove(p);
			return true;}
		
	}
	
	/*
	 * String redefinido
	 */
	@Override
	public String toString() {
		inmo.sort(null);
		String res="";
		for (Propiedad propiedad : inmo) {
			res=res+propiedad.toString()+"\n--------------------------------\n";
		}
		
		return res;
	}
	
	public String getPropiedadesOrdenPrecio() {
		inmo.sort((Propiedad p1, Propiedad p2) -> {return (int)(p1.getPrecio()-p2.getPrecio());});
		String res="";
		for (Propiedad propiedad : inmo) {
			res=res+propiedad.toString()+"\n--------------------------------\n";
		}
		
		return res;
		
	}
	
}
