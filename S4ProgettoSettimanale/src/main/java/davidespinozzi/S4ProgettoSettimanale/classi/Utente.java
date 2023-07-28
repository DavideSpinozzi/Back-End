package davidespinozzi.S4ProgettoSettimanale.classi;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utente")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
	public Utente(String username, String nome, String cognome, String email) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Utente [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + "]";
	}
    
}