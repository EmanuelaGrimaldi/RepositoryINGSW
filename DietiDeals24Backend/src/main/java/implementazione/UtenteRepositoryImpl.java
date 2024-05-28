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
					"select * from " + entityClass.getSimpleName() + " where EmailUtente='" + email + "'",
					this.entityClass);

			if (q != null)
				utente = (Utente) q.getSingleResult();

			else {
				Utente u = new Utente();
				u.setNome("null");
				u.setCognome("null");
				u.setID_Utente(-1);
				u.setEmailUtente("null");
			}
			et.commit();
		} 
		catch (NumberFormatException e) 
		{
			System.err.println(
					"\nFacendo la query ho trovato null e ho ritornato un oggetto utente.nome=*;\n" + e.getMessage());
			Utente u = new Utente();
			u.setNome("*");

			return u;
		} 
		catch (Exception e) 
		{
			System.err.println("\nErrorino altro :" + e.getMessage());

			if (et != null && et.isActive())
				et.rollback();

			Utente u = new Utente();
			u.setNome("null");
			u.setCognome("null");
			u.setID_Utente(-1);
			u.setEmailUtente("null");
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
