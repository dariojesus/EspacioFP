package Practica18;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;


public class Practica18 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Variable de instancia
	private JTextArea texto;
	
	//Array para la lista y el combo
	String [] arry = new String [10];
	
	
	public Practica18() {
		
		//Le damos nombre a la ventana
		super("Ejemplo con focus listener");
		
		
		//Rellenamos el array para la lista y el combo
		for (int i = 1 ; i < arry.length ; i++) {
			arry[i]="Lista item #"+i;
		}
		
		
		//Hacemos el contenedor y paneles
		Container contenedor = this.getContentPane();
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		JPanel panelNorte = new JPanel();
		
		JPanel panelSur = new JPanel();
		
		//Creamos los componentes
		JTextField tex = new JTextField("Campo de texto");
		JLabel etiq = new JLabel("Una etiqueta");
		JButton boton = new JButton("Botón");
		
		
		texto = new JTextArea();
		texto.setPreferredSize(new Dimension(500,50));
		
		JScrollPane panelSurIn = new JScrollPane(texto);

		
		//El combo box y la lista toma los valores del array
		JComboBox<String> combo = new JComboBox<String>(arry);
		JList<String> lista = new JList<String>(arry);
		
		
		JScrollPane panelCentro = new JScrollPane(lista);//Debe ser inicializado aqui 
		
		//Añadimos los listener 
		
		focosGestion focus = new focosGestion();
		
		tex.addFocusListener(focus);
		etiq.addFocusListener(focus);
		boton.addFocusListener(focus);
		texto.addFocusListener(focus);
		lista.addFocusListener(focus);
		combo.addFocusListener(focus);
		
		//Añadimos los componentes a sus respectivos paneles
		panelNorte.add(tex);
		panelNorte.add(etiq);
		panelNorte.add(combo);
		panelNorte.add(boton);
		
		panelSur.add(panelSurIn);
		
		
		
		//Añadimos al panel principal los otros paneles
		panelPrincipal.add(panelNorte,BorderLayout.NORTH);
		panelPrincipal.add(panelCentro,BorderLayout.CENTER);
		panelPrincipal.add(panelSur,BorderLayout.SOUTH);
		
		//Añadimos el panel al contenedor
		contenedor.add(panelPrincipal);
		
	}
	
	
	class focosGestion implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {texto.append("Foco ganado :"+arg0.getComponent());}

		@Override
		public void focusLost(FocusEvent arg0) {texto.append("Foco perdido : "+arg0.getComponent());}
	}

	
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Crear un objeto tipo Ventana
		Practica18 ventana = new Practica18();
		
		// Ajuste del contenedor
		ventana.pack();
		ventana.setSize(400,150);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
	

}
