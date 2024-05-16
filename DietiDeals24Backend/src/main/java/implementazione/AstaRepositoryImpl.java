package implementazione;

import entità.Asta;
import repository.AstaRepository;

public class AstaRepositoryImpl extends JPARepositoryImpl<Asta, Integer> implements AstaRepository {
	
	private static AstaRepository instance = new AstaRepositoryImpl();

	
    private AstaRepositoryImpl() {   	
    }

    public static AstaRepository getInstance() {
        return instance;
    }

	


}
