package br.com.ifpe.restaurante.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.ifpe.restaurante.service.AutenticarService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	AutenticarService autenticarService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticarService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/cliente/telaCadastro").permitAll()
		.antMatchers(HttpMethod.POST, "/cliente/cadastrar").permitAll()
		.antMatchers("/prato/cadastroTela").hasRole("MODERADOR")
		.antMatchers("/pedido/todosPedidos").hasRole("MODERADOR")
		.antMatchers("/cliente/telaVisualizarCliente").hasRole("MODERADOR")
		.antMatchers("/formaPagamento/cadastroTela").hasRole("MODERADOR")
		.antMatchers("/formaPagamento/cadastrar").hasRole("MODERADOR")
		.anyRequest().authenticated()
		.and().formLogin().defaultSuccessUrl("/home", true)
		.and().logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
}
