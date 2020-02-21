package prPractica11;

public class PruebaInmobiliaria {

	public static void main(String[] args) {
		
	Inmobiliaria in1 = new Inmobiliaria ("Antequera's");
	
	Propiedad p2 = new Propiedad (1,"merecillas n4",120,"Con cuarto de baño, agua y luz",800000,tipoPropiedad.LOCAL);
	Propiedad p1 = new Propiedad (4,"merecillas n4",120,"Con cuarto de baño, agua y luz",60000,tipoPropiedad.LOCAL);
	Vivienda v1 = new Vivienda(2,"merecillas n4",100,"Con cuarto de baño, agua y luz",120000,tipoVivienda.CASA,2,4);
	Finca f1 = new Finca (3,"carretera cordoba km 65",1000,"Pegado a la carretera",250000,tipoTerreno.SECANO,true,true,false);
	
	in1.añade(p1);
	in1.añade(f1);
	in1.añade(v1);
	in1.añade(p2);
	
	
	
	//Borrado propiedad (funciona)
	//in1.borra(v1);
	
	//Borrado con codigo (funciona)
	//in1.borra(3);
	
	
	//Busqueda de propiedad 
	//System.out.println(in1.existe(f1));
	
	//Busqueda de propiedad con codigo (funciona)
	//System.out.println(in1.buscar(2));
	//System.out.println(in1.buscar(8));
	
	//Orden natural (ID's)
	System.out.println(in1);
	
	//Orden alternativo (Precios)
	//System.out.println(in1.getPropiedadesOrdenPrecio());
	
	}

}
