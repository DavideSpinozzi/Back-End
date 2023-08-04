package davidespinozzi.S5CompitiGiornalieri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import davidespinozzi.S5CompitiGiornalieri.services.ProvaService;

@RestController
@RequestMapping("/prova")
public class ProvaController {

	@Autowired
	private ProvaService ProvaService;
	
	@GetMapping("/info/{stringa}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String test(@PathVariable String stringa) {
		return ProvaService.controlloStringa(stringa);
	}
	
}
