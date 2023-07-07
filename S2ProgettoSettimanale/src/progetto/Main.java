package progetto;

import java.util.List;

import progetto.classi.Archivio;
import progetto.classi.Libro;
import progetto.classi.Rivista;
import progetto.classi.Readablex;

public class Main {

    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        Libro libro1 = new Libro("ISBN1", "Titolo libro 1", 2021, 200, "Autore 1", "Genere 1");
        Libro libro2 = new Libro("ISBN2", "Titolo libro 2", 2022, 250, "Autore 2", "Genere 2");
        Rivista rivista1 = new Rivista("ISBN3", "Titolo rivista 1", 2023, 100, Rivista.Periodicita.SETTIMANALE);
        Rivista rivista2 = new Rivista("ISBN4", "Titolo rivista 2", 2023, 50, Rivista.Periodicita.MENSILE);

        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);

        Readablex risultatoRicercaIsbn = archivio.ricercaPerIsbn("ISBN2");
        if (risultatoRicercaIsbn != null) {
            System.out.println("Elemento trovato per ISBN: " + risultatoRicercaIsbn.getTitolo());
        } else {
            System.out.println("Nessun elemento trovato per ISBN.");
        }

        List<Readablex> risultatoRicercaAnno = archivio.ricercaPerAnnoPubblicazione(2023);
        System.out.println("Risultato ricerca per anno di pubblicazione:");
        for (Readablex elemento : risultatoRicercaAnno) {
            System.out.println("- " + elemento.getTitolo());
        }

        List<Readablex> risultatoRicercaAutore = archivio.ricercaPerAutore("Autore 2");
        System.out.println("Risultato ricerca per autore:");
        for (Readablex elemento : risultatoRicercaAutore) {
            System.out.println("- " + elemento.getTitolo());
        }

        archivio.rimuoviElemento("ISBN1");

        archivio.salvaSuDisco("archivio.txt");
        System.out.println("Archivio salvato su disco.");

        Archivio archivioCaricato = new Archivio();
        archivioCaricato.caricaDaDisco("archivio.txt");
        System.out.println("Archivio caricato da disco.");
    }
}