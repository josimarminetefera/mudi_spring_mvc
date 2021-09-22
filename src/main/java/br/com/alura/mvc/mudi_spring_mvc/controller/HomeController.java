package br.com.alura.mvc.mudi_spring_mvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi_spring_mvc.model.Pedido;

@Controller
public class HomeController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/home")
	public String home(Model model) {

		// Pedido.class representa o tipo que a consulta irá retornar
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		List<Pedido> pedidos = query.getResultList();

		model.addAttribute("pedidos", pedidos);

		return "home";
	}
}
