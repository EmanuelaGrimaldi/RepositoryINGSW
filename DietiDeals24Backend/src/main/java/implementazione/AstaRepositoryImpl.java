package implementazione;

import java.util.List;

import entità.Asta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.AstaRepository;

public class AstaRepositoryImpl extends JPARepositoryImpl<Asta, Integer> implements AstaRepository {
	
	private static AstaRepository instance = new AstaRepositoryImpl();

	
    private AstaRepositoryImpl() {   	
    }

    public static AstaRepository getInstance() {
        return instance;
    }

    
    @SuppressWarnings("unchecked")
	public <T> List<T> findByCategoria(String categoria){
    	
		EntityManager em = null;
		EntityTransaction et = null;
		List<T> listaByCategoria = null;
		
		try 
		{
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();			
			q = em.createNativeQuery("select * from " + entityClass.getSimpleName() + 
									" where categoria='" + categoria +"'", this.entityClass);
			listaByCategoria = q.getResultList();
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
		
	return listaByCategoria;
	}
    

    @SuppressWarnings("unchecked")
	public <T> List<T> findAsteInScadenza()
	{
		EntityManager em = null;
		EntityTransaction et = null;
		List<T> listaByTiplistaAsteInScadenzaologia = null;
		
		try 
		{
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();			
			q = em.createNativeQuery("select * from " + entityClass.getSimpleName() + 
									" where date(dataFine) = CURDATE();", this.entityClass);
			listaByTiplistaAsteInScadenzaologia = q.getResultList();
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
		
	return listaByTiplistaAsteInScadenzaologia;
	}
    
    
    public <T> List<T> findAssteInScadenza()
    {

		EntityManager em = null;
		EntityTransaction et = null;
		List<T> lista = null;
		
		try 
		{
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();			
			q = em.createNativeQuery("select * from " + entityClass.getSimpleName() + " where ", this.entityClass);
			lista = q.getResultList();
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
		
	return lista;
    }

	// forse mai usato
    ///////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
	private <T> List<T> findByTipoAsta(String tipoAsta){
    	
		EntityManager em = null;
		EntityTransaction et = null;
		List<T> lista = null;
		
		try 
		{
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();			
			q = em.createNativeQuery("select * from " + entityClass.getSimpleName() + " where ", this.entityClass);
			lista = q.getResultList();
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
		
	return lista;
	}


}
