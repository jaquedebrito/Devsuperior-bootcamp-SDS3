package com.devsuperior.dsvendas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Configuração de segurança da aplicação.
 * 
 * Define as regras de CORS e segurança HTTP para permitir
 * que o frontend acesse a API sem restrições.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	/**
	 * Configura as regras de segurança HTTP.
	 * 
	 * - Habilita H2 console em ambiente de teste
	 * - Desabilita CSRF (adequado para APIs REST stateless)
	 * - Define sessões como stateless
	 * - Permite todas as requisições sem autenticação
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Permite acesso ao H2 console em ambiente de teste
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		// Habilita CORS e desabilita CSRF (não necessário para API stateless)
		http.cors().and().csrf().disable();
		// Configura sessões como stateless (sem armazenamento de sessão no servidor)
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// Permite todas as requisições (sem autenticação)
		http.authorizeRequests().anyRequest().permitAll();
	}

	/**
	 * Configura CORS para permitir requisições do frontend.
	 * 
	 * Permite todos os métodos HTTP comuns e todas as origens.
	 * Para produção, considere restringir as origens permitidas.
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
