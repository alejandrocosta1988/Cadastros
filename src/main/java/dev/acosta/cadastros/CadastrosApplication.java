package dev.acosta.cadastros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages="dev.acosta.model") //permite a criação automática de tabelas
@ComponentScan(basePackages = {"dev.acosta.*"}) //força o mapeamento das pastas indicadas
public class CadastrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrosApplication.class, args);
	}

}
