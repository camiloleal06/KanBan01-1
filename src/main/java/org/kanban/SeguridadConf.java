package org.kanban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SeguridadConf extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	UserDetailsService userDetailService;
	
	//Establecer usar Usuarios en base de datos
	public void configuracion(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
	
	//Bean del password Encdoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(5);
	}
	
	
	//Cnfiguracion de la seguridad
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.and()
		.csrf().disable().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

}
