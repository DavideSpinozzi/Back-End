package davidespinozzi.S5ProgettoSettimanale.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import davidespinozzi.S5ProgettoSettimanale.exceptions.BadRequestException;
import davidespinozzi.S5ProgettoSettimanale.exceptions.NotFoundException;

@Service
public class UtenteServiceImpl implements UtenteService {

	private final UtenteRepository repo;
	
	@Autowired
	public UtenteServiceImpl(UtenteRepository repo) {
		this.repo = repo;
	}

	@Override
    public Utente create(UtentePayload body) {
        Optional<Utente> existingUtente = repo.findByEmail(body.getEmail());
        if (existingUtente.isPresent()) {
            throw new BadRequestException("L'email è già stata utilizzata");
        }
        
        Utente newUtente = new Utente(body.getUsername(), body.getNome(), body.getCognome(), body.getEmail(), body.getPassword());
        return repo.save(newUtente);
    }

    @Override
    public Page<Utente> find(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return repo.findAll(pageable);
    }

    @Override
    public Utente findById(Long id) throws NotFoundException {
        return repo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Utente findByIdAndUpdate(Long id, UtentePayload body) throws NotFoundException {
        Utente found = this.findById(id);
        found.setEmail(body.getEmail());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());

        return repo.save(found);
    }

    @Override
    public void findByIdAndDelete(Long id) throws NotFoundException {
        Utente found = this.findById(id);
        repo.delete(found);
    }

    @Override
    public Utente findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovato"));
    }
}
