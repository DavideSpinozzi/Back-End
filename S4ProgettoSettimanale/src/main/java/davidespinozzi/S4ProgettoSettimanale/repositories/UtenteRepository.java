package davidespinozzi.S4ProgettoSettimanale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import davidespinozzi.S4ProgettoSettimanale.classi.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
