package app;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PrestitoDAO;
import dao.ReadablexDAO;
import dao.UtenteDAO;
import entities.Libro;
import entities.Prestito;
import entities.Readablex;
import entities.Rivista;
import entities.Utente;

public class ArchivioV2 {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3ProgettoSettimanale");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		try {
			UtenteDAO utenteDAO = new UtenteDAO(em);
			PrestitoDAO prestitoDAO = new PrestitoDAO(em);
			ReadablexDAO readablexDAO = new ReadablexDAO(em);

			/*Libro libro1 = new Libro("Harry Potter 1", 2023, 300, "JKR", "Fantasy");
			readablexDAO.aggiungiElementoCatalogo(libro1);
			Libro libro2 = new Libro("Harry Potter 2", 2023, 300, "JKR", "Fantasy");
			readablexDAO.aggiungiElementoCatalogo(libro2);

			Rivista rivista1 = new Rivista("Harry Potter R1", 2023, 50, Rivista.Periodicita.MENSILE);
			readablexDAO.aggiungiElementoCatalogo(rivista1);
			Rivista rivista2 = new Rivista("Harry Potter R2", 2023, 50, Rivista.Periodicita.MENSILE);
			readablexDAO.aggiungiElementoCatalogo(rivista2);

			Utente utente = new Utente("Davide", "Spinozzi", LocalDate.of(2001, 2, 5));
			utenteDAO.aggiungiUtente(utente);

			Readablex elementoPrestato1 = libro1;
			LocalDate dataInizioPrestito1 = LocalDate.of(2010, 2, 5);
			LocalDate dataRestituzioneEffettiva1 = null;

			Prestito prestito = new Prestito(utente, elementoPrestato1, dataInizioPrestito1,
					dataRestituzioneEffettiva1);
			prestitoDAO.aggiungiPrestito(prestito);*/

			int scelta = 0;
			Scanner scanner = new Scanner(System.in);

			while (scelta != 10) {
				System.out.println("\nScegli un'azione da eseguire:");
				System.out.println("1. Visualizza prestiti dell'utente");
				System.out.println("2. Visualizza prestiti scaduti e non restituiti");
				System.out.println("3. Ricerca per anno di pubblicazione");
				System.out.println("4. Ricerca per autore");
				System.out.println("5. Ricerca per titolo");
				System.out.println("6. Aggiungi elemento al catalogo");
				System.out.println("7. Rimuovi elemento dal catalogo");
				System.out.println("8. Aggiungi utente");
				System.out.println("9. Aggiungi prestito");
				System.out.println("10. Esci");

				scelta = scanner.nextInt();
				scanner.nextLine();

				switch (scelta) {
				case 1:
					System.out.print("Inserisci un numero di tessera: ");
					String tesseraInput = scanner.nextLine();

					Long numeroTessera = Long.parseLong(tesseraInput);

					List<Prestito> prestitiUtente = utenteDAO.ricercaPrestitiUtente(numeroTessera);
					Utente user = utenteDAO.ricercaUtenteDaNumeroTessera(numeroTessera);
					if (user != null) {
						if (prestitiUtente.size() > 0) {
							System.out.println("Prestiti dell'utente:");
							for (Prestito prestitoUtente : prestitiUtente) {
								System.out.println(prestitoUtente);
							}
						} else {
							System.out.println("L'Utente non ha prestiti.");
						}
					} else {
						System.out.println("Utente non trovato.");
					}
					break;
				case 2:
					List<Prestito> prestitiScadutiNonRestituiti = prestitoDAO.ricercaPrestitiScadutiNonRestituiti();
					System.out.println("Prestiti scaduti e non restituiti:");
					for (Prestito prestitoScadutoNonRestituito : prestitiScadutiNonRestituiti) {
						System.out.println(prestitoScadutoNonRestituito);
					}
					break;
				case 3:
					System.out.print("Inserisci l'anno di pubblicazione da cercare: ");
					int annoPubblicazione = scanner.nextInt();
					List<Readablex> risultatoRicercaAnno = readablexDAO.ricercaPerAnnoPubblicazione(annoPubblicazione);
					System.out.println("Risultato ricerca per anno di pubblicazione (" + annoPubblicazione + "):");
					for (Readablex readablex : risultatoRicercaAnno) {
						System.out.println(readablex);
					}
					break;
				case 4:
					System.out.print("Inserisci il nome dell'autore da cercare: ");
					String autore = scanner.nextLine();
					List<Readablex> risultatoRicercaAutore = readablexDAO.ricercaPerAutore(autore);
					System.out.println("Risultato ricerca per autore (" + autore + "):");
					for (Readablex readablex : risultatoRicercaAutore) {
						System.out.println(readablex);
					}
					break;
				case 5:
					System.out.print("Inserisci il titolo da cercare: ");
					String titolo = scanner.nextLine();
					List<Readablex> risultatoRicercaTitolo = readablexDAO.ricercaPerTitolo(titolo);
					System.out.println("Risultato ricerca per titolo (" + titolo + "):");
					for (Readablex readablex : risultatoRicercaTitolo) {
						System.out.println(readablex);
					}
					break;
				case 6:
					System.out.print("Inserisci il tipo di elemento (1. Libro, 2. Rivista): ");
					int tipoElemento = scanner.nextInt();
					scanner.nextLine();

					switch (tipoElemento) {
					case 1:
						System.out.print("Inserisci il titolo del libro: ");
						String titoloLibro = scanner.nextLine();
						System.out.print("Inserisci l'anno di pubblicazione del libro: ");
						int annoPubblicazioneLibro = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Inserisci il numero di pagine del libro: ");
						int numeroPagineLibro = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Inserisci l'autore del libro: ");
						String autoreLibro = scanner.nextLine();
						System.out.print("Inserisci il genere del libro: ");
						String genereLibro = scanner.nextLine();

						Libro nuovoLibro = new Libro(titoloLibro, annoPubblicazioneLibro, numeroPagineLibro,
								autoreLibro, genereLibro);
						readablexDAO.aggiungiElementoCatalogo(nuovoLibro);
						System.out.println("Libro aggiunto al catalogo.");
						break;
					case 2:
						System.out.print("Inserisci il titolo della rivista: ");
						String titoloRivista = scanner.nextLine();
						System.out.print("Inserisci l'anno di pubblicazione della rivista: ");
						int annoPubblicazioneRivista = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Inserisci il numero di pagine della rivista: ");
						int numeroPagineRivista = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Inserisci la periodicità della rivista (SETTIMANALE, MENSILE, SEMESTRALE): ");
						String periodicitaRivista = scanner.nextLine();

						Rivista.Periodicita periodicita;
						switch (periodicitaRivista.toUpperCase()) {
						case "SETTIMANALE":
							periodicita = Rivista.Periodicita.SETTIMANALE;
							break;
						case "MENSILE":
							periodicita = Rivista.Periodicita.MENSILE;
							break;
						case "SEMESTRALE":
							periodicita = Rivista.Periodicita.SEMESTRALE;
							break;
						default:
							System.out.println("Periodicità non valida. La rivista verrà aggiunta senza periodicità.");
							periodicita = null;
							break;
						}

						Rivista nuovaRivista = new Rivista(titoloRivista, annoPubblicazioneRivista, numeroPagineRivista,
								periodicita);
						readablexDAO.aggiungiElementoCatalogo(nuovaRivista);
						System.out.println("Rivista aggiunta al catalogo.");
						break;
					default:
						System.out.println("Tipo di elemento non valido. Riprova.");
						break;
					}
					break;
				case 7:
					System.out.print("Inserisci l'ISBN dell'elemento da rimuovere: ");
					Long isbn = scanner.nextLong();
					scanner.nextLine();
					Readablex elementoDaRimuovere = readablexDAO.ricercaPerISBN(isbn);
					if (elementoDaRimuovere != null) {
						readablexDAO.rimuoviElementoCatalogo(elementoDaRimuovere.getIsbn());
						System.out.println("Elemento rimosso dal catalogo.");
					} else {
						System.out.println("Nessun elemento trovato con l'ISBN fornito.");
					}
					break;
				case 8:
					System.out.print("Inserisci il nome dell'utente: ");
					String nomeUtente = scanner.nextLine();
					System.out.print("Inserisci il cognome dell'utente: ");
					String cognomeUtente = scanner.nextLine();
					System.out.print("Inserisci la data di nascita dell'utente (formato: anno-mese-giorno): ");
					String dataNascitaUtente = scanner.nextLine();

					LocalDate dataNascita;
					dataNascita = LocalDate.parse(dataNascitaUtente);

					Utente nuovoUtente = new Utente(nomeUtente, cognomeUtente, dataNascita);
					utenteDAO.aggiungiUtente(nuovoUtente);
					System.out.println("Utente aggiunto con successo.");
					break;

				case 9:
					System.out.print("Inserisci l'ISBN dell'elemento da prestare: ");
					Long isbnPrestato = scanner.nextLong();
					scanner.nextLine();

					Readablex elementoPrestato = readablexDAO.ricercaPerISBN(isbnPrestato);
					if (elementoPrestato != null) {
						System.out.print("Inserisci il numero di tessera dell'utente: ");
						Long numeroTesseraUtente = scanner.nextLong();
						scanner.nextLine();

						Utente utentePrestito = utenteDAO.ricercaUtenteDaNumeroTessera(numeroTesseraUtente);
						if (utentePrestito != null) {
							LocalDate dataInizioPrestito = LocalDate.now();
							LocalDate dataRestituzioneEffettiva = null;

							Prestito nuovoPrestito = new Prestito(utentePrestito, elementoPrestato, dataInizioPrestito,
									dataRestituzioneEffettiva);
							prestitoDAO.aggiungiPrestito(nuovoPrestito);
							System.out.println("Prestito aggiunto con successo.");
						} else {
							System.out.println("Utente non trovato.");
						}
					} else {
						System.out.println("Nessun elemento trovato con l'ISBN fornito.");
					}
					break;
				case 10:
					System.out.println("Programma terminato.");
					break;
				default:
					System.out.println("Scelta non valida. Riprova.");
					break;
				}
			}

			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}