package br.com.alura.mvc.mudi_spring_mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi_spring_mvc.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi_spring_mvc.model.Pedido;
import br.com.alura.mvc.mudi_spring_mvc.model.User;
import br.com.alura.mvc.mudi_spring_mvc.repository.PedidoRepository;
import br.com.alura.mvc.mudi_spring_mvc.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}

	// RequisicaoNovoPedido é uma classe só para armazenar antes de mandar para o bd
	// este @Valid serve para ativar as validações dentro da class
	// Se der algum erro na validação ele vai vir por BindResult
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		System.out.println("novo");
		if (result.hasErrors()) {
			System.out.println("Ruim tem erro");
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Pedido pedido = requisicao.toPedido();
		User user = userRepository.findByUsername(username);
		pedido.setUser(user);
		pedidoRepository.save(pedido);

		return "redirect:/home";
	}

}
