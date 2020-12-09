package Practica22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton [] bDigitos; //Array de digitos
	private JButton [] bOperadores; //Array de operadores
	private JButton bPunto, bIgual;
	private JTextField tfRdo;
	
	/*
	 * Constructor
	 */
	public Vista() {
		JPanel panelPrincipal = new JPanel (new BorderLayout (5,5));
		
		//Se preparan los subpaneles y se insertan al principal
		panelPrincipal.add(preparaPanelCentro(),BorderLayout.CENTER);
		panelPrincipal.add(preparaPanelEste(),BorderLayout.EAST);
		panelPrincipal.add(preparaPanelResultado(),BorderLayout.NORTH);
		
		this.add(panelPrincipal);
		}
	
	private JPanel preparaPanelCentro() {
		
		bDigitos = new JButton[10];
		
		//Se crean los botones del 0 al 9
		for (int i = 0 ; i < bDigitos.length; i++) {
			bDigitos[i] = new JButton (String.valueOf(i));
			bDigitos[i].setBackground(Color.cyan);
			bDigitos[i].setBorder(new BevelBorder (BevelBorder.RAISED));
		}
		
		//Botones punto e igual
		bPunto = new JButton(".");
		bIgual = new JButton("=");
		bPunto.setBorder(new BevelBorder (BevelBorder.RAISED));
		bIgual.setBorder(new BevelBorder (BevelBorder.RAISED));
		
		//Creamos el panel de los botones
		JPanel p = new JPanel(new GridLayout(4,3));
		
		//Se agregan los botones del 1 al 9 en el panel
		for (int i=1 ; i < bDigitos.length; i++)
			p.add(bDigitos[i]);
		
		//Se agregan los botones restantes
		p.add(bPunto);
		p.add(bDigitos[0]);
		p.add(bIgual);
		
		return p;
	}
	
	private JPanel preparaPanelEste() {
		bOperadores = new JButton [4];
		
		//Se van creando los 4 botones
		bOperadores [0] = new JButton(" + ");
		bOperadores [1] = new JButton(" - ");
		bOperadores [2] = new JButton(" * ");
		bOperadores [3] = new JButton(" / ");
		
		//Le damos un alias a los botones (quitandole los espacios en blanco)
		bOperadores[0].setActionCommand("+");
		bOperadores[1].setActionCommand("-");
		bOperadores[2].setActionCommand("*");
		bOperadores[3].setActionCommand("/");
		
		//Creamos un tipo de fuente comun para todos
		Font fuente = new Font("Courier",Font.PLAIN, 14);
		
		//Creamos el panel al que agregaremos todos estos botones
		JPanel p = new JPanel(new GridLayout(4,1));
		for (int i = 0; i<bOperadores.length; i++) {
			bOperadores[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			bOperadores[i].setFont(fuente);
			p.add(bOperadores[i]);
		}
		
		return p;
		
	}
	
	private JPanel preparaPanelResultado() {
		tfRdo = new JTextField("",10);
		
		//Le damos un formato adecuado
		tfRdo.setEditable(false);
		tfRdo.setBackground(Color.white);
		tfRdo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Preparamos el panel para colocar el texto
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Resultado"));
		p.add(tfRdo);
		
		return p;
	}
	
	public void control (Controlador ctr) {
		
		//Agregamos los listener de los tres eventos que tenemos a todos los botones
		for (int i = 0 ; i < bDigitos.length; i++) {
			bDigitos[i].addActionListener(ctr);
			bDigitos[i].addKeyListener(ctr);
			bDigitos[i].addFocusListener(ctr);
		}
		
		for (int i = 0 ; i < bOperadores.length; i++) {
			bOperadores[i].addActionListener(ctr);
			bOperadores[i].addKeyListener(ctr);
			bOperadores[i].addFocusListener(ctr);
		}
		
		bPunto.addActionListener(ctr);
		bPunto.addKeyListener(ctr);
		bPunto.addFocusListener(ctr);
		
		bIgual.addActionListener(ctr);
		bIgual.addKeyListener(ctr);
		bIgual.addFocusListener(ctr);
		
		//Al texto tambien hay que añadirle el key listener para que comience a funcionar sin necesidad del raton
		tfRdo.addKeyListener(ctr);
	}
	
	

	public JButton[] getbDigitos() {
		return bDigitos;
	}

	public void setbDigitos(JButton[] bDigitos) {
		this.bDigitos = bDigitos;
	}

	public JButton[] getbOperadores() {
		return bOperadores;
	}

	public void setbOperadores(JButton[] bOperadores) {
		this.bOperadores = bOperadores;
	}

	public JButton getbPunto() {
		return bPunto;
	}

	public void setbPunto(JButton bPunto) {
		this.bPunto = bPunto;
	}

	public JButton getbIgual() {
		return bIgual;
	}

	public void setbIgual(JButton bIgual) {
		this.bIgual = bIgual;
	}

	public JTextField getTfRdo() {
		return tfRdo;
	}

	public void setTfRdo(JTextField tfRdo) {
		this.tfRdo = tfRdo;
	}
	
	

}
