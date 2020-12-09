package Practica19;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio2 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contenedor;
	private JLabel x;
	private JLabel y;
	
	public Ejercicio2() {
		super("Prueba de movimiento de ratón");
		
		contenedor = this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		x = new JLabel("000");
		y = new JLabel("000");
		
		movimientoRaton mouse = new movimientoRaton();
		contenedor.addMouseMotionListener(mouse);
		
		contenedor.add(x);
		contenedor.add(y);
		
		
	}
	
	class movimientoRaton implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			x.setForeground(Color.blue);
			y.setForeground(Color.blue);
			x.setText(Integer.toString(arg0.getX()));
			y.setText(Integer.toString(arg0.getY()));
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			x.setForeground(Color.red);
			y.setForeground(Color.red);
			x.setText(Integer.toString(arg0.getX()));
			y.setText(Integer.toString(arg0.getY()));
		}
		
	}
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Crear un objeto tipo Ventana
		Ejercicio2 ventana = new Ejercicio2();
		
		// Ajuste del contenedor
		ventana.pack();
		ventana.setSize(400,150);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
