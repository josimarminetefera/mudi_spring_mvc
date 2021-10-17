package br.com.alura.mvc.mudi_spring_mvc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi_spring_mvc.model.Pedido;
import br.com.alura.mvc.mudi_spring_mvc.model.StatusPedido;
import br.com.alura.mvc.mudi_spring_mvc.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	// http://localhost:8080/api/pedidos/aguardando
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		Sort sort = Sort.by("id").descending();
		// PAGINAÇÃO DE ITENS
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
		
		return pedidos;
	}
}
