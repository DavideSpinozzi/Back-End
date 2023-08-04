package davidespinozzi.S5ProgettoSettimanale.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoServiceImpl implements DispositivoService{

	private final DispositivoRepository repo;
	
	@Autowired
	public DispositivoServiceImpl(DispositivoRepository repo) {
		this.repo = repo;
	}
}
