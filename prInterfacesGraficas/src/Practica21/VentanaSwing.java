package Practica21;

import java.awt.event.*;
import javax.swing.*;
/**
* Clase para probar los eventos de ventana
*/
public class VentanaSwing extends JFrame {
	
	private static final long serialVersionUID = 2407093880534212790L;
	/**
	* Constructor
	* @param s --> T�tulo de la ventana
	* @param w --> Alto de la ventana
	* @param h --> Ancho de la ventana
	* @param lo --> Posici�n de la ventana
	*/
	
	public VentanaSwing(String s, int w, int h, int lo) {
		// Establecer el t�tulo de la ventana
		super(s);
		// Establecer un tama�o para la ventana (ancho y alto)
		setSize(w,h);
		// Poner visible la ventana
		setVisible(true);
		// Posicionar la ventana en las coordenadas indicadas
		setLocation(lo,100);
		// Tambi�n podr�amos usar el m�todo setBounds, para unificar setSize y setLocation
		// setBounds(lo, 100, w, h);
		// A�ado el control al cierre de la ventana
		addWindowListener(new ControlVentana());
	}


/**
* M�todo principal
*/
public static void main(String[] args) {
	// Crear tres objetos tipo ventana
	new VentanaSwing("Prueba eventos de ventana 1",200,100,1);
	new VentanaSwing("Prueba eventos de ventana 2",100,50,200);
	new VentanaSwing("Prueba eventos de ventana 3",200,200,500);
}



/**
* Clase para programar los eventos de ventana
*/

public class ControlVentana implements WindowListener{
	
public void windowOpened(WindowEvent e) {System.out.println("Ventana " + e.getWindow().getName() + " abierta");}

public void windowClosing(WindowEvent e) {
	System.out.println("Cerrando ventana "+ e.getWindow().getName());
	e.getWindow().dispose();
}

public void windowClosed(WindowEvent e) {
System.out.println("Ventana " + e.getWindow().getName() + " cerrada");
}

public void windowActivated(WindowEvent e) {
System.out.println("Ventana " + e.getWindow().getName() + " activa (en uso)");
}

public void windowDeactivated(WindowEvent e) {
System.out.println("Ventana " + e.getWindow().getName() + " desactivada (fuera de uso)");
}

public void windowIconified(WindowEvent e) {
System.out.println("Ventana " + e.getWindow().getName() + " minimizada");
}

public void windowDeiconified(WindowEvent e) {
System.out.println("Ventana " + e.getWindow().getName() + " restaurada");
}

}
}
