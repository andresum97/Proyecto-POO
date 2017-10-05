/**
 * Clase Agenda en la cual se generan los método para utilizar la agenda
 * @author Andres Urizar
 * @author Rodrigo Samayoa
 * @author Guillermo Sandoval
 * @version 29/09/17	
 */


public class Agenda {
	private String[] agenda; //Array para poder guardar los eventos
	/**
	 * Constructor de la clase
	 */
	public Agenda()
	{
		agenda = new String[8];
		for(int i=0;i<8;i++)
		{
			agenda[i] = "";
		}
	}
	/**
	 * Método para ingresar un evento para la agenda
	 * @param dia
	 * @param dato
	 */
	public void ingresarEvento(int dia, String dato)
	{
		String evento = agenda[dia];
		agenda[dia] = evento+"\n"+"*"+dato;
	}
	/**
	 * Método para mostrar un evento de la agenda según su dia
	 * @param dia
	 * @return eventos según el dia
	 */
	public String mostrarEvento(int dia)
	{
		return agenda[dia];
	}
	/**
	 * Método para poder borrar todos los eventos de un dia.
	 * @param dia
	 */
	public void reiniciardia(int dia)
	{
		agenda[dia] = "";
	}
	
	
}
