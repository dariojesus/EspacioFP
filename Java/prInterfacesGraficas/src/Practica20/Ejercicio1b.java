package Practica20;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Ejercicio1b extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaTexto;
	
	public Ejercicio1b() {
		super("Prueba de eventos de teclado");
		
		Container contenedor = this.getContentPane();
		
		areaTexto = new JTextArea("");

		
		escuchaTeclado escucha = new escuchaTeclado();
		areaTexto.addKeyListener(escucha);
		
		contenedor.add(areaTexto);
		
	}
	
	
	class escuchaTeclado implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			areaTexto.append("Tecla pulsada\n");
			if(arg0.getKeyChar()=='h')
				areaTexto.append("HOLAA!!!\n");
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			areaTexto.append("Tecla pulsada y soltada --> "+arg0.getKeyChar()+"\n");
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			areaTexto.append("Tecla soltada\n");
		}
		
	}
	
	/**
	* Programa principal
	 */
	public static void main(String[] args) {

			// Crear un objeto tipo Ventana
			Ejercicio1b ventana = new Ejercicio1b();
			
			// Ajuste del contenedor
			ventana.pack();
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
