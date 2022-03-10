package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit1");
	private static EntityManager entityManager = emf.createEntityManager();
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
