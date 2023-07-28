package davidespinozzi.S4ProgettoSettimanale.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import davidespinozzi.S4ProgettoSettimanale.classi.Postazione;
import davidespinozzi.S4ProgettoSettimanale.classi.Prenotazione;
import davidespinozzi.S4ProgettoSettimanale.classi.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	
	public List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
	
	public List<Prenotazione> findByUtente(Utente utente);
}