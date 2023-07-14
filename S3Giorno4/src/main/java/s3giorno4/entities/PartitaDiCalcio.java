package s3giorno4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.hibernate.annotations.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa")
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente <> p.squadraDiCasa")
@NamedQuery(name = "PartitaDiCalcio.getPartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa = p.numeroGolSquadraOspite")

public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, String tipoEvento, int numeroMassimoPartecipanti,
                           String squadraDiCasa, String squadraOspite, String squadraVincente,
                           int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}

