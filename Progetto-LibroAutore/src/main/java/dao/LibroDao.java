package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Autore;
import entity.Libro;

public class LibroDao extends GenericDao {
	
	// query in SQL
	
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
	
	public void save(Libro libro) {
		getEntityManager().persist(libro);
	}
	
	// trova libri in base al nome e cognome dell'autore
	public List<Libro> findLibriByNomeCognomeAutore(String nome, String cognome){
		Query query = getEntityManager().createNativeQuery("select libro.* from libro inner join autore on autore.id=libro.autore_id where autore.nome = :nome and autore.cognome = :cognome", Libro.class);
		query.setParameter("nome", nome);
		query.setParameter("cognome", cognome);
		return query.getResultList();
		
	}
	
}
