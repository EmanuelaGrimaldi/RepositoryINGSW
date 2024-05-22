package implementazione;

import repository.PartecipazioneUtenteAstaRepository;
import entità.PartecipazioneUtenteAsta;

public class PartecipazioneUtenteAstaRepositoryImpl  extends JPARepositoryImpl<PartecipazioneUtenteAsta, Integer> implements PartecipazioneUtenteAstaRepository {

	private static PartecipazioneUtenteAstaRepository instance = new PartecipazioneUtenteAstaRepositoryImpl();

	
    private PartecipazioneUtenteAstaRepositoryImpl() {   	
    }

    public static PartecipazioneUtenteAstaRepository getInstance() {
        return instance;
    }
}

	
	