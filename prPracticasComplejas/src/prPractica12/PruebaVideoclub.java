package prPractica12;

import java.util.LinkedList;
import java.util.List;

public class PruebaVideoclub {

	public static void main(String[] args) {
		
		List<String> actores1 = new LinkedList<String>();
		actores1.add("Eccleston");
		actores1.add("Murphy");
		actores1.add("Harris");
		
		DVD dvd1 = new DVD("0001","28 días después","Boyle", actores1);
		List<String> actores2 = new LinkedList<String>();
		actores2.add("Jolie");
		actores2.add("Butler");
		actores2.add("Barrie");
		
		DVD dvd2 = new DVD("0002","Lara Croft: Tomb raider. La cuna de la vida","De Bont",
		actores2);
		List<String> actores3 = new LinkedList<String>();
		actores3.add("Biggs");
		actores3.add("Nicholas");
		actores3.add("Thomas");
		
		DVD dvd3 = new DVD("0003","American pie ¡Menuda boda!","Dylan", actores3);
		
		List<String> actores4 = new LinkedList<String>();
		actores4.add("O'Connell");
		actores4.add("Anderson");
		actores4.add("Warren");
		
		DVD dvd4 = new DVD("0004","Canguro Jack trinca y brinca","McNally", actores4);
		List<String> actores5 = new LinkedList<String>();
		actores5.add("Carrey");
		actores5.add("Freeman");
		actores5.add("Aniston");
		
		DVD dvd5 = new DVD("0005","Como Dios","Shadyac",actores5);
		List<String> actores6 = new LinkedList<String>();
		actores6.add("Banderas");
		actores6.add("Liu");
		actores6.add("Henry");
		
		DVD dvd6 = new DVD("0006","Enemigos. Ecks contra Sever","Kaos",actores6);
		
		////////////////////////////////////////////////////////////////////////////////
		
		
		DVDClub videoClub = new DVDClub();
		
		videoClub.añadePelicula(dvd1);
		videoClub.añadePelicula(dvd2);
		videoClub.añadePelicula(dvd3);
		videoClub.añadePelicula(dvd4);
		videoClub.añadePelicula(dvd5);
		videoClub.añadePelicula(dvd6);
		
		System.out.println(videoClub.disponible());
		
		
		
		Cliente c1 = new Cliente("Dario");

		videoClub.añadeCliente(c1);

		
		videoClub.alquila("Como Dios", "dario");

		
		System.out.println("Alquiladas por mi");
		System.out.println(videoClub.getPeliculasCliente("dario"));
		System.out.println();
		

		System.out.println(videoClub.disponible());
		
		System.out.println("Ahora se devuelven las peliculas al videoclub");
		videoClub.devuelve("como dios", "dario");
		System.out.println(videoClub.alquiladas("dario"));
		System.out.println();
		
		System.out.println("Ahora se muestran otra vez las pelis disponibles");
		
		
		System.out.println(videoClub.disponible());

	}

}
