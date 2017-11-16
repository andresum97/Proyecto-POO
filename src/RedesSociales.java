/*
 * La clase de redes sociales nace de la idea de tener un control sobre
 * la utilizacion del tiempo que se le da a estas
 * La idea principal es colocar especie de "timer" para las redes mas populares
 * con un limite de tiempo de 45 minutos para usarlas, esto con el fin de hacer
 * que los estudiantes aprovechen mejor su tiempo y sean mas productivos
 * 
 * @author Guillermo Sandoval
 * @author Andres Urizar
 * @author Rodrigo Samayoa
 * @version 25/10/2017
 */

import java.util.Timer;

public class RedesSociales {
	/*
	 * La unica razon para no incluir whatsapp en las redes es que simplemente
	 * se considera mas como medio de comunicacion y no lo podemos limitar
	 * aunque hay gente que si pierde un poco el tiempo en esta aplicacion
	 */
	private int horasFB;
	private int horasInst;
	private int horasTwit;
/*
 * Horas totales tiene el fin de saber cuanto tiempo paso el usuario en redes 
 * sociales y su fin es mas que todo que recompense al usuario si la proxima
 * vez las utiliza menos
 */
	private int horasTotales;
	
	public RedesSociales()
	{
		Timer timer = new Timer();
		
		
	}
	/*
	 * Basicamente cada uno de los timer se encarga de guardar cuanto tiempo
	 * ha transcurrido en cada una de las redes sociales ya que estos solo se pueden
	 * utilizar una vez maximo
	 */
	public void timerFB()
	{
		
	}
	public void timerInst()
	{
		
	}
	public void timerTwit()
	{
		
	}
}