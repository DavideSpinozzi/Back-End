package entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
public class Libro extends Readablex {
    private String autore;
    private String genere;

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}