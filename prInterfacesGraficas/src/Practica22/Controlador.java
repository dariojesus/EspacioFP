package Practica22;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.UIManager;

public class Controlador implements ActionListener, FocusListener, KeyListener {
	
	//variables de instancia
	private Vista miVista;
	private ProcesaDatos pd;
	
	//Constructor
	public Controlador (Vista v) {
		miVista=v;
		pd = new ProcesaDatos(miVista.getTfRdo());
	}

	//Metodos del keyListener (los dos primeros no nos interesan)
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		//Obtenemos el valor de la tecla pulsada
		char valorTecla = arg0.getKeyChar();
		JButton bp = null;
		
		try {
			//bp = asignaFoco(valorTecla);
			
			if (bp!=null)
				pd.procesa(valorTecla);
		}
		catch(MiExcepcion e){
			miVista.getTfRdo().setText(e.getMessage());
			bp.setBackground(Color.red);
		}
		
	}
	
	//Metodos para implementar el ActionListener

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Obtenemos la referencia al boton pulsado
		JButton bPulsado = (JButton)arg0.getSource();
		
		//Obtenemos el caracter tiene el boton pulsado
		char botonValor = bPulsado.getActionCommand().charAt(0);
		
		//Utilizamos la clase que tenemos ya de procesamiento
		try {
			pd.procesa(botonValor);
		}
		catch (MiExcepcion e) {
			miVista.getTfRdo().setText(e.getMessage());
			bPulsado.setBackground(Color.red);
			//e.printStackTrace();
		}
		
	}

	
	//Metodos para implementar la interfaz de foco
	@Override
	public void focusGained(FocusEvent arg0) {arg0.getComponent().setBackground(Color.LIGHT_GRAY);}

	@Override
	public void focusLost(FocusEvent arg0) {
		JButton bPulsado = (JButton)arg0.getSource();
		
		if (bPulsado.getText().matches("[0-9]")) // <--- Con expresiones regulares muy util
			bPulsado.setBackground(Color.cyan);
		else
			bPulsado.setBackground(UIManager.getColor("Button.background"));
		
	}

}
