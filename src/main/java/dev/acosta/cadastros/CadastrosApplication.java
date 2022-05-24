package dev.acosta.cadastros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="dev.acosta.model") //permite a criação automática de tabelas
public class CadastrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrosApplication.class, args);
	}

}
