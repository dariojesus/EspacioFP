package Tarea06;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

/**
 * 
 * La programaci�n de los eventos ser� mediante dos clases internas que est�n 
 * definidas dentro de la clase principal. M�s adelante estas clases internas
 * ser�n clases que sacaremos fuera, para simplificar el c�digo. Las clases son:
 *   
 *    - ControlBoton, implementa la interfaz ActionListener
 *    
 *    - ControlFoco, implementa la interfaz FocusListener
 * 
 *   LOS "OYENTES" AHORA SON DOS CLASES INTERNAS (las que dan respuesta a los eventos)
 * 
 * 
 * En este ejemplo vamos a controlar dos tipos de eventos:
 * 
 *   - Pulsar un bot�n, esto lo haremos mediante la interfaz ActionListener
 *     que tiene un �nico m�todo actionPerformed, en este m�todo programaremos 
 *     el cambio de texto de la etiqueta
 *     		
 *   - Ganar o perder el foco de un componente, en este caso de los botones.
 *     Esto lo haremos mediante la interfaz FocusListener, la cual tiene 
 *     dos m�todos focusGained y focusLost. En estos m�todos programaremos 
 *     el cambio de color de los botones, naranja cuando gana el foco, y
 *     el color por defecto cuando lo pierde
 * 
 * @version 2.0
 * @author Asus
 *
 */

public class Ejemplo01v2 extends JFrame 
{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Variables de instancia
	 * 
	 * Ahora los componentes los definimos como variables de instancia, ya
	 * que sino, no podr�amos acceder a ellas desde otros m�todos, sino que
	 * solo estar�an accesibles en el constructor
	 * 
	 * En este ejemplo accedo a la variable bSi, y a etiqueta desde los m�todos
	 * de las interfaces ActionListener y FocusListener
	 */
	private JLabel etiqueta;
	private JButton bSi;
	private JButton bNo;
	
	
	/**
	 * Constructor
	 */
	public Ejemplo01v2() {

		// Poner t�tulo al contenedor
		super("Mi primer GUI");

		// Obtener el panel contenedor (getContentPane)
		Container cp = this.getContentPane();

		// Seleccionar el gestor de esquemas para el contenedor
		cp.setLayout(new FlowLayout(FlowLayout.RIGHT,15,15));

		// Crear los componentes
		etiqueta = new JLabel("Nombre");
		bSi = new JButton("Si");
		bNo = new JButton("No");

			
		// Agregar los componentes al contenedor
		cp.add(etiqueta);
		cp.add(bSi);
		cp.add(bNo);
		
		// A�adir el control de botones a los botones Si y No
		// Creo un objeto de la clase ControlBoton que es una clase
		// interna que est� definida un poco m�s abajo
		ControlBoton cb = new ControlBoton();
		bSi.addActionListener(cb);
		bNo.addActionListener(cb);
		
		// A�adir el control del foco a los botones Si y No
		// Creo un objeto de la clase ControlFoco que es una clase
		// interna que est� definida un poco m�s abajo
		ControlFoco cf = new ControlFoco();
		bSi.addFocusListener(cf);
		bNo.addFocusListener(cf);
	}
	

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Crear un objeto tipo Ventana
		Ejemplo01v2 ventana = new Ejemplo01v2();
		
		// Ajuste del contenedor
		ventana.pack();

		// Establecer un tama�o para la ventana
		ventana.setSize(400,150);

		// Poner visible el contenedor
		ventana.setVisible(true);

		// Programar el cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/** 
	 * ----------------------------------------------------------------------------
     * Clase interna que implementa la interfaz ActionListener
	 * ----------------------------------------------------------------------------
	 */
	class ControlBoton implements ActionListener {
		
		/** M�todo de la interfaz ActionListener
		 *    Este c�digo se ejecutar� cuando se pulse un bot�n 
		 *    
		 * @param e --> Es el objeto que ha provocado el evento	
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource()==bSi)  // Pregunto si se ha pulsado el bot�n Si
				etiqueta.setText("Si pulsado");
			else
				etiqueta.setText("No pulsado");
		}
	}  // Fin de la clase ActionListener
	
	
	
	/**
	 * -----------------------------------------------------------------------------
	 * Clase interna que implementa la interfaz FocusListener
	 * -----------------------------------------------------------------------------
	 */
	class ControlFoco implements FocusListener {

		/**
		 * M�todo que se ejecuta de forma autom�tica cuando un componente (en este caso
		 * un bot�n) gana el foco
		 * 
		 * @param e --> Es el objeto que ha provocado el evento
		 */
		@Override
		public void focusGained(FocusEvent e) {
	
			if (e.getSource()==bSi)  // Pregunto si se ha pulsado el bot�n Si
				bSi.setBackground(Color.ORANGE);
			else
				bNo.setBackground(Color.ORANGE);
			
			// Otra alternativa, en la que nos habr�amos ahorrado el if, habr�a sido
			// utilizando el m�todo getComponent, sobre el par�metro que es 
			// el objeto que ha provocado el evento
			//	e.getComponent().setBackground(Color.ORANGE);
		}
	
		
		/**
		 * M�todo que se ejecuta de forma autom�tica cuando un componente 
		 * pierde el foco
		 * 
		 * @param e --> Es el objeto que ha provocado el evento
		 */
		@Override
		public void focusLost(FocusEvent e) {
		
			if (e.getSource()==bSi)  // Pregunto si se ha pulsado el bot�n Si
				bSi.setBackground(UIManager.getColor("Button.background"));
			else
				bNo.setBackground(UIManager.getColor("Button.background"));
			
			//	e.getComponent().setBackground(UIManager.getColor("Button.background"));
			
		}
	} // Fin clase FocusListener

}  // Fin clase Ejemplo01v2







