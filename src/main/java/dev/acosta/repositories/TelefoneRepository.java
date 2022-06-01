package dev.acosta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.acosta.model.Telefone;

public interface TelefoneRepository extends CrudRepository<Telefone, Long> {

	@Query("SELECT telefone FROM Telefone telefone WHERE telefone.pessoa.id = :pessoaId")
	List<Telefone> getTelefones(@Param("pessoaId") Long pessoaId);
	
}
