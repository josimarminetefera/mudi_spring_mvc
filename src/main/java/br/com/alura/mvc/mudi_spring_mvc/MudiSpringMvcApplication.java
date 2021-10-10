package br.com.alura.mvc.mudi_spring_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // para inicializar o cash junto com a aplicação
@SpringBootApplication
public class MudiSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudiSpringMvcApplication.class, args);
	}

}
