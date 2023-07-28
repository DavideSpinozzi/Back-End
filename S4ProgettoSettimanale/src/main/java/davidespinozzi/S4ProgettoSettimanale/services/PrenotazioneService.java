package davidespinozzi.S4ProgettoSettimanale.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import davidespinozzi.S4ProgettoSettimanale.classi.Postazione;
import davidespinozzi.S4ProgettoSettimanale.classi.Prenotazione;
import davidespinozzi.S4ProgettoSettimanale.classi.Utente;
import davidespinozzi.S4ProgettoSettimanale.repositories.PrenotazioneRepository;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public boolean verificaDisponibilitaPostazionePerData(Postazione postazione, LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        return prenotazioni.isEmpty();
    }

    public Prenotazione effettuaPrenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        if (verificaDisponibilitaPostazionePerData(postazione, dataPrenotazione)) {
            Prenotazione prenotazione = new Prenotazione(postazione, utente, dataPrenotazione);
            return prenotazioneRepository.save(prenotazione);
        }
        return null;
    }

    public List<Prenotazione> getPrenotazioniByUtente(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }
}