package Practica14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio3 {

	public static void main(String[] args) throws InterruptedException {
		
		JFrame ven = new JFrame("Titulo de ventana");
		
		//Contenedor
		Container contenedor = ven.getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		//Panel intermedio para los botones
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		//Botones
		JButton bNor = new JButton("Norte");
		JButton bSur = new JButton("Sur");
		JButton bEst = new JButton("Este");
		JButton bCen = new JButton("Centro");
		
		JButton b1 = new JButton("Boton 1");
		JButton b2 = new JButton("Boton 2");
		
		//Añadimos los botones al contenedor y panel
		panel.add(b1);
		panel.add(b2);
		
		contenedor.add(bNor,BorderLayout.NORTH);
		contenedor.add(bSur,BorderLayout.SOUTH);
		contenedor.add(bEst,BorderLayout.EAST);
		contenedor.add(bCen,BorderLayout.CENTER);
		contenedor.add(panel,BorderLayout.WEST);
		
		//Se empaqueta todo y se pone en visible
		ven.pack();
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Se ejecuta la desaparacion del boton sur tras pasar 5 segundos
		
		Thread.sleep(5000);
		bSur.setVisible(false);
		ven.pack();
		
	}

}
