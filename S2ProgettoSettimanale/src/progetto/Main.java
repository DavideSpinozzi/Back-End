package progetto;

import java.util.List;

import progetto.classi.Archivio;
import progetto.classi.Libro;
import progetto.classi.Rivista;
import progetto.classi.Readablex;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Archivio archivio = new Archivio();
		Scanner scanner = new Scanner(System.in);

		Libro libro1 = new Libro("ISBN1", "Titolo libro 1", 2021, 200, "Autore 1", "Genere 1");
		Libro libro2 = new Libro("ISBN2", "Titolo libro 2", 2022, 250, "Autore 2", "Genere 2");
		Rivista rivista1 = new Rivista("ISBN3", "Titolo rivista 1", 2023, 100, Rivista.Periodicita.SETTIMANALE);
		Rivista rivista2 = new Rivista("ISBN4", "Titolo rivista 2", 2023, 50, Rivista.Periodicita.MENSILE);

		archivio.aggiungiElemento(libro1);
		archivio.aggiungiElemento(libro2);
		archivio.aggiungiElemento(rivista1);
		archivio.aggiungiElemento(rivista2);

		int scelta = 0;
		while (scelta != 7) {
			System.out.println("\nScegli un'azione da eseguire:");
			System.out.println("1. Ricerca per ISBN");
			System.out.println("2. Ricerca per anno di pubblicazione");
			System.out.println("3. Ricerca per autore");
			System.out.println("4. Aggiungi un elemento");
			System.out.println("5. Rimuovi un elemento");
			System.out.println("6. Salva archivio su disco");
			System.out.println("7. Esci");

			scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1:
				System.out.print("Inserisci l'ISBN da cercare: ");
				String isbn = scanner.nextLine();
				Readablex risultatoRicercaIsbn = archivio.ricercaPerIsbn(isbn);
				if (risultatoRicercaIsbn != null) {
					System.out.println("Elemento trovato per ISBN: " + risultatoRicercaIsbn.getTitolo());
				} else {
					System.out.println("Nessun elemento trovato per l'ISBN specificato.");
				}
				break;
			case 2:
				System.out.print("Inserisci l'anno di pubblicazione da cercare: ");
				int anno = scanner.nextInt();
				List<Readablex> risultatoRicercaAnno = archivio.ricercaPerAnnoPubblicazione(anno);
				System.out.println("Risultato ricerca per anno di pubblicazione:");
				for (Readablex elemento : risultatoRicercaAnno) {
					System.out.println("- " + elemento.getTitolo());
				}
				break;
			case 3:
				System.out.print("Inserisci il nome dell'autore da cercare: ");
				String autore = scanner.nextLine();
				List<Readablex> risultatoRicercaAutore = archivio.ricercaPerAutore(autore);
				System.out.println("Risultato ricerca per autore:");
				for (Readablex elemento : risultatoRicercaAutore) {
					System.out.println("- " + elemento.getTitolo());
				}
				break;
			case 4:
				System.out.println("Inserisci i dettagli del nuovo elemento:");
				System.out.print("ISBN: ");
				String nuovoIsbn = scanner.nextLine();
				System.out.print("Titolo: ");
				String nuovoTitolo = scanner.nextLine();
				System.out.print("Anno di pubblicazione: ");
				int nuovoAnno = scanner.nextInt();
				System.out.print("Numero di pagine: ");
				int nuovoNumeroPagine = scanner.nextInt();
				scanner.nextLine();

				System.out.print("È un libro o una rivista? (L/R): ");
				String tipoElemento = scanner.nextLine().toUpperCase();

				if (tipoElemento.equals("L")) {
					System.out.print("Autore: ");
					String nuovoAutore = scanner.nextLine();
					System.out.print("Genere: ");
					String nuovoGenere = scanner.nextLine();

					Libro nuovoLibro = new Libro(nuovoIsbn, nuovoTitolo, nuovoAnno, nuovoNumeroPagine, nuovoAutore,
							nuovoGenere);
					archivio.aggiungiElemento(nuovoLibro);
					System.out.println("Libro aggiunto all'archivio.");
				} else if (tipoElemento.equals("R")) {
					System.out.print("Periodicità (SETTIMANALE/MENSILE/SEMESTRALE): ");
					String periodicità = scanner.nextLine().toUpperCase();
					Rivista.Periodicita periodicitaEnum = Rivista.Periodicita.valueOf(periodicità);

					Rivista nuovaRivista = new Rivista(nuovoIsbn, nuovoTitolo, nuovoAnno, nuovoNumeroPagine,
							periodicitaEnum);
					archivio.aggiungiElemento(nuovaRivista);
					System.out.println("Rivista aggiunta all'archivio.");
				} else {
					System.out.println("Tipo di elemento non valido.");
				}
				break;
			case 5:
				System.out.print("Inserisci l'ISBN dell'elemento da rimuovere: ");
				String isbnDaRimuovere = scanner.nextLine();
				archivio.rimuoviElemento(isbnDaRimuovere);
				System.out.println("Elemento rimosso dall'archivio.");
				break;
			case 6:
				System.out.print("Inserisci il percorso del file di salvataggio: ");
				String percorsoSalvataggio = scanner.nextLine();
				archivio.salvaSuDisco(percorsoSalvataggio);
				System.out.println("Archivio salvato su disco.");
				break;
			case 7:
				System.out.println("Programma terminato.");
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
				break;
			}
		}

		scanner.close();
	}
}