package dev.acosta.cadastros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages="dev.acosta.model") //permite a criação automática de tabelas
@ComponentScan(basePackages = {"dev.acosta.*"}) //força o mapeamento das pastas indicadas
@EnableJpaRepositories(basePackages = {"dev.acosta.repositories"}) //reconhecimento dos repositories
@EnableTransactionManagement
public class CadastrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrosApplication.class, args);
	}

}
