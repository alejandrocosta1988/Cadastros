package dev.acosta.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.acosta.model.Pessoa;
import dev.acosta.model.Telefone;
import dev.acosta.repositories.PessoaRepository;
import dev.acosta.repositories.TelefoneRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	@RequestMapping(method=RequestMethod.GET, value="/cadastro-de-pessoa")
	public String inicio() {
		return "cadastro/cadastro-de-pessoa";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvar-pessoa")
	public ModelAndView salvar(@Valid Pessoa pessoa, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			ModelAndView modelAndView = new ModelAndView("cadastro/cadastro-de-pessoa");
			List<String> mensagensDeErro = new ArrayList<>();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				mensagensDeErro.add(objectError.getDefaultMessage()); //mensagem registrada na anotação de validação em Pessoa
			}
			modelAndView.addObject("mensagensDeErro", mensagensDeErro);
			return modelAndView;
		}
		
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
	
	@PostMapping("/pesquisar-pessoa")
	public ModelAndView pesquisar(@RequestParam("nome") String nome) {
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro-de-pessoa");
		modelAndView.addObject("pessoas", pessoaRepository.findPessoaByNome(nome));
		
		return modelAndView;
		
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView detalhes(@PathVariable("id") Long id) {
		
		Pessoa pessoa = pessoaRepository.findById(id).get();
		List<Telefone> telefones = telefoneRepository.getTelefones(id);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/detalhes");
		modelAndView.addObject("pessoa", pessoa);
		modelAndView.addObject("telefones", telefones);
		
		return modelAndView;
		
	}
	
	@PostMapping("/detalhes/{id}/registrarTelefone")
	public ModelAndView registrarTelefone(@PathVariable("id") Long pessoaId, Telefone telefone) {
		
		Pessoa pessoa = pessoaRepository.findById(pessoaId).get();
		telefone.setPessoa(pessoa);
		telefoneRepository.save(telefone);
		return detalhes(pessoaId);
		
	}
	
	@GetMapping("detalhes/{pessoaId}/excluirTelefone/{telefoneId}")
	public ModelAndView excluirTelefone(@PathVariable("pessoaId") Long pessoaId, @PathVariable("telefoneId") Long telefoneId) {
		
		telefoneRepository.deleteById(telefoneId);
		return detalhes(pessoaId);
		
	}
	
	
	
}
