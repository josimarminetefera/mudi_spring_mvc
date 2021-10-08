package br.com.alura.mvc.mudi_spring_mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi_spring_mvc.model.Pedido;
import br.com.alura.mvc.mudi_spring_mvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByStatus(StatusPedido aguardando);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusAndUsuario(@Param("status") StatusPedido status, @Param("username") String username);
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
