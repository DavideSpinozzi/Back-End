package davidespinozzi.S5ProgettoSettimanale.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {

	private final DispositivoServiceImpl srv;
	
	@Autowired
	public DispositivoController(DispositivoServiceImpl srv) {
		this.srv = srv;
	}
}
