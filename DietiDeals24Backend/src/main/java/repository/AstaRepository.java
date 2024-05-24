package repository;

import java.util.List;

import entità.Asta;

public interface AstaRepository extends JPARepository<Asta, Integer> {
	
	public <T> List<T> findByCategoria(String tipoCategoria);
	public <T> List<T> findByTipologia(String tipologia);
	public <T> List<T> findAsteInScadenza();
	
}
