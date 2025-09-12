package main.java.ufrn.imd.lp2.lab01.domain;


import java.util.ArrayList;

public class Pedido {



    private Integer idPedido = 0;
    public String nomeClientePedido;
    public Integer quantidadeItemPedido;
    public Item itemPedido;
    public ArrayList<Item> itens;


    public Pedido( String nomeClientePedido, Integer quantidadeItemPedido, Item itemPedido) {
        this.idPedido += 1;
        this.nomeClientePedido = nomeClientePedido;
        this.quantidadeItemPedido = quantidadeItemPedido;
        this.itemPedido = itemPedido;
        this.itens = new ArrayList<>();
    }

    public void setNumero(int novoId) {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeClientePedido = nomeCliente;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void calcularTotal() {
        float total = 0;
        for (Item item : itens) {
            total += item.price;
        }
    }
}
