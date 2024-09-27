package ufes.br.pedido.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author clayton
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private String tipo;
    public Item() {
    }   
    public Item(String nome, int quantidade, double valorUnitario, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public double getValorTotal() {
        return quantidade * valorUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", quantidade=").append(quantidade);
        sb.append(", valorUnitario=").append(valorUnitario);
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append(", valorTotal=").append(getValorTotal());
        sb.append('}');
        return sb.toString();
    }

}
