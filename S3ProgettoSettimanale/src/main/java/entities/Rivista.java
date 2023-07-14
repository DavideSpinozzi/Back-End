package entities;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Rivista extends Readablex {
    public enum Periodicita {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    private Periodicita periodicita;

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
    @Override
    public String toString() {
        return "Rivista: isbn=" + getIsbn() + ", titolo=" + getTitolo() + ", periodicita=" + getPeriodicita();
    }
}