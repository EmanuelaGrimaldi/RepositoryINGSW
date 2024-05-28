package repository;

import entità.Utente;

public interface UtenteRepository extends JPARepository<Utente, Integer> {

	boolean emailAlreadyExist(String emailUtente);

	Utente findByEmail(String email);
	
	

}
