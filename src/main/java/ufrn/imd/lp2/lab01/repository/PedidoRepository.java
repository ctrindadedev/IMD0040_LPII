package main.java.ufrn.imd.lp2.lab01.repository; //Camada que interage com os dados do sistema

import main.java.ufrn.imd.lp2.lab01.domain.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoRepository {
    // Usamos AtomicInteger para garantir que o ID seja único e sequencial de forma segura
    private static final AtomicInteger contadorId = new AtomicInteger(0);
    private final List<Pedido> pedidos = new ArrayList<>();

    public Pedido salvar(Pedido pedido) {

        // Gera um novo ID sequencial antes de salvar
        int novoId = contadorId.incrementAndGet();
        pedido.setNumero(novoId);
        pedidos.add(pedido);
        System.out.println("Pedido " + novoId + " armazenado na estrutura de dados."); // Mensagem de log
        return pedido;
    }

    public List<Pedido> buscarTodos() {
        return pedidos;
    }

    public void remover(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public Pedido buscarPorId(Pedido pedido, int id) {
        for (Pedido p : pedidos) {
            if (p.getIdPedido().equals(id)) {
                return p;
            }
        }
        return null;
    }
}