

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import com.mongodb.DB;
import com.mongodb.MongoClient;


public class Database {
	private MongoClient mongo;
    private Morphia morphia;
    private Datastore datoscalendario;
    private DB db;
    public Database()
    {
    try
    {
         mongo = new MongoClient("localhost",27017);
         morphia = new Morphia();
         morphia.mapPackage("(default package)");
         datoscalendario = morphia.createDatastore(mongo, "Horario");
    	System.out.println("Connect to Database");
    }catch(Exception e)
    {
    	System.out.println(e);
    }
    }
   
    public Horario[][] cargar(){
    	int cont = 0;
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
}
