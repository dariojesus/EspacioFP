package prPractica11;

public enum tipoPropiedad {
		LOCAL("Local comercial"),
		APARCAMIENTO("Plaza de aparcamiento"),
		VIVIENDA("Vivienda"),
		FINCA("Finca rústica"),
		SOLAR("Solar");
	
	private String descripccion;
	
	private tipoPropiedad(String str) {this.descripccion=str;}

	public String getDescripccion() {
		return descripccion;
	}

	

}
