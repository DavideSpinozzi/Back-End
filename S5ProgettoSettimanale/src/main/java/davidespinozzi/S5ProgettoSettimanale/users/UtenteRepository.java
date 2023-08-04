package davidespinozzi.S5ProgettoSettimanale.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long>{
	Optional<Utente> findByEmail(String email);
}
