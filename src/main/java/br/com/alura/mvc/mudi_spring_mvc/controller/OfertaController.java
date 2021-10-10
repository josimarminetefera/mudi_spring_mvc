package br.com.alura.mvc.mudi_spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	@GetMapping // se acessar com /oferta vem para esta função
	public String getFormularioParaOfertas() {
		return "oferta/home";
	}
}
