package implementazione;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import repository.JPARepository;
import repository.persistenceUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class JPARepositoryImpl<T, ID> implements JPARepository<T, ID> {
	
	protected EntityManagerFactory emf = persistenceUtil.getEntityManagerFactory();    
	protected Class<T> entityClass;
	
	
	@SuppressWarnings("unchecked")
	public JPARepositoryImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T entity) {
		
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(entity);		
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
						
	}
	
	@Override
	public void delete(T entity) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.remove(em.merge(entity));		
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
		
	}
	
	@Override
	public void update(T entity) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.merge(entity);		
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
		
	}
	
	@Override
	public void deletebyID(ID primaryKey) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();		
			em.remove(em.find(entityClass, primaryKey));		
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
		
	}
	
	@Override
	public T findbyID(ID primaryKey) {
		
		T entity = null;
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();		
			entity = em.find(entityClass, primaryKey);		
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
		return entity;
		
	}
	
	@Override
	public List<T> findAll(){
	
		EntityManager em = null;
		EntityTransaction et = null;
		List<T> lista = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();		
			lista = em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();	
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
	return lista;
	}
	
	@Override
	public Long count() {
		
		EntityManager em = null;
		EntityTransaction et = null;
		Long count  = null;
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();		
			count = em.createQuery("SELECT COUNT * FROM " + entityClass.getSimpleName(), Long.class).getSingleResult();	
			et.commit();
		} catch (Exception e) {
			System.err.println("Errorino uwu :" + e.getMessage());
			
			if (et != null && et.isActive()) 
				et.rollback();				
			
		}finally {
			if(em != null)
				em.close();
		}
	return count;
		
	}
	
}
