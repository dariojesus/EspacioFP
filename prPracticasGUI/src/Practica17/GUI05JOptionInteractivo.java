package Practica17;

import javax.swing.JOptionPane;

public class GUI05JOptionInteractivo {

	public static void main(String[] args) {
		
		try {
			
			//Pedimos un numero
			int numero = Integer.valueOf(JOptionPane.showInputDialog("Escriba un número"));
			
			JOptionPane.showMessageDialog(null, "El número introducido es "+numero);
			
			if (numero==100)
				JOptionPane.showMessageDialog(null, "Enhorabuena, has obtenido un premio");
		
		} catch (NumberFormatException eNumerico) {
			JOptionPane.showMessageDialog(null, "Dato incorrecto" ,"Error al insertar un numero", JOptionPane.ERROR_MESSAGE);} 
		
		 catch (NullPointerException eNulo){
			JOptionPane.showMessageDialog(null, "Entrada cancelada" ,"Se ha pulsado cancelar", JOptionPane.ERROR_MESSAGE);}
		
		

	}

}
