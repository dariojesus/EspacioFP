package prPractica14;

public class PruebaF1 {

	public static void main(String[] args) {
		Piloto p1 = new Piloto("Fernando Alonso","Español","01/01/1976","Ferrari",0);
		Piloto p2 = new Piloto("Lewis Hamilton","Aleman","02/01/1991","McClaren",0);
		Piloto p3 = new Piloto("Jenson Button","Frances","08/08/1981","Ferrari",0);
		Piloto p4 = new Piloto("Pastor Maldonado","Español","01/01/1986","Renault",0);
		Piloto p5 = new Piloto("Nico Roserberg","Italiano","15/10/1987","Red Bull",0);
		Piloto p6 = new Piloto("Felipe Massa","Italiano","01/11/1991","Red Bull",0);
		
		PilotosF1 pf1 = new PilotosF1();
		pf1.addPiloto(p2);
		pf1.addPiloto(p1);
		pf1.addPiloto(p4);
		pf1.addPiloto(p6);
		pf1.addPiloto(p3);
		pf1.addPiloto(p5);
		
		pf1.addGranPremio("Fernando Alonso;Lewis Hamilton;Jenson Button;Pastor Maldonado;Nico Roserberg;Felipe Massa");
		
		System.out.println(pf1.clasificacionPorPilotos());
	}

}
