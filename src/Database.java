/**
 * Clase de Database, donde se trabaja todo lo mongo
 */

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;


public class Database {
	private MongoClient mongo;
    private Morphia morphia;
    private Datastore datoscalendario;
    private Datastore datosagenda;
    private Datastore datosrecord;
    public Database()
    {
    try
    {
         mongo = new MongoClient("localhost",27017);
         morphia = new Morphia();
         morphia.map(Horario.class);
         morphia.mapPackage("(default package)");
         datoscalendario = morphia.createDatastore(mongo, "Horario");
         datosagenda = morphia.createDatastore(mongo, "Agenda");
         datosrecord = morphia.createDatastore(mongo, "Recordatorios");
    	System.out.println("Connect to Database");
    }catch(Exception e)
    {
    	System.out.println(e);
    }
    }
   
    public Horario[][] cargar(){
    	morphia.mapPackage("(default package)");
    	Horario[][] hor = new Horario[11][7];
    	Query<Horario> query = datoscalendario.createQuery(Horario.class);
    	List<Horario> t1 = query.asList();
        for (Horario t: t1){
        	for (int j=0;j<7;j++){
    			for(int i=0;i<11;i++) {
    				hor[j][i] = t;
    			}
        } 
    }
        return hor;
    }
  /**  public void guardar(Horario[][] hor) {
    	Horario x; 
    	for (int j=0;j<7;j++){
			for(int i=0;i<11;i++) {
				x = hor[j][i];
				datoscalendario.save(x);
			}
		
    }
    }*/
    public void guardarHorario(Horario hor)
    {
    	datoscalendario.save(hor);
    }
    public void guardarAgenda(Agenda agenda)
    {
    	datosagenda.save(agenda);
    }
    public void guardarRecordatorio(Recordatorio record)
    {
    	datosrecord.save(record);
    }
}
