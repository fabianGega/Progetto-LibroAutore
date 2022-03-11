package dao;

import java.util.List;

import org.hibernate.transform.Transformers;

import dto.JoinLibroAutoreTo;

public class ResponseJoinDao extends GenericDao {
	
	public List<JoinLibroAutoreTo> findByJoin(){
		List<JoinLibroAutoreTo> dtoList = getEntityManager().createNativeQuery("select nome, cognome, titolo, genere from autore inner join libro on autore.id=libro.autore_id")
				.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.aliasToBean(JoinLibroAutoreTo.class)).list();
		
		return dtoList;
	}

}
