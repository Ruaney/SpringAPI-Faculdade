package ufes.br.pedido.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import ufes.br.pedido.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente save(Cliente cliente);
}
