package prPractica15;

public class PruebaSiembras {

	public static void main(String[] args) {
		Siembra sb = new Siembra("Puerros","10/01/2020","Agricultor 1");
		sb.setFechFin("05/03/2020");
		
		Siembra sb2 = new Siembra("Zanahorias","19/02/2020","Agricultor 2");
		sb2.setFechFin("01/03/2020");
		
		Parcela pc = new Parcela ("Antequera",200,12,false);
		pc.addCultivoRecomendado("Manzanas");
		pc.addCultivoRecomendado("Zanahorias");
		pc.addSiembra(sb);
		pc.addSiembra(sb2);
		
		System.out.println(pc);

	}

}
