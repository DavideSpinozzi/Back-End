package progetto.classi;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class Archivio {
    private List<Readablex> catalogo;

    public Archivio() {
        catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(Readablex elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String isbn) {
        catalogo.removeIf(e -> e.getIsbn().equals(isbn));
    }

    public Readablex ricercaPerIsbn(String isbn) {
        return catalogo.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Readablex> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(e -> e.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<Readablex> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(e -> e instanceof Libro)
                .filter(e -> ((Libro) e).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void salvaSuDisco(String filePath) {
        try {
            File file = new File(filePath);
            List<String> lines = new ArrayList<>();
            for (Readablex elemento : catalogo) {
                String line = elemento.getClass().getName() + "," +
                              elemento.getIsbn() + "," +
                              elemento.getTitolo() + "," +
                              elemento.getAnnoPubblicazione() + "," +
                              elemento.getNumeroPagine();
                if (elemento instanceof Libro) {
                    Libro libro = (Libro) elemento;
                    line += "," + libro.getAutore() + "," + libro.getGenere();
                }
                lines.add(line);
            }
            FileUtils.writeLines(file, lines);
            System.out.println("Archivio salvato su disco.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio su disco dell'archivio.");
            e.printStackTrace();
        }
    }

    public void caricaDaDisco(String filePath) {
        try {
            File file = new File(filePath);
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
            catalogo.clear();
            for (String line : lines) {
                String[] parts = line.split(",");
                String className = parts[0];
                String isbn = parts[1];
                String titolo = parts[2];
                int annoPubblicazione = Integer.parseInt(parts[3]);
                int numeroPagine = Integer.parseInt(parts[4]);

                Readablex elemento;
                if (className.equals(Libro.class.getName())) {
                    String autore = parts[5];
                    String genere = parts[6];
                    elemento = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
                } else {
                    elemento = new Readablex(isbn, titolo, annoPubblicazione, numeroPagine);
                }

                catalogo.add(elemento);
            }
            System.out.println("Archivio caricato da disco.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento da disco dell'archivio.");
            e.printStackTrace();
        }
    }
}