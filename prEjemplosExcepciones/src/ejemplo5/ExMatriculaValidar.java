package ejemplo5;

/**
 * Clase que permite validar matr�culas
 * 
 * Se consideran matr�culas v�lidas las que tienen una longitud
 * de 8 s�mbolos, siendo el primero una letra
 *
 */

public class ExMatriculaValidar {

   /**
    *  Aisla el primer caracter y comprueba que es una letra empleando 
    *  el m�todo matches
    * 
    * @param Matricula
    * @return true o false
    */
   private boolean unaLetra(String Matricula) {
     return Matricula.substring(0,1).matches("[A-Za-z��]");
   }

   
   /**
    * M�todo que valida si una matr�cula es correcta
    * @param Matricula
    * @throws ExMatricula
    */
   public void validar(String matricula) throws ExMatricula {
	   if (matricula.length()!=8) 
		   throw new ExMatricula(ExMatricula.MAL_TAMANIO);
	   else
		   if (!unaLetra(matricula))
			   throw new ExMatricula(ExMatricula.MAL_LETRA);
		   else
			   System.out.println("Matr�cula correcta");
   }

}







