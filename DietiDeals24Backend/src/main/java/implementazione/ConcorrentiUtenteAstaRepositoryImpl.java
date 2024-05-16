package implementazione;

import repository.ConcorrentiUtenteAstaRepository;
import entità.ConcorrentiUtenteAsta;

public class ConcorrentiUtenteAstaRepositoryImpl  extends JPARepositoryImpl<ConcorrentiUtenteAsta, Integer> implements ConcorrentiUtenteAstaRepository {

	private static ConcorrentiUtenteAstaRepository instance = new ConcorrentiUtenteAstaRepositoryImpl();

	
    private ConcorrentiUtenteAstaRepositoryImpl() {   	
    }

    public static ConcorrentiUtenteAstaRepository getInstance() {
        return instance;
    }
}

	
	