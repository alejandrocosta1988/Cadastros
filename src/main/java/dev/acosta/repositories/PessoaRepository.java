package dev.acosta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.acosta.model.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	@Query("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.nome LIKE	%1%")
	List<Pessoa> findPessoaByName(String nome);
	
}
