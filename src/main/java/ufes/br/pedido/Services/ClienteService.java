package ufes.br.pedido.Services;

import ufes.br.pedido.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Long cadastrarCliente(Cliente cliente) {
        cliente = clienteRepository.save(cliente);
        return cliente.getId();
    }
}
