package repository;

import java.util.List;

import entità.Notifiche;

public interface NotificheRepository extends JPARepository<Notifiche, Integer> {
	
	public List<Notifiche> findNotificheByIDProprietarioNotifica( int intUtenteID);

}
