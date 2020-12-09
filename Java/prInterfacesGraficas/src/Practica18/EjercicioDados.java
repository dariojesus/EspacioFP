package Practica18;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class EjercicioDados extends JFrame {

	
	/**
	 * Variables de instancia
	 */
	private static final long serialVersionUID = 1L;
	private JButton lanzar;
	private JTextField jTexto1;
	private JTextField jTexto2;
	private JTextField resul1;
	private JTextField resul2;
	private JLabel info;
	private JLabel puntos;
	
	/**
	 * Variables para la ejecución del Action
	 */
	private Random rn = new Random();
	
	
	public EjercicioDados() {
		//Ventana y contenedor
		super("Jugar a los dados");
		this.setPreferredSize(new Dimension(400,300));
		this.setIconImage(new ImageIcon("recursos/dados.gif").getImage());
		
		Container contenedor = this.getContentPane();
		
		//Creación de los paneles de la interfaz
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panelNorte = new JPanel();
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(1,2));
		
			JPanel pCentroIz = new JPanel();
			pCentroIz.setLayout(new GridLayout(2,1));
			pCentroIz.setBorder(new CompoundBorder(new TitledBorder("Apuesta Jugador"),new BevelBorder(BevelBorder.RAISED)));
			
			JPanel pCentroDe = new JPanel();
			pCentroDe.setLayout(new GridLayout(2,1));
			pCentroDe.setBorder(new CompoundBorder(new TitledBorder("Resultado"),new BevelBorder(BevelBorder.RAISED)));
		
		JPanel panelSur= new JPanel();
		
		//Componentes de los paneles
		info = new JLabel("Puntos obtenidos: ");
		info.setForeground(Color.red);
		info.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		puntos = new JLabel("0");
		puntos.setForeground(Color.red);
		puntos.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		jTexto1 = new JTextField("");
		jTexto1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		jTexto1.setBorder(new CompoundBorder(new TitledBorder("Dado 1"),new BevelBorder(BevelBorder.RAISED)));
		
		jTexto2 = new JTextField("");
		jTexto2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		jTexto2.setBorder(new CompoundBorder(new TitledBorder("Dado 2"),new BevelBorder(BevelBorder.RAISED)));
		
		resul1 = new JTextField("");
		resul1.setEditable(false);
		resul1.setBackground(Color.white);
		resul1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		resul1.setBorder(new CompoundBorder(new TitledBorder("Dado 1"),new BevelBorder(BevelBorder.RAISED)));
		
		resul2 = new JTextField("");
		resul2.setEditable(false);
		resul2.setBackground(Color.white);
		resul2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		resul2.setBorder(new CompoundBorder(new TitledBorder("Dado 2"),new BevelBorder(BevelBorder.RAISED)));
		
		lanzar = new JButton("Lanzar dados",new ImageIcon("recursos/dados-03.gif"));
		lanzar.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		
		//Configuramos el boton lanzar para que produzca evento
		controlEvento lanzamiento = new controlEvento();
		
		lanzar.addActionListener(lanzamiento);
		
		//Metemos los componentes en los paneles
		panelNorte.add(info);
		panelNorte.add(puntos);
		
		pCentroIz.add(jTexto1);
		pCentroIz.add(jTexto2);
		
		pCentroDe.add(resul1);
		pCentroDe.add(resul2);
		
		panelSur.add(lanzar);
		
		//Metemos los paneles anidados en sus paneles principales
		
		panelCentro.add(pCentroIz);
		panelCentro.add(pCentroDe);
		
		panel.add(panelNorte,BorderLayout.NORTH);
		panel.add(panelCentro,BorderLayout.CENTER);
		panel.add(panelSur,BorderLayout.SOUTH);
		
		contenedor.add(panel);
	}
	
	class controlEvento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0){

			//Se lanza y captura la excepción en el caso de que los numeros introducidos no sean válidos
			try {
			
				if (Integer.parseInt(jTexto1.getText()) < 1 || Integer.parseInt(jTexto1.getText()) > 6)
					throw new NumberFormatException();
				
				
				//Si todo va bien se empieza a ejecutar y se generan los numeros random
				resul1.setText(Integer.toString(rn.nextInt(6)+1));
				resul2.setText(Integer.toString(rn.nextInt(6)+1));
				
				//Guardamos las 4 posibles comparaciones que hay 
				boolean priCoincide = jTexto1.getText().equals(resul1.getText());
				boolean segCoincide = jTexto2.getText().equals(resul2.getText());
				boolean priAlterno = jTexto1.getText().equals(resul2.getText());
				boolean segAlterno = jTexto2.getText().equals(resul1.getText());
				
				//Vamos comprobando los resultados y se van sumando los puntos conforme a los dispuesto en el juego
				if ((priCoincide && segCoincide) || (priAlterno && segAlterno)) {
					puntos.setText(Integer.toString(Integer.parseInt(puntos.getText()) + 25));
					
				} else if (priCoincide || segCoincide || priAlterno || segAlterno) {
					puntos.setText(Integer.toString(Integer.parseInt(puntos.getText()) + 10));
					
				} else {
					puntos.setText(Integer.toString(Integer.parseInt(puntos.getText()) - 5));
				}
			}
		
		//Aqui se captura la excepción y se muestra una ventana de error en el caso de que se produzca
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El número debe estar entre comprendido entre 1 y 6","Dato incorrecto" , JOptionPane.ERROR_MESSAGE);} 
		}
		
	}
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

			// Crear un objeto tipo Ventana
			EjercicioDados dados = new EjercicioDados();
			
			// Ajuste del contenedor
			dados.pack();
			dados.setVisible(true);
			dados.setLocationRelativeTo(null);//Ventana centrada
			dados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}

	}
	

