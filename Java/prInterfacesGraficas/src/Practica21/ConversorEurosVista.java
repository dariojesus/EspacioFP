package Practica21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class ConversorEurosVista extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2035233245535152258L;
	
	private float cambio;
	private JLabel visor;
	private JTextField entrada;
	private JTextArea salida;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	public ConversorEurosVista(float cambio) {
		this.setLayout(new BorderLayout());
		
		this.cambio = cambio;
		this.add(preparaNorte(),BorderLayout.NORTH);
		this.add(preparaCentro(),BorderLayout.CENTER);
		this.add(preparaSur(),BorderLayout.SOUTH);
		
		
	}
	
	public JPanel preparaNorte() {
		
		JPanel norte = new JPanel();
		norte.setLayout(new FlowLayout());
		
		visor = new JLabel("Visor de resultado ");
		
		entrada = new JTextField();
		entrada.setPreferredSize(new Dimension(200,25));
		
		norte.add(visor);
		norte.add(entrada);
		
		return norte;
	}
	
	public JPanel preparaCentro() {
		
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(1,3));
		
		b1 = new JButton("A euros");
		b1.setForeground(Color.blue);
		
		b2 = new JButton("A dolares");
		b2.setForeground(Color.blue);
		
		b3 = new JButton("Desglosar");
		b3.setForeground(Color.blue);
		
		centro.add(b1);
		centro.add(b2);
		centro.add(b3);
		
		return centro;
	}
	
	public JScrollPane preparaSur() {
		
		salida = new JTextArea();
		salida.setPreferredSize(new Dimension(300,300));
		
		JScrollPane sur = new JScrollPane(salida);
		
		return sur;
	}

	public void control (ConversorEurosControl ctr) {
		
		//Aqui agregamos las escuchas a los botones
		this.b1.addActionListener(ctr);
		this.b2.addActionListener(ctr);
		this.b3.addActionListener(ctr);
	}

	public JLabel getVisor() {return visor;}

	public void setVisor(JLabel visor) {this.visor = visor;}

	public JTextField getEntrada() {return entrada;}

	public void setEntrada(JTextField entrada) {this.entrada = entrada;}

	public JTextArea getSalida() {return salida;}

	public void setSalida(JTextArea salida) {this.salida = salida;}

	public JButton getB1() {return b1;}

	public void setB1(JButton b1) {this.b1 = b1;}

	public JButton getB2() {return b2;}

	public void setB2(JButton b2) {this.b2 = b2;}

	public JButton getB3() {return b3;}

	public void setB3(JButton b3) {this.b3 = b3;}

	public float getCambio() {return cambio;}

	public void setCambio(float cambio) {this.cambio = cambio;}
	
	
}
