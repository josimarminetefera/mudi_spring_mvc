package br.com.alura.mvc.mudi_spring_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi_spring_mvc.model.Pedido;
import br.com.alura.mvc.mudi_spring_mvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByStatus(StatusPedido aguardando);

	@org.springframework.data.jpa.repository.Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);
}

//@Repository
//public class PedidoRepository {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	public List<Pedido> recuperarTodosPedidos() {
//		// Pedido.class representa o tipo que a consulta irá retornar
//		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
//		return query.getResultList();
//	}
//}
