package implementazione;

import java.util.ArrayList;
import java.util.List;
import entità.Notifiche;
import repository.NotificheRepository;

public class NotificheRepositoryImpl extends JPARepositoryImpl<Notifiche, Integer> implements NotificheRepository {
	
private static NotificheRepository instance = new NotificheRepositoryImpl();
	
    private NotificheRepositoryImpl() {   	
    }

    public static NotificheRepository getInstance() {
        return instance;
    }
    
	public List<Notifiche> findNotificheByIDutenteFK( int intVenditoreID){
    	
		List<Notifiche> listaNotifiche = new ArrayList<Notifiche>();
    	
    	Notifiche temp = new Notifiche();
    	temp.setTitolo("Vengo dal codice prova!");
    	temp.setTesto("Testo prova prova provaaaaaa");
    	temp.setID_Utente_FK(intVenditoreID);
    	listaNotifiche.add(temp);
    	
    	temp = new Notifiche();
    	temp.setTitolo("Che si trova in NotificheRepositoryImpl");
    	temp.setTesto("Testo prova prova provaaaaaa");
    	temp.setID_Utente_FK(intVenditoreID);
    	listaNotifiche.add(temp);
    	
    	
    	return listaNotifiche;
    }

}
