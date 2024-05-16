package implementazione;

import entità.Recensione;
import repository.RecensioneRepository;

public class RecensioneRepositoryImpl extends JPARepositoryImpl<Recensione, Integer> implements RecensioneRepository {
	
private static RecensioneRepository instance = new RecensioneRepositoryImpl();

	
    private RecensioneRepositoryImpl() {   	
    }

    public static RecensioneRepository getInstance() {
        return instance;
    }

}
