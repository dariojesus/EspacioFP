package prPractica11;

public enum tipoPropiedad {
		LOCAL("Local comercial"),
		APARCAMIENTO("Plaza de aparcamiento"),
		VIVIENDA("Vivienda"),
		FINCA("Finca r�stica"),
		SOLAR("Solar");
	
	private String descripccion;
	
	private tipoPropiedad(String str) {this.descripccion=str;}

	public String getDescripccion() {
		return descripccion;
	}

	

}
