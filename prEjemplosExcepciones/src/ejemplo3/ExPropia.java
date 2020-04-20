package ejemplo3;
/**
 * Definión de una clase que define una excepcion propia
 */

@SuppressWarnings("serial")
public class ExPropia extends Exception 
{ 
	public ExPropia() { 
		super("Esta es mi propia excepcion");	
	}

	public ExPropia(String s) { 
		super(s); 
	}
}

