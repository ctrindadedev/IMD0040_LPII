package main.java.ufrn.imd.lp2.lab01.service;

import main.java.ufrn.imd.lp2.lab01.domain.Item;
import main.java.ufrn.imd.lp2.lab01.domain.Pedido;
import main.java.ufrn.imd.lp2.lab01.repository.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private final PedidoRepository pedidoRepository;

    // O Service depende do Repository
    public PedidoService() {
        this.pedidoRepository = new PedidoRepository(); // Simplificado para o lab
    }
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
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

        // A lógica de negócio é criar o objeto Pedido
        Pedido novoPedido = new Pedido(nomeCliente,itens);
        novoPedido.setNomeCliente(nomeCliente);
        novoPedido.setItens(itens);
        novoPedido.calcularTotal();
        return pedidoRepository.salvar(novoPedido);
    }


}

//. Registrar Pedido:
//        ○ O sistema deve solicitar o nome do cliente.
//○ Um número de pedido deve ser gerado automaticamente de forma sequencial (1, 2, 3, ...).
//        ○ O sistema deve permitir que o usuário adicione um ou mais itens ao pedido. Para cada item, deve-se solicitar o nome e o preço.
//○ Ao final, o pedido completo deve ser armazenado na estrutura de dados principal.

//○ Após o registro, o sistema deve exibir uma nota de confirmação com o resumo do pedido recém-criado (número do pedido, cliente, itens e valor total).
//        2. Remover Pedido:
//        ○ O sistema deve solicitar o número do pedido que o usuário deseja remover.
//        ○ Caso o pedido exista, ele deve ser removido da lista. Caso contrário, uma mensagem de erro deve ser exibida.
//        3. Listar Pedidos:
//        ○ O sistema deve exibir todos os pedidos registrados.
//        ○ A exibição deve ser ordenada crescentemente pelo número do pedido.
//○ Para cada pedido, devem ser mostradas todas as informações:
//        ■ Número do Pedido
//■ Nome do Cliente
//■ Lista de Itens (com nome e preço de cada um)
//■ Valor total