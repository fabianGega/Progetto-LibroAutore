package service;

import java.sql.Date;
import java.util.Scanner;

import dao.AutoreDao;
import entity.Autore;

public class Service {
	
	public void aggiungiAutore(Autore autore) {
		Scanner input = new Scanner(System.in);
		AutoreDao autoreDao = new AutoreDao();
		Autore autoreNew = new Autore();
		
		System.out.println("Inserisci il nome dell'autore: ");
		String nomeautoreNew = input.nextLine();
		autoreNew.setNome(nomeautoreNew);
		
		System.out.println("Inserisci il cognome dell'autore: ");
		String cognomeautoreNew = input.nextLine();
		autoreNew.setCognome(cognomeautoreNew);
		
		System.out.println("Inserisci la data di nascita dell'autoreNew yyyy-MM-dd: ");
		
		do {
			String dateString = input.nextLine();
			try {
				Date date = Date.valueOf(dateString);
				autoreNew.setDataNascita(date);
			} catch (Exception e) {
				System.out.println("Formato data non correto, inserisci di nuovo yyyy-MM-dd");
			}
		} while (autoreNew.getDataNascita() == null);
		
		System.out.println("Inserisci il luogo di nascità dell'autore:");
		String luogoNascita = input.nextLine();
		autoreNew.setLuogoNascita(luogoNascita);
		
		System.out.println("Inserisci il codice fiscale dell'autore:");
		String codiceFiscale = input.nextLine();
		autoreNew.setCodFiscale(codiceFiscale);
		
		autoreDao.save(autoreNew);
		System.out.println("Inserito autore: " + autoreNew);
		
	}

}
