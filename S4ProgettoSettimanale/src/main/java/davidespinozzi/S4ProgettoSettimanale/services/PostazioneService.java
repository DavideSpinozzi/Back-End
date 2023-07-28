package davidespinozzi.S4ProgettoSettimanale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import davidespinozzi.S4ProgettoSettimanale.classi.Postazione;
import davidespinozzi.S4ProgettoSettimanale.classi.TipoPostazione;
import davidespinozzi.S4ProgettoSettimanale.repositories.PostazioneRepository;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> ricercaPostazioniPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
    
    public void save(Postazione postazione) {
    	postazioneRepository.save(postazione);
    }
}
