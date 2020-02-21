package prJuegoCartas;

import java.util.Arrays;
import java.util.Random;

public class Baraja {
	
	private Carta [] baraja ;
	private int topeBaraja;
	
	/*
	 * Constructor
	 */
	
	public Baraja () {
		baraja = new Carta [52];
		topeBaraja=0;
		
		//Método privado para rellenar la baraja en orden
		rellenar();
		//Método privado para desordenar la baraja
		barajar();

		}
	
	
	/*
	 * Getters y setters
	 */
	
	public Carta[] getBaraja() {return baraja;}

	public void setBaraja(Carta[] baraja) {this.baraja = baraja;}

	public int getTopeBaraja() {return topeBaraja;}

	public void setTopeBaraja(int topeBaraja) {this.topeBaraja = topeBaraja;}

	/*
	 * Métodos privados
	 */
	
	private void rellenar() {
		
		for (int i = 0, j = 1; i < baraja.length/4; i++,j++) {
			baraja[i]=new Carta ("Treboles",(byte)(j));
			}
		
		for (int i = 13, j = 1; i < baraja.length/2; i++,j++) {
			baraja[i]=new Carta ("Picas",(byte)(j));
			}
		
		for (int i = 26, j = 1; i < 39; i++,j++) {
			baraja[i]=new Carta ("Diamantes",(byte)(j));
			}
		
		for (int i = 39, j = 1; i < baraja.length; i++,j++) {
			baraja[i]=new Carta ("Corazones",(byte)(j));
			}
		}
	
	private void barajar() {
		
		Random rnd = new Random();
		Carta aux;
		
		for (int i = 0; i < baraja.length; i++) {
			
			int ind1 = rnd.nextInt(baraja.length-1);
			int ind2 = rnd.nextInt(baraja.length-1);
			
			aux = baraja[ind1];
			baraja[ind1]=baraja[ind2];
			baraja[ind2]=aux;
			
			
		}
	}
	
	/*
	 * Métodos propios de la baraja
	 */
	
	public Carta sacaCarta() {
		Carta crt = baraja[topeBaraja];
		this.setTopeBaraja(this.getTopeBaraja()+1);
		return crt;}
	
	/*
	 * Método para mostrar la baraja
	 */
	
	@Override
	public String toString() {
		return Arrays.deepToString(baraja);
	}
	
	
	}


