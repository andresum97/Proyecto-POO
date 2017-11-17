/**
 * Clase Horario para poder utilizar el horario
 * @author Andres Urizar
 * @author Rodrigo Samayoa
 * @author Guillermo Sandoval
 * @version 29/09/17	
<<<<<<< HEAD
=======
 * 
>>>>>>> branch 'master' of https://github.com/andresum97/Proyecto-POO.git
 */

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
@Entity
public  class Horario {
	@Id private ObjectId id; 
	@Embedded
	private String[][] clases; //Matr�z para guardar las clases
	/**
	 * Constructor de la clase
	 */
	public Horario(){ }
	public Horario(int x,int y)
	{
		clases = new String[x][y];
		for (int j=0;j<x;j++){
			for(int i=0;i<y;i++){
				clases[j][i]=" ";
			}
		}
	}
	/**
	 * m�todo para ingresar una clase al horario, segu�n la hora y el dia
	 * @param dia
	 * @param hora
	 * @param clase
	 */
	public void ingresarClase(int dia,int hora,String clase)
	{
		clases[dia][hora] = clase;
	}
	/**
	 * M�todo para mostrar la clase en su respectivo dia y hora.
	 * @param dia
	 * @param hora
	 * @return la clase del dia seleccionado y de esa hora.
	 */
	public String mostrarClase(int dia,int hora)
	{
		return clases[dia][hora];
	}
}
