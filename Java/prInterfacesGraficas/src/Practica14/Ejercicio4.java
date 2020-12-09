package Practica14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ejercicio4 {

	public static void main(String[] args) {
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

		ButtonGroup grupo = new ButtonGroup();  //Hay que hacer un grupo de botones para que sea seleccionable
		JRadioButton bM = new JRadioButton("Hombre");
		JRadioButton bF = new JRadioButton("Mujer");
		
		//Añadimos los botones al contenedor y panel
		
		//Se añaden los botones al grupo
		grupo.add(bM);
		grupo.add(bF);
		
		//Ademas hay que añadir los botones al panel....NO EL BUTTONGROUP (RARO)
		panel.add(bM);
		panel.add(bF);
		
		contenedor.add(bNor,BorderLayout.NORTH);
		contenedor.add(bSur,BorderLayout.SOUTH);
		contenedor.add(bEst,BorderLayout.EAST);
		contenedor.add(bCen,BorderLayout.CENTER);
		contenedor.add(panel,BorderLayout.WEST);
		
		//Se empaqueta todo y se pone en visible
		ven.pack();
		ven.setVisible(true);
		ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
