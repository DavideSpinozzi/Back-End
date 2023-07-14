package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name= "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
	@Id
	@GeneratedValue
    private Long numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti = new ArrayList<>();

    public Utente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }
}