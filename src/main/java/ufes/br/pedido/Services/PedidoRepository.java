package ufes.br.pedido.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import ufes.br.pedido.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido save(Pedido pedido);
}
