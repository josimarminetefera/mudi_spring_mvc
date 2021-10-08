package br.com.alura.mvc.mudi_spring_mvc.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.alura.mvc.mudi_spring_mvc.model.Pedido;
import br.com.alura.mvc.mudi_spring_mvc.model.StatusPedido;
import br.com.alura.mvc.mudi_spring_mvc.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	// @Autowired cria uma instancia ao iniciar a classe
	@Autowired
	private PedidoRepository pedidoRepository;

	// Model model é uma interface para mostrar coisas para o usuário
	// Principal principal voce consegue recuperar dados do usuário logado e regras
	@GetMapping
	public String home(Model model, Principal principal) {
		// pedidoRepository é quem sabe se comunicar com o banco de dados
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
