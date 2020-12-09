package Practica15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Practica15 {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame ("Componentes varios");
		
		Container contenedor = jf.getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		//Panel principal
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		
		//Paneles internos al principal
			JPanel internoIZ = new JPanel();
			internoIZ.setLayout(new GridLayout(2,1));
			
			JPanel internoCE = new JPanel();
			internoCE.setLayout(new BorderLayout());
			
		
			//Panel externo al principal y ubicado al sur
			JPanel externoSU = new JPanel();
			externoSU.setLayout(new FlowLayout());
		
		//Componentes del panel izquierdo
		JButton b1 = new JButton("Botón 1");
		JButton b2 = new JButton("Botón 2");
		internoIZ.add(b1);
		internoIZ.add(b2);
		
		//Componentes del panel central
		JLabel label = new JLabel("Etiqueta");
		internoCE.add(label,BorderLayout.NORTH);
		
		JTextArea texto = new JTextArea("Area de texto");
		JScrollPane internoTx = new JScrollPane(texto);//TextArea debe de estar en un JScrollPane 
		internoTx.setPreferredSize(new Dimension(100,150));
		internoCE.add(internoTx,BorderLayout.SOUTH);
		
		//Componentes del panel derecho
		
			//Hacemos un array de elementos con el que llenaremos la lista
			String [] arry = new String[15];
			for (int i=0; i<arry.length; i++)
			arry[i] = "Item número "+(i+1);

		
		JList<String> lista = new JList<String>(arry);
		JScrollPane internoDE = new JScrollPane(lista);
		
		//Componentes del panel inferior
		JTextField texto1 = new JTextField("Campo de texto");
		texto1.setPreferredSize(new Dimension(100,20));
		JCheckBox ck = new JCheckBox("Check Box");
		
		JComboBox<String> cb = new JComboBox<String>();
			for (int i = 1 ; i <= 10 ; i++)
					cb.addItem("Opción: "+i);
			
		
		externoSU.add(texto1);
		externoSU.add(ck);
		externoSU.add(cb);
		
		//Componentes del panel norte (color chooser)
		JColorChooser color = new JColorChooser();
		
		//Juntamos todos los paneles
		panel.add(internoIZ);
		panel.add(internoCE);
		panel.add(internoDE);
		
		//Lo añadimos al contenedor
		contenedor.add(panel,BorderLayout.CENTER);
		contenedor.add(externoSU,BorderLayout.SOUTH);
		contenedor.add(color,BorderLayout.NORTH);
		
		//Se empaqueta todo y se pone en visible
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
