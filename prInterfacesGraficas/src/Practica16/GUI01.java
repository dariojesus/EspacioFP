package Practica16;


import java.awt.*;
import javax.swing.*;

public class GUI01 {

	public static void main(String[] args) {
		//Se crea la ventana
		JFrame jf = new JFrame("Ejemplo GUI1");
		
		//Se crea el contenedor
		Container contenedor = jf.getContentPane();
		contenedor.setLayout(new FlowLayout());  //Si lo quitamos los botones se vuelven grandes conforme agrandamos la ventana
		
		//Creamos el panel principal que albergará los botones
		JPanel interno = new JPanel();
		interno.setLayout(new GridLayout(4,2));
		
		//Se crean los botones y añadimos colores y tooltip
		JButton b1 = new JButton("Primero");
		b1.setBackground(new Color(22, 160, 133));
		
		JButton b2 = new JButton("Segundo");
		b2.setBackground(new Color(230, 126, 34));
		
		JButton b3 = new JButton("Tercero");
		b3.setToolTipText("Boton tercero");
		b3.setBackground(new Color(231, 76, 60));
		b3.setForeground(Color.WHITE);
		
		JButton b4 = new JButton("Cuarto");
		JButton b5 = new JButton("Quinto");
		JButton b6 = new JButton("Sexto");
		JButton b7 = new JButton("Septimo");
		JButton b8 = new JButton("Octavo");
		
		//Se añaden al panel interno
		interno.add(b1);
		interno.add(b2);
		interno.add(b3);
		interno.add(b4);
		interno.add(b5);
		interno.add(b6);
		interno.add(b7);
		interno.add(b8);
		
		//Se creal el panel scrollable y se le agrega el panel interno
		JScrollPane principal = new JScrollPane(interno);
		principal.setPreferredSize(new Dimension(130,110));
		
		//Añadimos este panel al contenedor
		contenedor.add(principal);
		
		//Se empaqueta todo y se pone en visible
		jf.setLocationRelativeTo(null);//Ventana centrada
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
