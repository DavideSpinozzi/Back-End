package davidespinozzi.S5CompitiGiornalieri.services;

import org.springframework.stereotype.Service;


@Service
public class ProvaService {


	public String controlloStringa(String stringa) {
		String messaggioRisultatoItaliano = "italiano";
		String messaggioRisultatoInglese = "inglese";
		String messaggioErrore = "bho";
		switch(stringa.toLowerCase()) {
		
		case "italiano": return messaggioRisultatoItaliano;
		case "inglese" : return messaggioRisultatoInglese;
		default: return messaggioErrore;
		
		}
		
	}
}
