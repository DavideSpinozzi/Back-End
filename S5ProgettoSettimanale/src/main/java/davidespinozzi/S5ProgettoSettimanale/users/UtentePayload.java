package davidespinozzi.S5ProgettoSettimanale.users;

import java.util.ArrayList;
import java.util.List;

import davidespinozzi.S5ProgettoSettimanale.devices.Dispositivo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UtentePayload {
	private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private List<Dispositivo> dispositivi = new ArrayList<>();
}
