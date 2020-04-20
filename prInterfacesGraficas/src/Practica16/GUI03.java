package Practica16;


import java.awt.*;
import javax.swing.*;

public class GUI03 {

	public static void main(String[] args) {
		
		//Creamos la ventana
		JFrame jf = new JFrame("Mi calculadora");

		//Creamos el contenedor
		Container contenedor = jf.getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		//Creamos los paneles 
		JPanel panelN = new JPanel();
		panelN.setLayout(new FlowLayout());
		
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(4,4));
		
		JPanel panelS = new JPanel();
		panelS.setLayout(new FlowLayout());
		
		//Creamos los componentes
		JLabel eti = new JLabel("Resultado ");
		JTextField res = new JTextField();
		res.setPreferredSize(new Dimension(100,25));
		
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton op1 = new JButton("+");
		JButton op2 = new JButton("-");
		JButton op3 = new JButton("*");
		JButton op4 = new JButton("/");
		JButton op5 = new JButton(".");
		JButton op6 = new JButton("=");
		
		ButtonGroup grupo = new ButtonGroup();
		
		JRadioButton dec = new JRadioButton("Dec");
		JRadioButton bin = new JRadioButton("Bin");
		JRadioButton hex = new JRadioButton("Hex");
		JRadioButton oct = new JRadioButton("Oct");
		
		//Agregamos los componentes a los paneles
		
		panelN.add(eti);
		panelN.add(res);
		
		 //Panel de la calculadora
			panelC.add(b1);
			panelC.add(b2);
			panelC.add(b3);
			panelC.add(op1);
			
			panelC.add(b4);
			panelC.add(b5);
			panelC.add(b6);
			panelC.add(op2);
			
			panelC.add(b7);
			panelC.add(b8);
			panelC.add(b9);
			panelC.add(op3);
			
			panelC.add(b0);
			panelC.add(op5);
			panelC.add(op6);
			panelC.add(op4);
			
		//Panel sur
		grupo.add(dec);
		grupo.add(bin);
		grupo.add(hex);
		grupo.add(oct);
		
		panelS.add(dec);
		panelS.add(bin);
		panelS.add(hex);
		panelS.add(oct);
		
		//Añadimos los paneles al contenedor
		contenedor.add(panelN,BorderLayout.NORTH);
		contenedor.add(panelC,BorderLayout.CENTER);
		contenedor.add(panelS,BorderLayout.SOUTH);
		contenedor.add(new JLabel("       "),BorderLayout.EAST);
		contenedor.add(new JLabel("       "),BorderLayout.WEST);
		
		//Se empaqueta todo y se pone en visible
		jf.setLocationRelativeTo(null);//Ventana centrada
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
