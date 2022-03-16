package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Autore;
import entity.Libro;


public class AutoreDao extends GenericDao {
	
	// query in HQL
	
	public Autore findById(int id) {
		return getEntityManager().find(Autore.class, id);
	}
	
	public List<Autore> findAll(){
		
		TypedQuery<Autore> query = getEntityManager().createNamedQuery("trovaTutti", Autore.class);
		
		return query.getResultList();
	}
	
	public List<Autore> findByName(String nome){

		Query query = getEntityManager().createQuery("select a from Autore a where a.nome = :nome", Autore.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();
	}
	
	public void save(Autore autore) {
		getEntityManager().persist(autore);
	}
	
	public List<Autore> findAutoriByNomeCognome(String nome, String cognome){
		Query query = getEntityManager().createNativeQuery("select * from Autore where nome = :nome and cognome = :cognome", Autore.class);
		query.setParameter("nome", nome);
		query.setParameter("cognome", cognome);
		
		return query.getResultList();
		
	}

}
