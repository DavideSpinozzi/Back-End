package davidespinozzi.S5ProgettoSettimanale.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

	private final UtenteServiceImpl srv;
	
	@Autowired
	public UtenteController(UtenteServiceImpl srv) {
		this.srv = srv;
	}
}
