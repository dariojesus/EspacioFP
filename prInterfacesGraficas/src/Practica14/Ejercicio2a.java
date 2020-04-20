package Practica14;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ejercicio2a {

	public static void main(String[] args) {
		
		//Esto es el frame (la ventana sobre la que esta el contenedor)
		JFrame frame = new JFrame("BorderLayout");
		
		//Creamos el contenedor donde iran los componentes
		Container panel = frame.getContentPane();
		
		panel.setLayout(new BorderLayout());
		
		JButton center = new JButton("Centro");
		JButton north = new JButton("Norte");
		JButton south = new JButton("Sur");
		JButton east = new JButton("Este");
		JButton west = new JButton("Oeste");
		
		panel.add(center,BorderLayout.CENTER);
		panel.add(north,BorderLayout.NORTH);
		panel.add(south,BorderLayout.SOUTH);
		panel.add(east,BorderLayout.EAST);
		panel.add(west,BorderLayout.WEST);
		

		//Aqui es donde hacemos que el frame sea visible, tenga un tamaño y lo empaquetamos
		frame.pack();
		frame.setSize(500, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
