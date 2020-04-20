package Practica17;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI02Dialog{

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("Titulo del jframe");
		
		// ------------------------------------------------
		// Crear un diálogo asociado a esta ventana (Frame)
		// ------------------------------------------------
		JDialog d = new JDialog(jf,"Título de diálogo",false);
		 // this es el JFrame, he heredado de JFrame
		d.setLayout(new FlowLayout());
		d.add(new JLabel("Esto es una ventana de diálogo"));
		d.add(new JButton("OK"));
		d.pack();
		d.setSize(200, 90);
		d.setResizable(false);
		d.setVisible(true);
		d.setLocationRelativeTo(jf);
		//d.setLocation(200,200);
		// Controlar el cierre del diálogo, OJO, se oculta, no se sale de la aplicación
		//d.setDefaultCloseOperation(jf.HIDE_ON_CLOSE);
	}

}
