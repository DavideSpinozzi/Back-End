package davidespinozzi.S4ProgettoSettimanale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import davidespinozzi.S4ProgettoSettimanale.classi.Postazione;
import davidespinozzi.S4ProgettoSettimanale.classi.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
	
	public List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
	}