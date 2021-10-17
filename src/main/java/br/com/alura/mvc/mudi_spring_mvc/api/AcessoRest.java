package br.com.alura.mvc.mudi_spring_mvc.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi_spring_mvc.interceptor.InterceptadorDeAcessos;
import br.com.alura.mvc.mudi_spring_mvc.interceptor.InterceptadorDeAcessos.Acesso;

@RequestMapping("/api/acessos")
@RestController
public class AcessoRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcessos.acessos;
	}
}
