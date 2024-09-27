package ufes.br.pedido.models;

/**
 *
 * @author clayton
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import ufes.br.pedido.CupomDescontoEntrega;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private final double taxaEntrega = 10.00;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    
    @ElementCollection
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    public Pedido() {
        this.cuponsDescontoEntrega = new ArrayList<>();
    }
    public Pedido(LocalDate data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cuponsDescontoEntrega = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double getValorPedido() {
        double valorTotal = 0.0;
        for (Item item : itens) {
            valorTotal += item.getValorTotal();
        }
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega - getDescontoConcedido();
    }
   
    public void aplicarDesconto(CupomDescontoEntrega desconto) {
        double valorComDesconto = taxaEntrega - getDescontoConcedido() - desconto.getValorDesconto();
        if (valorComDesconto < 0) {
            desconto = new CupomDescontoEntrega("Parcial - " + desconto.getNomeMetodo(), desconto.getValorDesconto() + valorComDesconto);
        }
        cuponsDescontoEntrega.add(desconto);
    }

    public double getDescontoConcedido() {
        double descontoTotal = 0.0;
        for (CupomDescontoEntrega desconto : cuponsDescontoEntrega) {
            descontoTotal += desconto.getValorDesconto();
        }
        return descontoTotal;
    }
public LocalDate getData() {
        return data;
    }
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return cuponsDescontoEntrega;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{");
        sb.append("data=").append(data);
        sb.append(", cliente=").append(cliente);
        sb.append(", taxaEntrega=").append(taxaEntrega);
        sb.append(", valorPedido=").append(getValorPedido());
        sb.append(", descontoConcedido=").append(getDescontoConcedido());
        sb.append(", itens=").append(itens);
        sb.append(", cuponsDescontoEntrega=").append(cuponsDescontoEntrega);
        sb.append('}');
        return sb.toString();
    }

}
