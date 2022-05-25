package dev.acosta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.acosta.model.Pessoa;
import dev.acosta.repositories.PessoaRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-pessoa")
	public String inicio() {
		return "cadastro/cadastro-de-pessoa";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvar-pessoa")
	public String salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return "cadastro/cadastro-de-pessoa";
	}
	
}
