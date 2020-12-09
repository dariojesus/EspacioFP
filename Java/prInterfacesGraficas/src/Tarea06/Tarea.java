package Tarea06;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tarea extends JFrame implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Declaramos los componentes como variables de instancia
	private JLabel eti1;
	private JLabel eti2;
	private JLabel eti3;
	
	private JTextField user;
	private JPasswordField pass;
	
	private JButton bAceptar;
	private JButton bCancelar;
	
	
	public Tarea() {
		
		//Nombre de la ventana
		super("Ventana password");
		
		//Creamos contenedor y panel
		Container contenedor = this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3,5,5));
		panel.setBorder(new EmptyBorder(10,30,10,30));
		
		//Declaramos los botones y etiquetas
		eti1 = new JLabel("Usuario",JLabel.RIGHT);
		eti2 = new JLabel("Password",JLabel.RIGHT);
		eti3 = new JLabel("Introduzca usuario y clave",JLabel.CENTER);
		
		user = new JTextField();
		pass = new JPasswordField();
		
		bAceptar = new JButton("Aceptar");
		bCancelar = new JButton("Cancelar");
		
		//Añadimos los controles de los botones
		bAceptar.addActionListener(this);
		bCancelar.addActionListener(this);
		
		//Agregamos los componentes al panel principal
		panel.add(eti1);
		panel.add(user);
		panel.add(bAceptar);
		
		panel.add(eti2);
		panel.add(pass);
		panel.add(bCancelar);
		
		//Agregamos el panel al contenedor
		contenedor.add(panel,BorderLayout.CENTER);
		contenedor.add(eti3,BorderLayout.SOUTH);


	}
	
	/*
	 * Funcion para capturar los eventos (listener)
	 */
	public void actionPerformed(ActionEvent e) {
		
		char contra [] = {'1','2','3','4'};
		
		if (e.getSource()==bAceptar) {
			if (user.getText().equals("dario") && Arrays.equals(pass.getPassword(),contra))
				eti3.setText("Datos correctos");
				
			else {
				eti3.setText("Datos incorrectos");
			    eti3.setForeground(Color.red);}
		
		}
		
		else if (e.getSource()==bCancelar) {
			user.setText("");
			pass.setText("");
			eti3.setForeground(Color.black);
			eti3.setText("Introduzca usuario y clave");
		}
			
	}
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Crear un objeto tipo Ventana
		Tarea ventana = new Tarea();
		
		// Ajuste del contenedor
		ventana.pack();
		ventana.setSize(400,150);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


	
}


