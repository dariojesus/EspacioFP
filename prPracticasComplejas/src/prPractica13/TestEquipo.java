package prPractica13;

public class TestEquipo {

	public static void main(String[] args) {
		
		Equipo eq = new Equipo("ANTEQUERA CF",3,2,1,3,10);
		Equipo eq1 = new Equipo("ANTEQUERA CF",5,2,4,2,15);
		
		System.out.println(eq);
		
		System.out.println(eq.toStringLineal());
		
		System.out.println(Equipo.sonIguales(eq, eq1));

	}

}
