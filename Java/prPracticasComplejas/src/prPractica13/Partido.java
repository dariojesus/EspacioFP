package prPractica13;

import java.util.Date;

public class Partido {
	
	/*
	 * Atributos
	 */
	private Equipo eq1;
	private Equipo eq2;
	private Date fecha;
	private String resultado;
	private int marcados;
	private int recibidos;
	
	/*
	 * Constructor
	 */
	public Partido(Equipo eq1, Equipo eq2, Date fecha) {
		super();
		this.eq1 = eq1;
		this.eq2 = eq2;
		this.fecha = fecha;
		this.marcados=0;
		this.recibidos=0;
	}
	
	/*
	 * Getters y setters
	 */

	public Equipo getEq1() {
		return eq1;
	}

	public void setEq1(Equipo eq1) {
		this.eq1 = eq1;
	}

	public Equipo getEq2() {
		return eq2;
	}

	public void setEq2(Equipo eq2) {
		this.eq2 = eq2;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public int getMarcados() {
		return marcados;
	}

	public void setMarcados(int marcados) {
		this.marcados = marcados;
	}

	public int getRecibidos() {
		return recibidos;
	}

	public void setRecibidos(int recibidos) {
		this.recibidos = recibidos;
	}
	
	/*
	 * Métodos útiles
	 */
	
	public String quiniela() {
		if (this.getMarcados() > this.getRecibidos())return "1";
		else if (this.getMarcados() < this.getRecibidos())return "2";
		else return "X";
	}
	
	@Override
	public String toString() {
		return this.getEq1().getNombre()+" "+this.getMarcados()+", "+this.getEq2().getNombre()+" "+this.getRecibidos();
	}
	
	
	
	

}
