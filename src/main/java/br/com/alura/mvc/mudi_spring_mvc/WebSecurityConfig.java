package br.com.alura.mvc.mudi_spring_mvc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	// configuração de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		// todas requisições usário tem que estar autenticado
		http
		.authorizeRequests()
			.anyRequest()
			.authenticated()
		.and()
		.formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .permitAll()
        )
		.logout(logout -> logout.logoutUrl("/logout"));
	}

	//indicar que ai trabalhar com jdbc autentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//criar usuário inicial
		//UserDetails user = User.builder().username("joao").password(encoder.encode("joao")).roles("ADM").build();
		System.out.println("Teste");
		System.out.println(encoder.encode("josimar"));
		//System.out.println(user.getPassword());
		System.out.println(encoder);
		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
		//.withUser(user);
	}
	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("oi").password("oi").roles("ADM").build();
//
//		return new InMemoryUserDetailsManager(user);
//	}

}
