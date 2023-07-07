package progetto.classi;

public class Rivista extends Readablex {
    public enum Periodicita {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }
}