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
import java.util.TimerTask;
import java.io.*;
import java.util.concurrent.*; 

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
		
	}
	
	int segundos =0;
	Timer temporizador = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			segundos++;
		}
	};
	

	public void timerFB()
	{
		/*
		 * Aqui va la parte donde le ingresan ambos tiempos
		 */
		//long inicio = System.nanoTime(); 
		//long fin = System.nanoTime(); 
		//long tiempoTranscurrido = inicio - fin;
		//double segundos = (double)tiempoTranscurrido / 1000000000.0;
		
		/*
		 * Timer que suma en segundos 1 a 1
		 */
		temporizador.scheduleAtFixedRate(task,1000,1000);

	}
	public void timerInst()
	{		
		/*
		 * Timer que suma en segundos 1 a 1
		 */
		temporizador.scheduleAtFixedRate(task,1000,1000);
		
		
	}
	public void timerTwit()
	{
		/*
		 * Timer que suma en segundos 1 a 1
		 */
		temporizador.scheduleAtFixedRate(task,1000,1000);
	}
}