package main.java.ufrn.imd.lp2.lab01.service; //Lógica de negócio da Aplicação

import main.java.ufrn.imd.lp2.lab01.domain.Item;
import main.java.ufrn.imd.lp2.lab01.domain.Pedido;
import main.java.ufrn.imd.lp2.lab01.repository.PedidoRepository;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private final PedidoRepository pedidoRepository;

    // O Service depende do Repository
    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();
    }

    /**
     * Recebe os dados já validados da camada de apresentação e aplica as regras de negócio.
     * @param nomeCliente O nome do cliente.
     * @param itens A lista de itens já criada.
     * @return O objeto Pedido completo e salvo.
     */

    public Pedido registrarPedido(String nomeCliente, ArrayList<Item> itens) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("O pedido deve ter pelo menos um item.");
        }

        Pedido novoPedido = new Pedido();
        novoPedido.setNomeCliente(nomeCliente);
        novoPedido.setItens(itens);
        novoPedido.calcularTotal();

        // Delegar a persistência (e a geração de ID) para o Repository
        return pedidoRepository.salvar(novoPedido);
    }

    public boolean removerPedido(Integer id) {
        if ( id == null) {
            throw new IllegalArgumentException("É necessário informar o ID do pedido.");
        }
        return pedidoRepository.remover(id);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.buscarTodos();
    }
}