package Practica21;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConversorEurosMain {

	public static void main(String[] args) {

		
		try {
			
			float cambio = Float.parseFloat(JOptionPane.showInputDialog("Indique cambio a dolar"));
			
			//Creamos vista
			ConversorEurosVista miVista = new ConversorEurosVista(cambio);
			
			//Creamos el controlador y lo unimos con la vista
			ConversorEurosControl miCtr = new ConversorEurosControl(miVista);
			
			//Definimos el control sobre la vista
			miVista.control(miCtr);
			
			//Creamos la ventana como normalmente
			JFrame ventana = new JFrame ("Conversor de euros/dolares");
			ventana.setContentPane(miVista);

			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.pack();
			ventana.setVisible(true);
		
		}catch (NullPointerException e) {
			
			//Creamos vista
			ConversorEurosVista miVista = new ConversorEurosVista(1);
			
			//Creamos el controlador y lo unimos con la vista
			ConversorEurosControl miCtr = new ConversorEurosControl(miVista);
			
			//Definimos el control sobre la vista
			miVista.control(miCtr);
			
			//Creamos la ventana como normalmente
			JFrame ventana = new JFrame ("Conversor de euros/dolares");
			ventana.setContentPane(miVista);

			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.pack();
			ventana.setVisible(true);
			
			
		}
		
		
	}

}
