package dao;

import java.util.List;

import javax.persistence.Query;

import entity.Autore;


public class AutoreDao extends GenericDao {
	
	public Autore findById(int id) {
		return getEntityManager().find(Autore.class, id);
	}
	
	public List<Autore> findAll(){
		Query query = getEntityManager().createNativeQuery("select * from Autore", Autore.class);
		
		return query.getResultList();
	}
	
	public List<Autore> findByNome(String nome){
		Query query = getEntityManager().createNativeQuery("select * from Autore where nome = :nome", Autore.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();
	}
	
	public void save(Autore autore) {
		getEntityManager().persist(autore);
	}
	
	public void update(Autore autore, String nomeNuovo) {
		autore.setNome(nomeNuovo);
		getEntityManager().merge(autore);
	}

}
