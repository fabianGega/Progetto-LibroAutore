package main;

import java.util.List;

import javax.persistence.EntityTransaction;

import dao.AutoreDao;
import entity.Autore;

public class Main {

	public static void main(String[] args) {
		
		try {
		AutoreDao autoreDao=new AutoreDao();
		
		///
		
		/* APRIAMO LA TRANSAZIONE */ 
		EntityTransaction  transaction=autoreDao.getEntityManager().getTransaction();
		transaction.begin();
		
		//cerco su database tutti gli autori
		List<Autore> tuttiAutori=autoreDao.findAll();
		System.out.println("Ho cercato tutti gli autori, trovato: " +tuttiAutori.toString());
		
		
		transaction.commit();
		} catch(Exception e) {
			System.out.println("ERRORE! "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("OK, finito");

	}

}
