package implementazione;

import repository.UtenteRepository;
import entità.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteRepositoryImpl extends JPARepositoryImpl<Utente, Integer> implements UtenteRepository {

	private static UtenteRepository instance = new UtenteRepositoryImpl();

	private UtenteRepositoryImpl() {
	}

	public static UtenteRepository getInstance() {
		return instance;
	}

	@Override
	public boolean emailAlreadyExist(String email) {

		return (this.findByEmail(email) == null || 
				this.findByEmail(email).getID_Utente() == -1 ) ? false : true;
	}

	@Override
	public Utente findByEmail(String email) {

		EntityManager em = null;
		EntityTransaction et = null;
		Utente utente = null;

		try {
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();
			q = em.createNativeQuery(
					"select * from " + entityClass.getSimpleName() + " where EmailUtente= :email ",
					this.entityClass);
			
			q.setParameter("email", email);
			
			et.commit();
			
			if (q != null)
				utente = (Utente) q.getSingleResult(); //q.getParameter("EmailUtente");

		} 
		catch (NumberFormatException e) 
		{
			System.err.println(
					"\nFacendo la query ho trovato null e ho ritornato null;\n" + e.getMessage());
			Utente u = null;
			return u;
		} 
		catch (Exception e) 
		{
			System.err.println("\nErrorino altro :" + e.getMessage());

			if (et != null && et.isActive())
				et.rollback();

			Utente u = null;
			return u;

		}
		finally 
		{
			if (em != null)
				em.close();
		}

		return utente;
	}

}
