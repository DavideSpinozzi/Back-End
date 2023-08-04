package davidespinozzi.S5ProgettoSettimanale.users;

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
}
