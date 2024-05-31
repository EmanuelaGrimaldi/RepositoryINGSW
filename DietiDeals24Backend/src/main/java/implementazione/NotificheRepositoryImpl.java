package implementazione;

import java.util.ArrayList;
import java.util.List;
import entità.Notifiche;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.NotificheRepository;

public class NotificheRepositoryImpl extends JPARepositoryImpl<Notifiche, Integer> implements NotificheRepository {
	
private static NotificheRepository instance = new NotificheRepositoryImpl();
	
    private NotificheRepositoryImpl() {   	
    }

    public static NotificheRepository getInstance() {
        return instance;
    }
    
	@SuppressWarnings("unchecked")
	public List<Notifiche> findNotificheByIDutenteFK( int intVenditoreID){
    	
    	EntityManager em = null;
		EntityTransaction et = null;
		List<Notifiche> listaNotifichediUtente = null;
		
		try 
		{
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();			
			q = em.createNativeQuery("select * from " + entityClass.getSimpleName() + 
									" where IDutenteFK = :idUtente", this.entityClass);
			q.setParameter("idUtente", intVenditoreID);
			listaNotifichediUtente = q.getResultList();
			et.commit();
		} 
		catch (Exception e) 
		{
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}
		finally 
		{
			if(em != null)
				em.close();
		}
		
	return listaNotifichediUtente;
    }

}
