package ufes.br.pedido.models;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ufes.br.pedido.models.Pedido;
import ufes.br.pedido.models.Item;
import ufes.br.pedido.CupomDescontoEntrega;

public class PedidoDTO {


    private Long id;
    private LocalDate data;
    private Cliente cliente;
    private List<ItemDTO> itens;
    private List<CupomDescontoEntregaDTO> cuponsDescontoEntrega;
    private double valorTotal;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.cliente = pedido.getCliente();
        this.itens = pedido.getItens().stream().map(ItemDTO::new).collect(Collectors.toList());
        this.cuponsDescontoEntrega = pedido.getCuponsDescontoEntrega().stream().map(CupomDescontoEntregaDTO::new).collect(Collectors.toList());
        this.valorTotal = pedido.getValorPedido();
    }

    public static class ItemDTO {
        private String nome;
        private int quantidade;
        private double precoUnitario;

        public ItemDTO(Item item) {
            this.nome = item.getNome();
            this.quantidade = item.getQuantidade();
            this.precoUnitario = item.getValorUnitario();
        }
        public String getNome() {
            return nome;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }
    }

    public static class CupomDescontoEntregaDTO {
        private String nomeMetodo;
        private double valorDesconto;

        public CupomDescontoEntregaDTO(CupomDescontoEntrega cupom) {
            this.nomeMetodo = cupom.getNomeMetodo();
            this.valorDesconto = cupom.getValorDesconto();
        }

        public String getNomeMetodo() {
            return nomeMetodo;
        }

        public double getValorDesconto() {
            return valorDesconto;
        }
    }
    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public List<CupomDescontoEntregaDTO> getCuponsDescontoEntrega() {
        return cuponsDescontoEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
