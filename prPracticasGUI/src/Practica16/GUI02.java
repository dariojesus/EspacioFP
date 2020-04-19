package Practica16;

import java.awt.event.KeyEvent;

import javax.swing.*;

public class GUI02 {

	public static void main(String[] args) {
		//Creamos la ventana
		JFrame jf = new JFrame("Mi menú de opciones");
		
		//Creamos la barra de menus
		JMenuBar barra = new JMenuBar();
		
		//Creamos los menus
		JMenu menu1 = new JMenu("Entrada 1");
		JMenu menu2 = new JMenu("Entrada 2");
		JMenu menu3 = new JMenu("Ayuda");
		
		//Creamos las opciones de cada menu
		JMenuItem item1 = new JMenuItem("SubEntrada 1.1");
		JMenuItem item2 = new JMenuItem("SubEntrada 1.2");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));//Para shortcut de teclado
		
		
		JMenuItem item3 = new JMenu("SubEntrada 1.3");
		
		//Creamos la entrada anidada
		JMenuItem item31 = new JMenuItem ("Subentrada 1.3.1");
		JCheckBoxMenuItem item32 = new JCheckBoxMenuItem ("Subentrada 1.3.2");
		
		//Añado las entradas a los submenus
		item3.add(item31);
		item3.add(item32);
		
		//Añado las entradas a los menus
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		//Añado el menu a la barra de menus
		barra.add(menu1);
		barra.add(menu2);
		barra.add(menu3);
		
		//Añado la barra a la ventana
		jf.setJMenuBar(barra);
		
		//Se empaqueta todo y se pone en visible
		jf.setLocationRelativeTo(null);//Ventana centrada
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

}
