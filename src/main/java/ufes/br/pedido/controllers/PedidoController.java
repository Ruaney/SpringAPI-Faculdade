package ufes.br.pedido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ufes.br.pedido.models.Pedido;
import ufes.br.pedido.models.PedidoDTO;
import ufes.br.pedido.Services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> criarPedido(@RequestBody Pedido pedido) {
        Long pedidoId = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(pedidoId);
    }

    @PostMapping(value = "/{pedidoId}/processar-descontos")
    public ResponseEntity<Void> processarDescontos(@PathVariable Long pedidoId) {
        pedidoService.processarDescontos(pedidoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{pedidoId}")
    public ResponseEntity<PedidoDTO> consultarPedido(@PathVariable Long pedidoId) {
        Pedido pedido = pedidoService.consultarPedido(pedidoId);
        PedidoDTO pedidoDTO = new PedidoDTO(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }
}
