package Practica17;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GUI01 {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("Examen de Java");
		
		Container contenedor = new Container();
		contenedor = jf.getContentPane();
		
		//Paneles del GUI principales
		JPanel pPrincipal = new JPanel();
		pPrincipal.setLayout(new BorderLayout());
		pPrincipal.setBorder(new EmptyBorder(10,30,10,30));
		
		JPanel pNO = new JPanel();
		pNO.setLayout(new FlowLayout());
		
		JPanel pCE = new JPanel();
		pCE.setLayout(new FlowLayout());
		
		JPanel pSU = new JPanel();
		pSU.setLayout(new FlowLayout());
		
		//Paneles mas internos
		JPanel internoIZ = new JPanel();
		internoIZ.setLayout(new GridLayout(3,1));
		internoIZ.setPreferredSize(new Dimension(90,145));
		
		
		JPanel internoDE = new JPanel();
		internoDE.setLayout(new GridLayout(4,1));
		internoDE.setBorder(new CompoundBorder(new TitledBorder("Borde compuesto"),(Border) new BevelBorder(BevelBorder.RAISED)));

		
		//Botones y elementos
		JLabel eti = new JLabel("Esto es un ejercicio de JAVA");
		JLabel eti2 = new JLabel("Marca tu edad:");
		
		JButton b1 = new JButton("Bot�n 1");
		JButton b2 = new JButton("Bot�n 2");
		JButton b3 = new JButton("Bot�n 3");
		
		String array [] = {"Item n�mero 1","Item n�mero 2","Item n�mero 3","Item n�mero 4","Item n�mero 5","Item n�mero 6","Item n�mero 7","Item n�mero 8","Item n�mero 9"};
		JList<String> lista = new JList<String>(array);
		
		JRadioButton box1 = new JRadioButton("Menor de 20");
		JRadioButton box2 = new JRadioButton("Mayor de 20 y menor de 35");
		JRadioButton box3 = new JRadioButton("Mayor de 35 a�os");
		
		JComboBox <String> combo = new JComboBox<String>();
		combo.addItem("Elecci�n 1");
		combo.addItem("Elecci�n 2");
		combo.addItem("Elecci�n 3");
		
		JLabel eti3 = new JLabel("Observaci�n: ");
		
		JTextField texto = new JTextField();
		texto.setPreferredSize(new Dimension(200,25));
		
		//Agregamos los botones a los paneles
		pNO.add(eti);
		
		internoIZ.add(b1);
		internoIZ.add(b2);
		internoIZ.add(b3);
		
		JScrollPane internoCE = new JScrollPane(lista);
		internoCE.setBorder(new EmptyBorder(10,10,10,10));
		
		internoDE.add(eti2);
		internoDE.add(box1);
		internoDE.add(box2);
		internoDE.add(box3);
		
		pSU.add(combo);
		pSU.add(eti3);
		pSU.add(texto);
		
		//A�adimos los paneles
		pCE.add(internoIZ);
		pCE.add(internoCE);
		pCE.add(internoDE);
		
		pPrincipal.add(pNO,BorderLayout.NORTH);
		pPrincipal.add(pCE,BorderLayout.CENTER);
		pPrincipal.add(pSU,BorderLayout.SOUTH);
		
		contenedor.add(pPrincipal);
		
		//Se empaqueta todo y se pone en visible
		jf.setLocationRelativeTo(null);//Ventana centrada
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
