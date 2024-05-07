package implementazione;

import repository.UtenteRepository;
import entità.Utente;

public class UtenteRepositoryImpl extends JPARepositoryImpl<Utente, Integer> implements UtenteRepository {

	private static UtenteRepository instance = new UtenteRepositoryImpl();

	
    private UtenteRepositoryImpl() {
    	
    }

    public static UtenteRepository getInstance() {
    	System.out.println("Pre riga problematica");
        return instance;
    }

	
	
	
}
