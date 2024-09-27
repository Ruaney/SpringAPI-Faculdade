package ufes.br.pedido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufes.br.pedido.models.Cliente;
import ufes.br.pedido.Services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Long> cadastrarCliente(@RequestBody Cliente cliente) {
        Long clienteId = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok(clienteId);
    }
}
