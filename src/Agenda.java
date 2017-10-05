/**
 * Clase Agenda en la cual se generan los m�todo para utilizar la agenda
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
	 * M�todo para ingresar un evento para la agenda
	 * @param dia
	 * @param dato
	 */
	public void ingresarEvento(int dia, String dato)
	{
		String evento = agenda[dia];
		agenda[dia] = evento+"\n"+"*"+dato;
	}
	/**
	 * M�todo para mostrar un evento de la agenda seg�n su dia
	 * @param dia
	 * @return eventos seg�n el dia
	 */
	public String mostrarEvento(int dia)
	{
		return agenda[dia];
	}
	/**
	 * M�todo para poder borrar todos los eventos de un dia.
	 * @param dia
	 */
	public void reiniciardia(int dia)
	{
		agenda[dia] = "";
	}
	
	
}
