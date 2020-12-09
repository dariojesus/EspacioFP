package prJuegoCartas;

import java.util.Scanner;

public class BlackJack {
	
	/*
	 * Método que muestra la información inicial de los jugadores
	 */
	public static void inicioBlack(Jugador j, Baraja b) {
		
		System.out.println("Jugador: "+j.getNombre());
		Carta c = b.sacaCarta();
		j.setPuntuacion(c.valorBlackJack());
		System.out.println("Puntuación: "+j.getPuntuacion());
		System.out.println(c);
		System.out.println();
	}
	
	/*
	 * Método que pide cartas al jugador para seguir o no jugando
	 */
	public static boolean turnoJugador(Jugador j,Baraja b, Scanner sc) {
		boolean pasado = false;
		
		System.out.println("----------Turno de "+j.getNombre()+"----------");
		System.out.println("¿Desea otra carta? (S/N)");
		
		while(j.getPuntuacion() < 21 && sc.next().charAt(0)=='S') {
			
			Carta c = b.sacaCarta();
			System.out.println(c);
			j.setPuntuacion(j.getPuntuacion()+c.valorBlackJack());
			System.out.println("Puntuacion: "+j.getPuntuacion());
			
				if (j.getPuntuacion()>21) {
					pasado = true;
					System.out.println("Se ha pasado la banca gana");
				}
				
				else System.out.println("¿Desea otra carta? (S/N)");
			
		}
		
		return pasado;
	}
	
	/*
	 * Método con el que juega la máquina
	 */
	public static void turnoMaquina(Jugador j,Jugador persona, Baraja b) throws InterruptedException {
		
		System.out.println("----------Turno de "+j.getNombre()+"----------");
		
		do {
			Carta c = b.sacaCarta();
			System.out.println(c);
			j.setPuntuacion(j.getPuntuacion()+c.valorBlackJack());
			System.out.println("Puntuacion: "+j.getPuntuacion());
			System.out.println();
			Thread.sleep(2000);
			
		}while(j.getPuntuacion() < persona.getPuntuacion());
	}
	
	public static void resultado (Jugador j, Jugador maquina) {
		
		System.out.println("-------Resultado-------");
		
		if (maquina.getPuntuacion() <=21) {
			if (maquina.getPuntuacion()>j.getPuntuacion())System.out.println("Ha perdido");
			else System.out.println("Empate");
		}
		
		else System.out.println("Usted gana");
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		boolean sePasa;
		Scanner sc = new Scanner (System.in);
		Jugador j2 = new Jugador ("Jesús");
		Jugador j1 = new Jugador ("Banca");
		Baraja b = new Baraja();
		
		System.out.println("-------Comienza el juego-------");
		System.out.println();
		inicioBlack(j1,b);
		inicioBlack(j2,b);
		
		sePasa = turnoJugador(j2,b,sc);
		if (!sePasa)turnoMaquina(j1,j2,b);
		
		resultado(j2,j1);
	
		sc.close();

		

	}

}
