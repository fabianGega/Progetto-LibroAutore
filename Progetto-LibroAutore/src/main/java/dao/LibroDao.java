package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Autore;
import entity.Libro;

public class LibroDao extends GenericDao {
	
	public List<Libro> findAllLibri() {
		Query query = getEntityManager().createNativeQuery("select * from Libro", Libro.class);
		
		return query.getResultList();
	}
	
	public List<Libro> trovaLibriByIdAutore(int autoreId){
		Query query = getEntityManager().createNativeQuery("select * from Libro where autore_id = :autoreId order by prezzo ", Libro.class);
		query.setParameter("autoreId", autoreId);
		return query.getResultList();
	}
	
	public List<Libro> findLibroByGenere(String genere){
		Query query = getEntityManager().createNativeQuery("select * from Libro where genere = :genere", Libro.class);
		query.setParameter("genere", genere);
		return query.getResultList();
	}
	
}
