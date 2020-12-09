package Practica16;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GUI04 {

	public static void main(String[] args) {
		//Creamos la ventana
		JFrame jf = new JFrame("Mi menú de opciones");
		
		//Creamos la barra de menus y containers
		JMenuBar barra = new JMenuBar();
		Container contenedor = jf.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		//Creamos los menus
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Edicion");
		JMenu menu3 = new JMenu("Ver");
		JMenu menu4 = new JMenu("Ayuda");
		
		//Creamos las opciones de cada menu
		JMenuItem item1 = new JMenuItem("Normal");
		JMenuItem item2 = new JMenuItem("Diseño de página");
		JMenuItem item3 = new JMenuItem("Esquema");
		JMenuItem item4 = new JMenu("Barra de herramientas");
		JMenuItem item5 = new JMenuItem("Mapa del documento");
		JMenuItem item6 = new JMenuItem("Zoom");
		
		item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK));//Para shortcut de teclado
		
		//Creamos la entrada anidada
		JCheckBoxMenuItem item41 = new JCheckBoxMenuItem ("Formato");
		JCheckBoxMenuItem item42 = new JCheckBoxMenuItem ("Estándar");
		JCheckBoxMenuItem item43 = new JCheckBoxMenuItem ("Dibujo");
		
		//Creamos los botones del panel
		JComboBox <String> desplegable = new JComboBox <String>();
		desplegable.addItem("Courier New");
		desplegable.addItem("Times New Roman");
		desplegable.addItem("Arial");
		
			JCheckBox negrita = new JCheckBox("Negrita");
			negrita.setBackground(panel.getBackground());
			
			// Cambiar el tipo de letra y tamaño de "Negrita"
			negrita.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
			negrita.setForeground(Color.gray);
		
		JCheckBox cursiva = new JCheckBox("Cursiva");
		cursiva.setBackground(panel.getBackground());
		
		JCheckBox subr = new JCheckBox("Subrayado");
		subr.setBackground(panel.getBackground());
		
		//Añado las entradas a los submenus
		item4.add(item41);
		item4.add(item42);
		item4.add(item43);
		
		//Añado las entradas a los menus
		menu3.add(item1);
		menu3.add(item2);
		menu3.add(item3);
		menu3.add(item4);
		menu3.add(item5);
		menu3.add(item6);
		
		//Añado el menu a la barra de menus
		barra.add(menu1);
		barra.add(menu2);
		barra.add(menu3);
		barra.add(menu4);
		
		//Añado los componentes al panel
		panel.add(desplegable);
		panel.add(negrita);
		panel.add(cursiva);
		panel.add(subr);
		
		//Añado el panel al container
		contenedor.add(panel);
		
		//Añado la barra a la ventana
		jf.setJMenuBar(barra);
		
		//Se empaqueta todo y se pone en visible
		jf.setLocationRelativeTo(null);//Ventana centrada
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
