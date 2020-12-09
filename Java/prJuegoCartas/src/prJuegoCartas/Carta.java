package prJuegoCartas;
public class Carta {

	/*
	 * Variables de instancia
	 */
	private String palo;
	private byte valor;
	
	/*
	 * Constructores
	 */
	public Carta(String palo, byte valor) {
		this.palo=palo;
		this.valor=valor;
	}
	
	/*
	 * Getters y setters
	 */

	public String getPalo() {return palo;}

	public void setPalo(String palo) {this.palo = palo;}

	public byte getValor() {return valor;}

	public void setValor(byte valor) {this.valor = valor;}
	
	/*
	 * Metodos redefinidos
	 */
	
	@Override
	public String toString() {
		
		switch(this.getValor()) {
		case 11:return "J de "+this.getPalo();
		case 12:return "Q de "+this.getPalo();
		case 13:return "K de "+this.getPalo();
		default:return this.getValor()+" de "+this.getPalo();
	 }
	}

	@Override
	public boolean equals(Object obj) {
		Carta carta = (Carta) obj;
		return this.getPalo().equalsIgnoreCase(carta.getPalo()) && this.getValor()==carta.getValor();
	}
	
	/*
	 * Método de puntuación para BlackJack
	 */
	public byte valorBlackJack() {
		byte val;
		
		switch(this.getValor()) {
			case 1: val=11;break;
			case 11:
			case 12:
			case 13: val=10;break;
			default: val=this.getValor();break;
		}
		
		return val;
	}
	
	
}
