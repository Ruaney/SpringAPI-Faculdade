package ufes.br.pedido.moduloDescontoEntrega;

import java.util.Map;

import ufes.br.pedido.models.Pedido;

public interface IFormaCalculoDescontoEntrega {
    Map<String, Double> calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}
