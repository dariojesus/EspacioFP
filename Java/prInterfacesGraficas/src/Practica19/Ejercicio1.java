package Practica19;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Ejercicio1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boton;
	private JLabel etiqueta;
	
	
	public Ejercicio1() {
		super("Prueba eventos de raton");
		
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		
		boton = new JButton("Bienvenido");
		
		etiqueta = new JLabel("Etiqueta");
		
		escuchaMouse m = new escuchaMouse();
		boton.addMouseListener(m);
		
		panel.add(boton);
		
		contenedor.add(panel,BorderLayout.CENTER);
		contenedor.add(etiqueta,BorderLayout.SOUTH);
	}
	
	
	
	
	class escuchaMouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("Botón pulsado y soltado (click)");
			etiqueta.setText("Boton pulsado click");
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			System.out.println("Entro con el ratón en el botón");
			boton.setBackground(Color.green);
			etiqueta.setText("Entro al botón");
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			System.out.println("Salgo con el ratón del botón");
			boton.setBackground(Color.DARK_GRAY);
			etiqueta.setText("Salgo del botón");
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			System.out.println("Botón pulsado en posicion "+arg0.getX()+","+arg0.getY());
			etiqueta.setText("Pulso en "+arg0.getX()+","+arg0.getY());
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			System.out.println("Botón soltado en posicion "+arg0.getX()+","+arg0.getY());
			etiqueta.setText("Suelto en "+arg0.getX()+","+arg0.getY());
			
		}
		
	}
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Crear un objeto tipo Ventana
		Ejercicio1 ventana = new Ejercicio1();
		
		// Ajuste del contenedor
		ventana.pack();
		ventana.setSize(400,150);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
