package main.java.ufrn.imd.lp2.lab01.domain;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Integer idPedido;
    private String nomeClientePedido;
    private List<Item> itens;
    private Double valorTotalPedido;


    public Pedido() {
        this.itens = new ArrayList<>(); // Garante que a lista nunca seja nula
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    //Metódo usado pelo PedidoRepository para setar o ID
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }


    public String getNomeClientePedido() {
        return nomeClientePedido;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeClientePedido = nomeCliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return this.valorTotalPedido;
    }

    public void calcularTotal() {
        this.valorTotalPedido = 0.0;
        if (this.itens != null) {
            for (Item item : this.itens) {
                this.valorTotalPedido += item.getPrice();
            }
        }
    }
}
