package Practica14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejericio2b {

	public static void main(String[] args) {
		
		//Esto es el frame (la ventana sobre la que esta el contenedor)
				JFrame frame = new JFrame("BorderLayout");
				
				//Creamos el contenedor donde iran los componentes
				Container panel = frame.getContentPane();
				Container panel2 = frame.getContentPane();
				
				panel.setLayout(new BorderLayout());
				panel2.setLayout(new BorderLayout(30,15));
				
				
				//Botones
				JButton north = new JButton("Norte");
				JButton south = new JButton("Sur");
				JButton east = new JButton("Este");
				JButton west = new JButton("Oeste");
				
				JButton center = new JButton("Centro");
				center.setPreferredSize(new Dimension(100,100));
				
				//Añadimos los botones a los paneles
				panel.add(north,BorderLayout.NORTH);
				panel.add(south,BorderLayout.SOUTH);
				panel.add(east,BorderLayout.EAST);
				panel.add(west,BorderLayout.WEST);
				
				panel2.add(center,BorderLayout.CENTER);
				
				

				//Aqui es donde hacemos que el frame sea visible, tenga un tamaño y lo empaquetamos
				frame.pack();
				frame.setSize(500, 250);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
