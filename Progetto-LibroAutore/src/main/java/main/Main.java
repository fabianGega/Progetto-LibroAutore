package main;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;

import dao.AutoreDao;
import dao.LibroDao;
import dao.ResponseJoinDao;
import dto.JoinLibroAutoreTo;
import entity.Autore;
import entity.Libro;
import utility.Utility;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int op = -1;
		boolean continua = true;
		
		do {
			do {	
				System.out.println("Scegli: " + "\n" + "1. Per trovare tutti gli autori" + "\n" +"2. Per trovare gli autori per nome" + "\n" 
					+"3. Per trovare i libri per genere" + "\n" + "4. Per trovare tutti i libri" + "\n" 
					+ "5. Per trovare i libri per Id autore" + "\n" + "6. Per trovare tutti i libri in base al genere nome e cognome autore"
					+ "\n" + "7. Per aggiungere un nuovo autore" + "\n" + "8. Per aggiungere un libro"+ "\n" 
					+"9. Per trovare i libri in base al nome e cognome di un autore " + "\n" + "10. Per terminare le operazioni");
				
				try {
				op = input.nextInt();
				
				} catch (InputMismatchException e) {
				System.out.println("Scelta non valida, inserisci un numero tra 1 e 9");
				input.next();
				}
			} while (!(op>=1 && op<=10));
			
			try {
				AutoreDao autoreDao=new AutoreDao();
				LibroDao libroDao = new LibroDao();
				Utility utility = new Utility();
				ResponseJoinDao responseJoinDao = new ResponseJoinDao();
				
				// apro la transazione 
				EntityTransaction  transaction=autoreDao.getEntityManager().getTransaction();
				transaction.begin();
				
				switch (op) {
					case 1:
						List<Autore> tuttiAutori=autoreDao.findAll();
						System.out.println(tuttiAutori.toString());
						break;
					case 2:
						// cerco autori per nome
						System.out.println("Inserisci un nome: ");
						input.nextLine();
						String nome = input.nextLine();
						List<Autore> autoriPerNome = autoreDao.findByName(nome);
						System.out.println(autoriPerNome.toString());
						break;
					case 3:
						System.out.println("Inserisci un genere: ");
						input.nextLine();
						String genere = input.nextLine();
						List<Libro> libriPerGenere = libroDao.findLibroByGenere(genere);
						System.out.println(libriPerGenere.toString());
						break;
					case 4:
						// cerco tutti i libri
						List<Libro> tuttiLibri = libroDao.findAllLibri();
						System.out.println(tuttiLibri.toString());
						break;
					case 5:		
						// cerco libri per autore_id ordinati per prezzo
						System.out.println("Inserisci id dell'autore per trovare i suoi libri: ");
						int autore_id = input.nextInt();
						List<Libro> libriPerIdAutore = libroDao.trovaLibriByIdAutore(autore_id);
						System.out.println(libriPerIdAutore.toString());
						break;
					case 6:
						// cerco nome, cognome, titolo e genere nelle 2 tabelle
						List<JoinLibroAutoreTo> getResponseJoin = responseJoinDao.findByJoin();
						System.out.println(getResponseJoin.toString());
						break;
					case 7:
						//creo un oggetto Autore e lo salvo su database
						Autore autore = new Autore();
						
						utility.aggiungiAutore(autore);

						break;
					case 8:
						// aggiungere un libro di un determinato autore
						
						Libro libro = new Libro();
						
						System.out.println("Inserisci id di un determinato autore:");
						int idAutore = input.nextInt();
						Autore autoreLibro = autoreDao.findById(idAutore);
						
						if (autoreLibro != null) {
							libro.setAutore(autoreLibro);
						} else {
							Autore autoreNuovo = new Autore();
							
							utility.aggiungiAutore(autoreNuovo);
							
							libro.setAutore(autoreNuovo);
						}
				
						System.out.println("Inserisci il titolo del nuovo libro:");
						String titolo = input.nextLine();
						libro.setTitolo(titolo);
						
						System.out.println("Inserisci il codice ISBN del nuovo libro:");
						String codiceIsbn = input.nextLine();
						libro.setCodiceIsbn(codiceIsbn);
						
						System.out.println("Inserisci il genere del nuovo libro:");
						String genereLibro = input.nextLine();
						libro.setGenere(genereLibro);
						
						System.out.println("Inserisci il prezzo del nuovo libro:");
						double prezzo = input.nextDouble();
						libro.setPrezzo(prezzo);
						
						System.out.println("Libro dell'autore inserito: " + libro.toString());
						break;
					case 9:
						// trova i libri prendendo in input nome e cognome dell'autore
						System.out.println("Inserisci il nome dell'autore:");
						input.nextLine();
						String nomeString = input.nextLine();
						System.out.println("Inserisci il cognome dell'autore:");
						String cognomeString = input.nextLine();
						
						List<Libro> libriList = libroDao.findLibriByNomeCognomeAutore(nomeString, cognomeString);
						System.out.println(libriList.toString());
						break;
					case 10: 
						continua = false;
						break;
					default:
						System.out.println("Scelta non valida, scegli un numero da 1 a 9");
			}
				
			transaction.commit();
			
			} catch(Exception e) {
				System.out.println("ERRORE! "+e.getMessage());
				e.printStackTrace();
			}
			
			System.out.println("OK, completato l'operazione");
		} while (continua);
		
		input.close();
	}
	
}
