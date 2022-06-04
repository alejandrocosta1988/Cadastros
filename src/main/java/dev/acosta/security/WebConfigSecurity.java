package dev.acosta.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

	@Override //configura as solicitações de acesso por http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable() //desativa configurações padrão de memória
			.authorizeRequests() //permite e restrição de acessos
			.antMatchers(HttpMethod.GET,  "/").permitAll() //qualquer usuário pode acessar a página de index
			.anyRequest().authenticated()
			.and().formLogin().permitAll() //permite qualquer usuário
			.and().logout() //mapeia URL de logout e invalida usuário autenticado
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override //cria autenticação do usuário com banco de dados ou em memória
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("acosta")
			.password("123")
			.roles("ADMIN");
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**");
	}
	
	
	
}

