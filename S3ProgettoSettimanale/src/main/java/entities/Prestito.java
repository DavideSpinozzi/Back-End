package entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name= "prestiti")
@Getter
@Setter
@NoArgsConstructor
public class Prestito {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
    private Utente utente;
	@OneToOne
    private Readablex elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;


    public Prestito(Utente utente, Readablex elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
    @Override
    public String toString() {
        return "Prestito: id=" + getId() + ", utente=" + getUtente() + ", elementoPrestato=" + getElementoPrestato() + ", dataInizioPrestito=" + getDataInizioPrestito() + ", dataRestituzionePrevista=" + getDataRestituzionePrevista() + ", dataRestituzioneEffettiva=" + getDataRestituzioneEffettiva();
    }
}