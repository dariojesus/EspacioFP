package Practica19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox mel;
	private JCheckBox nar;
	private JCheckBox plt;
	private JCheckBox man;
	private JTextArea area;
	
	public Ejercicio3() {
		super("Prueba de eventos item");
		
		//Creo paneles y contenedores
		Container contenedor = this.getContentPane();
		
		JPanel principal = new JPanel();
		
		JPanel izquierdo = new JPanel();
		izquierdo.setLayout(new GridLayout(4,1));
		
		//Inicializo los botones
		mel = new JCheckBox("Melón");
		nar = new JCheckBox("Naranja");
		plt = new JCheckBox("Plátano");
		man = new JCheckBox("Manzana");
		
		area = new JTextArea("");
		area.setEditable(false);
		area.setPreferredSize(new Dimension(250,150));
		JScrollPane derecho = new JScrollPane(area);
		
		
		//Agrego el listener a los botones
		escuchaObjetos item = new escuchaObjetos();
		
		mel.addItemListener(item);
		nar.addItemListener(item);
		plt.addItemListener(item);
		man.addItemListener(item);
		
		//Agrego botones
		izquierdo.add(mel);
		izquierdo.add(nar);
		izquierdo.add(plt);
		izquierdo.add(man);
		
		//Junto los paneles
		principal.add(izquierdo,BorderLayout.EAST);
		principal.add(derecho,BorderLayout.WEST);
		contenedor.add(principal);
		

	}
	
	class escuchaObjetos implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent box) {
			
			int caso = box.getStateChange();
			JCheckBox caja = (JCheckBox) box.getItem();
			
			
			String texto = "Componente: "+caja.getText()+
							"\nEstado actual: "+(caso==1)+
							"\nEstado actual: "+caso+
							"\n"+(caso==1?"Seleccionado":"No seleccionado");
			
			area.append(texto+"\n\n");
			
		}
	}

	/**
	* Programa principal
	 */
	public static void main(String[] args) {

			// Crear un objeto tipo Ventana
			Ejercicio3 ventana = new Ejercicio3();
			
			// Ajuste del contenedor
			ventana.pack();
			ventana.setSize(400,250);
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}

