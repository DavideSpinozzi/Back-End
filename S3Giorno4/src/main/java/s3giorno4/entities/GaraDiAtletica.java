package s3giorno4.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "GaraDiAtletica.getGareDiAtleticaPerVincitore", query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore")
@NamedQuery(name = "GaraDiAtletica.getGareDiAtleticaPerPartecipante", query = "SELECT g FROM GaraDiAtletica g JOIN g.partecipazioni p WHERE p.persona = :partecipante")
public class GaraDiAtletica extends Evento {
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Partecipazione> partecipazioni;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, String tipoEvento, int numeroMassimoPartecipanti,
                          Set<Partecipazione> partecipazioni, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.partecipazioni = partecipazioni;
        this.vincitore = vincitore;
    }
}