package implementazione;

import entità.Notifiche;
import repository.NotificheRepository;

public class NotificheRepositoryImpl extends JPARepositoryImpl<Notifiche, Integer> implements NotificheRepository {
	
private static NotificheRepository instance = new NotificheRepositoryImpl();

	
    private NotificheRepositoryImpl() {   	
    }

    public static NotificheRepository getInstance() {
        return instance;
    }

}
