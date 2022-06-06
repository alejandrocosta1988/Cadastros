package dev.acosta.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.acosta.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.login = :login")
	Usuario findUserByLogin(@Param(value = "login") String login);
	
}
