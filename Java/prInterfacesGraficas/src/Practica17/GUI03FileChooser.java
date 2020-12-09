package Practica17;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GUI03FileChooser {

	public static void main(String[] args) {
		
		// Crear un JFrame
		JFrame f = new JFrame("Ventana con diálogo de Abrir/Guardar");
		
		// Crear un objeto de tipo JFileChooser (ventana de diálogo para
		// mostrar el explorador que permite abrir o guardar un documento)
		
		JFileChooser fc = new JFileChooser("C:\\Users\\jesus"); // Poner una ruta válida en vuestro equipo
		
		// Llamar al método que establece el JFileChooser en modo "abrir"
		fc.showOpenDialog(f);
		
		// Llamar al método que establece el JFileChooser en modo "guardar"
		fc.showSaveDialog(f);
		
		// Poner visible el JFileChooser
		fc.setVisible(true);
		
		// Establecer tamaño y poner visible el JFrame
		f.setVisible(true);
		f.setSize(200,100);
		
		// Programar el cierre de la ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}


