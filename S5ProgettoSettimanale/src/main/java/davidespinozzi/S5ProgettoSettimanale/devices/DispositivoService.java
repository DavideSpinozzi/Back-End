package davidespinozzi.S5ProgettoSettimanale.devices;

import org.springframework.data.domain.Page;

import davidespinozzi.S5ProgettoSettimanale.exceptions.BadRequestException;
import davidespinozzi.S5ProgettoSettimanale.exceptions.NotFoundException;

public interface DispositivoService {
	
    Dispositivo createDispositivo(DispositivoPayload dispositivoPayload) throws BadRequestException;
    
    Page<Dispositivo> find(int page, int size, String sort);
    
    Dispositivo getDispositivoById(Long id) throws NotFoundException;
    
    Dispositivo updateDispositivo(Long id, DispositivoPayload dispositivoPayload) throws NotFoundException;
    
    void delete(Long id) throws NotFoundException;
}
