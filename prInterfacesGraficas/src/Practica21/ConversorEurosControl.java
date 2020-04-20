package Practica21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ConversorEurosControl implements ActionListener {

	//Variable de instancia
	private ConversorEurosVista miVista;
	
	//Con el constructor hacemos que las variables sean accesibles
	public ConversorEurosControl(ConversorEurosVista v) {
		this.miVista = v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Float valor;
		JButton bp = (JButton)arg0.getSource();

		try // Control de excepciones
		 {
			 
			
			if (bp==miVista.getB3()) {
				miVista.getSalida().setText("");
				desglosar();
				}
			 
			 
			 else {
					 // Especificar el que punto decimal será ".", sino lo hacéis os fallará
					 DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
					 simbolos.setDecimalSeparator('.');
	
					 // Indicar que formatearemos los números con dos decimales
					 // y con el punto decimal
					 DecimalFormat patron = new DecimalFormat("0.00",simbolos);
	
					 if (bp==miVista.getB2()) { // Conversion a dolares
					 valor = (Float.valueOf(miVista.getEntrada().getText())) * miVista.getCambio();
					 miVista.getEntrada().setText(patron.format(valor).toString());
					 }
			 
			 
					 else { // Conversión a euros
					 valor = (Float.valueOf(miVista.getEntrada().getText())) / miVista.getCambio();
					 miVista.getEntrada().setText(patron.format(valor).toString());
					 }
			 }

		 }// Fin try
		 catch (NumberFormatException e1) { JOptionPane.showMessageDialog(bp, "Debe introducir un número.");}

	}
	
	private void desglosar() {
		
		float [] array = {500,200,100,50,20,10,5,2,1,(float) 0.50,(float) 0.20,(float) 0.10,(float) 0.05,(float) 0.02,(float) 0.01};
		float dinero = Float.parseFloat(miVista.getEntrada().getText());
		
		int cont = 0;
		while (dinero > 0.00 && cont < array.length) {
			
			if(array[cont] <= dinero) {
				dinero = dinero - array[cont];
				miVista.getSalida().append("1 " + (cont>6?"moneda":"billete") + " de "+ array[cont] +" "+ (cont>8?"céntimos":"euros") +"\n");
				cont = 0;
			}
			
			else cont++;
		}
	}


}
