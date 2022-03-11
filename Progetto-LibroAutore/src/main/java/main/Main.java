package main;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityTransaction;

import dao.AutoreDao;
import dao.LibroDao;
import dao.ResponseJoinDao;
import dto.JoinLibroAutoreTo;
import entity.Autore;
import entity.Libro;

public class Main {

	public static void main(String[] args) {
		
		try {
		AutoreDao autoreDao=new AutoreDao();
		LibroDao libroDao = new LibroDao();
		ResponseJoinDao responseJoindao = new ResponseJoinDao();
		
		// apro la transazione 
		EntityTransaction  transaction=autoreDao.getEntityManager().getTransaction();
		transaction.begin();
		
		//cerco su database tutti gli autori
		List<Autore> tuttiAutori=autoreDao.findAll();
		System.out.println(tuttiAutori.toString());
		
		// cerco autori per nome
		List<Autore> autoriPerNome = autoreDao.findByNome("Angelo");
		System.out.println(autoriPerNome.toString());
		
		//creo un oggetto Autore e lo salvo su database
		Autore autore = new Autore();
		autore.setNome("Simone");
		autore.setCognome("Cassani");
		autore.setDataNascita(Date.valueOf("1956-12-13"));
		autore.setLuogoNascita("Bari");
		autore.setCodFiscale("V66B88");
		autoreDao.save(autore);
		System.out.println("Inserito autore :" + autore);
		
		// cambio il nome dell'autore
		autoreDao.update(autore, "Alex");;
		
		// cerco tutti i libri
		List<Libro> tuttiLibri = libroDao.findAllLibri();
		System.out.println(tuttiLibri.toString());
		
		
		// cerco libri per autore
		List<Libro> libriPerIdAutore = libroDao.trovaLibriByIdAutore(2);
		System.out.println(libriPerIdAutore.toString());
		
		// cerco libri per genere
		List<Libro> libriPerGenere = libroDao.findLibroByGenere("Thriller");
		System.out.println(libriPerGenere.toString());
		
		// cerco nome, cognome, titolo e genere nelle 2 tabelle
		List<JoinLibroAutoreTo> getResponseJoin = responseJoindao.findByJoin();
		System.out.println(getResponseJoin.toString());
		
		transaction.commit();
		} catch(Exception e) {
			System.out.println("ERRORE! "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("OK, finito");

	}

}
