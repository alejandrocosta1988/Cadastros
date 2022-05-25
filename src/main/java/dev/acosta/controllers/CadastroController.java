package dev.acosta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroController {

	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-pessoa")
	public String inicio() {
		return "cadastro/cadastro-de-pessoa";
	}
	
}
