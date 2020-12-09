package Practica14;


import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Creamos primero el contenedor
		JFrame f = new JFrame("Ventana inicial");
		
		//Escogemos el esquema de orden que seguira el contenedor
		f.setLayout(new FlowLayout());
		
		//Creamos los componentes que tendrá el contenedor
		JLabel nombre = new JLabel("Nombre");
		JButton bSi = new JButton("Si");
		JButton bNo = new JButton("No");
		
		//Añadimos los componentes al contenedor
		f.add(nombre);
		f.add(bSi);
		f.add(bNo);
		
		//La siguiente linea de codigo hace que se ajusten los componentes al contenedor
		f.pack();
		
		//Establecer un tamaño para el contenedor
		f.setSize(750,300);
		
		//Ponemos el contenedor en visible
		f.setVisible(true);
		
		//Controlar el boton de cierre de ventana
		f.addWindowListener(new ControlVentana());

	}

}
