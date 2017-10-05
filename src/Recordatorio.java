/**
 * Clase Recordatorio donde se definen los métodos para utilizar recordatorios
 * @author Andres Urizar
 * @author Rodrigo Samayoa
 * @author Guillermo Sandoval
 * @version 29/09/17	
 */


import java.util.ArrayList;

public class Recordatorio {
	
	private ArrayList <String> prioridad; //Arraylist para guardar recordatorios de prioridad
	private ArrayList <String> secundario; //Arraylist para guardar recordatorios secundarios
	
	/**
	 * Constructor de la clase
	 */
	public Recordatorio()
	{
		prioridad= new ArrayList<String>();
		secundario= new ArrayList<String>();
	}
	/**
	 * Método para poder ingresar un recordatorio
	 * @param r
	 * @param op
	 */
	public void ingresarRecordatorio(String r,int op)
	{
		if(op == 1)
		{
			prioridad.add(r);
		}else
		if(op == 2)
		{
			secundario.add(r);
		}
			
	}
	/**
	 * Método para mostrar el recordatorio según si es prioritario o secundario
	 * @param op
	 * @return Todos los elementos del arraylist seleccionados
	 */
	public String mostrarRecordatorio(int op)
	{
		String recordatorio = "";
		if(op==1)
		{
			for(String prio:prioridad)
			{
				recordatorio += prio+"\n";
			}
		}else
		if(op==2)
		{
			for(String secun:secundario)
			{
				recordatorio += secun+"\n";
			}
		}
		return recordatorio;
	}
	/**
	 * Método para mostrar elementos de ambos arraylist
	 * @return Todos los elementos de los arraylist
	 */
	public String mostrarTodo()
	{
		String recordatorio = "";
		int cont=0;
		for(String prio:prioridad)
		{
			recordatorio +=cont+"."+prio+"\n";
			cont++;
		}
		recordatorio += "===================================="+"\n";
		cont = 0;
		for(String secun:secundario)
		{
			recordatorio += cont+"."+secun+"\n";
			cont++;
		}
		return recordatorio;
	}
	/**
	 * Método para marcar un recordatorio como realizado y lo borra 
	 * @param op
	 * @param elemento
	 */
	public void marcarRecordatorio(int op,int elemento)
	{
		if(op==1)
		{
				prioridad.remove(elemento);
		}else
		if(op==2)
		{
				secundario.remove(elemento);
		}
	}
}
