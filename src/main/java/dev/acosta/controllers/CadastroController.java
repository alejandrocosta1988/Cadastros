package dev.acosta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return pessoas();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/lista-de-pessoas")
	public ModelAndView pessoas() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro-de-pessoa");
		
		Iterable<Pessoa> pessoas = pessoaRepository.findAll();
		modelAndView.addObject("pessoas", pessoas);
		
		return modelAndView;
		
	}
	
	@GetMapping("/editar-pessoa/{id}")
	public ModelAndView editarPessoa(@PathVariable("id") Long id) {
		
		Pessoa pessoa = pessoaRepository.findById(id).get();
		
		ModelAndView modelAndView = new ModelAndView("cadastro/editar-pessoa");
		modelAndView.addObject("pessoa", pessoa);
		
		return modelAndView;
		
	}
	
	@GetMapping("/excluir-pessoa/{id}")
	public ModelAndView excluirPessoa(@PathVariable("id") Long id) {
		
		pessoaRepository.deleteById(id);
		return pessoas();
		
	}
	
}
