package ufes.br.pedido.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufes.br.pedido.models.Cliente;
import ufes.br.pedido.models.Item;
import ufes.br.pedido.models.Pedido;
import ufes.br.pedido.CalculadoraDescontoService;

import java.time.LocalDate;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CalculadoraDescontoService calculadoraDescontoService;

    public Long criarPedido(Pedido pedido) {
        Long id = pedido.getCliente().getId();
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Pedido pedidoCreate = new Pedido(LocalDate.now(), cliente);
        for (Item item : pedido.getItens()) {
            pedidoCreate.adicionarItem(item);
        }
        
        pedidoCreate = pedidoRepository.save(pedidoCreate);
        return pedidoCreate.getId();
    }

    public void processarDescontos(Long pedidoId) {
        Pedido pedido = consultarPedido(pedidoId);

        calculadoraDescontoService.processar(pedido);
        pedidoRepository.save(pedido);
    }

    public Pedido consultarPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

}