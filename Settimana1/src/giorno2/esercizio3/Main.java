package giorno2.esercizio3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Benvenuto");
		System.out.println();
		System.out.println("Inserisci Nome e Cognome");
		String nomeCognome = scanner.nextLine();
		System.out.println("Inserisci l'Email");
		String emailCliente = scanner.nextLine();

		Cliente cliente = new Cliente(Math.random() * 1000, nomeCognome, emailCliente, LocalDate.now().toString());
		Carrello carrello = new Carrello(cliente);
		Articolo[] articoli = { new Articolo("10", "capperi", 10, 98), new Articolo("15", "paperino", 17, 98),
				new Articolo("99", "topolino", 10, 8), new Articolo("08", "minnie", 11, 198),
				new Articolo("100", "cocaina", 60.9, 568), new Articolo("023", "daniele", 10.11, 3458),
				new Articolo("1", "pluto", 100.18, 91) };

		int counter = 0;
		while (counter != 5) {
			System.out.println("----------------------------------");
			System.out.println("1 : Visualizza info cliente");
			System.out.println("2 : Visualizza carrello");
			System.out.println("3 : Visualizza articoli");
			System.out.println("4 : Aggiungi articoli al carrello");
			System.out.println("5 : Cassa");
			System.out.println("----------------------------------");
			counter = scanner.nextInt();
			switch (counter) {

			case 1:
				stampaCliente(cliente);
				break;
			case 2:
				stampaCarrello(carrello);
				break;
			case 3:
				for (Articolo articolo : articoli) {
					stampaArticoli(articolo);
				}
				break;
			case 4:
				for (Articolo articolo : articoli) {
					stampaArticoli(articolo);
				}
				System.out.println();
				System.out.println("Inserisci il codice dell' articolo da aggiungere al carrello");
				String codiceArticolo = scanner.next();
				boolean ok = true;
				for (Articolo articolo : articoli) {
					if (codiceArticolo.equals(articolo.getCodiceArticolo())) {
						carrello.aggiungiArticolo(articolo);
						System.out.println("Articolo aggiunto al carrello");
						ok = false;
						break;
					}
				}
				if (ok) {
					System.out.println("Articolo non trovato");
				}

				break;
			case 5:
				stampaCarrello(carrello);
				System.out.println("Grazie per l' acquisto");
				break;
			}
		}

	}

	public static void stampaArticoli(Articolo articolo) {

		System.out.println("Codice articolo: " + articolo.getCodiceArticolo() + " Descrizione articolo: "
				+ articolo.getDescrizioneArticolo() + " Prezzo: " + articolo.getPrezzo() + " Numero pezzi disponibili: "
				+ articolo.getPezziDisponibili());

	}

	public static void stampaCliente(Cliente cliente) {

		System.out.println(
				"Codice cliente: " + cliente.getCodiceCliente() + " Nome e Cognome: " + cliente.getNomeCognome()
						+ " Email: " + cliente.getEmail() + "Data iscrizione: " + cliente.getDataIscrizione());

	}

	public static void stampaCarrello(Carrello carrello) {

		System.out.println("Cliente associato: " + carrello.getClienteAssociato().getNomeCognome() + " Articoli nel carrello: "
				+ Arrays.toString(carrello.getElencoArticoli()) + " Totale costo articoli: "
				+ carrello.getCostoTotale());

	}

}
