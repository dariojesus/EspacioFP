package prJuegoCartas;

public class TestCarta {

	public static void main(String[] args) {
		
		Carta c1 = new Carta ("Treboles",(byte)1);
		Carta c2 = new Carta ("Picas",(byte)7);
		Carta c3 = new Carta ("Corazones",(byte)12);
		Carta c4 = new Carta ("Treboles",(byte)1);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println(c1.equals(c4)?"Son iguales":"Son distintas");
	}

}
