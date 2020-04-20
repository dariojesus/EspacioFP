package Practica20;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class Ejercicio1a extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton b1;
	private JButton b2;
	private JLabel etiqueta;
	
	public Ejercicio1a () {
		super("Prueba eventos de teclado");
		
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridLayout(3,1));
		
		b1 = new JButton("Primero");
		b2 = new JButton("Segundo");
		etiqueta = new JLabel("");
		
		escuchaTeclado te = new escuchaTeclado();
		b2.addKeyListener(te);
		
		contenedor.add(b1);
		contenedor.add(b2);
		contenedor.add(etiqueta);
	}
	
	class escuchaTeclado implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			if(arg0.getKeyChar()=='*')
				System.exit(0);
			
			etiqueta.setText(etiqueta.getText()+arg0.getKeyChar());
			
		}
		
	}
	
	/**
	* Programa principal
	 */
	public static void main(String[] args) {

			// Crear un objeto tipo Ventana
			Ejercicio1a ventana = new Ejercicio1a();
			
			// Ajuste del contenedor
			ventana.pack();
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
}
