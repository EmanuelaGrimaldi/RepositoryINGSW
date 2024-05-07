package repository;

import java.util.List;

public interface JPARepository<T, ID> {
	
	//Comandi base universali per tutte le repository
	//T=Classe generica
	//ID=tipo di Primary key
	
	void save(T entity);
	void delete(T entity);
	void update(T entity);
	void deletebyID(ID primaryKey);
	T findbyID(ID primaryKey);
	List<T> findAll();
	Long count();
}
