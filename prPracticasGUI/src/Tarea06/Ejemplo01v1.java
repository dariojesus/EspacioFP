package Tarea06;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

/**
 * 
 * La programación de los eventos será en la propia clase, es decir, la clase 
 * implementa las interfaces ActionListener y FocusListener. Por tanto,
 *   
 *    LA PROPIA CLASE ES LA "OYENTE" (la que da respuesta a los eventos)
 * 
 * 
 * En este ejemplo vamos a controlar dos tipos de eventos:
 * 
 *   - Pulsar un botón, esto lo haremos mediante la interfaz ActionListener
 *     que tiene un único método actionPerformed, en este método programaremos 
 *     el cambio de texto de la etiqueta
 *     		
 *   - Ganar o perder el foco de un componente, en este caso de los botones.
 *     Esto lo haremos mediante la interfaz FocusListener, la cual tiene 
 *     dos métodos focusGained y focusLost. En estos métodos programaremos 
 *     el cambio de color de los botones, naranja cuando gana el foco, y
 *     el color por defecto cuando lo pierde
 * 
 * @version 1.0
 * @author Asus
 *
 */

public class Ejemplo01v1 extends JFrame implements ActionListener,
													  FocusListener
{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Variables de instancia
	 * 
	 * Ahora los componentes los definimos como variables de instancia, ya
	 * que sino, no podríamos acceder a ellas desde otros métodos, sino que
	 * solo estarían accesibles en el constructor
	 * 
	 * En este ejemplo accedo a la variable bSi, y a etiqueta desde los métodos
	 * de las interfaces ActionListener y FocusListener
	 */
	private JLabel etiqueta;
	private JButton bSi;
	private JButton bNo;
	
	
	/**
	 * Constructor
	 */
	public Ejemplo01v1() {

		// Poner título al contenedor
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
		
		// Añadir el control de botones a los botones Si y No
		// Especifico this, porque es esta clase la "oyente", es decir
		// la misma clase está implementado la interfaz ActionListener
		bSi.addActionListener(this);
		bNo.addActionListener(this);
		
		// Añadir el control del foco a los botones Si y No
		// Especifico this, porque es esta clase la "oyente", es decir
		// la misma clase está implementado la interfaz FocusListener
		bSi.addFocusListener(this);
		bNo.addFocusListener(this);
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Crear un objeto tipo Ventana
		Ejemplo01v1 ventana = new Ejemplo01v1();
		
		// Ajuste del contenedor
		ventana.pack();

		// Establecer un tamaño para la ventana
		ventana.setSize(400,150);

		// Poner visible el contenedor
		ventana.setVisible(true);

		// Programar el cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/** 
	 * ----------------------------------------------------------------------------
	 * Método de la interfaz ActionListener
	 *    Este código se ejecutará cuando se pulse un botón 
	 *    
	 * @param e --> Es el objeto que ha provocado el evento
	 * ----------------------------------------------------------------------------
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==bSi)  // Pregunto si se ha pulsado el botón Si
			etiqueta.setText("Si pulsado");
		else
			etiqueta.setText("No pulsado");
	}

	
	/**
	 * -----------------------------------------------------------------------------
	 * Métodos de la interfaz FocusListener
	 * -----------------------------------------------------------------------------
	 */
	
	/**
	 * Método que se ejecuta de forma automática cuando un componente (en este caso
	 * un botón) gana el foco
	 * 
	 * @param e --> Es el objeto que ha provocado el evento
	 */
	@Override
	public void focusGained(FocusEvent e) {

		if (e.getSource()==bSi)  // Pregunto si se ha pulsado el botón Si
			bSi.setBackground(Color.ORANGE);
		else
			bNo.setBackground(Color.ORANGE);
		
		// Otra alternativa, en la que nos habríamos ahorrado el if, habría sido
		// utilizando el método getComponent, sobre el parámetro que es 
		// el objeto que ha provocado el evento
		//	e.getComponent().setBackground(Color.ORANGE);
	}

	
	/**
	 * Método que se ejecuta de forma automática cuando un componente 
	 * pierde el foco
	 * 
	 * @param e --> Es el objeto que ha provocado el evento
	 */
	@Override
	public void focusLost(FocusEvent e) {
	
		if (e.getSource()==bSi)  // Pregunto si se ha pulsado el botón Si
			bSi.setBackground(UIManager.getColor("Button.background"));
		else
			bNo.setBackground(UIManager.getColor("Button.background"));
		
//		e.getComponent().setBackground(UIManager.getColor("Button.background"));
		
	}
}







