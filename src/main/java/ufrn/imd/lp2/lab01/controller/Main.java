package main.java.ufrn.imd.lp2.lab01.controller;

import main.java.ufrn.imd.lp2.lab01.domain.Item;
import main.java.ufrn.imd.lp2.lab01.domain.Pedido;
import main.java.ufrn.imd.lp2.lab01.service.PedidoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//O scanner.nextLine() extra consome o /n deixado pelos outros scanners de Double e Int

public class Main {

    private static final PedidoService pedidoService = new PedidoService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    registrarNovoPedido();
                    break;
                case 2:
                    removerPedido();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    executando = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n Sistema de gerenciamento de pedidos");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirResumoDoPedido(Pedido pedido) {
        System.out.println("Sistema de gerenciamento de pedidos");
        System.out.println("Pedido número: " + pedido.getIdPedido());
        System.out.println("Pedido feito por: " + pedido.getNomeClientePedido());
        System.out.println("Itens: \n");
        for (Item item : pedido.getItens()) {
            System.out.printf("%s: R$ %.2f\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: R$ %.2f\n", pedido.getValorTotal());
    }



    private static void registrarNovoPedido() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        ArrayList<Item> itens = new ArrayList<>();
        System.out.print("Quantos itens deseja adicionar? ");
        int numItens = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numItens; i++) {
            System.out.printf("Item %d \n", i + 1);
            System.out.print("Nome do item: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Preço do item: ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine();
            itens.add(new Item(nomeItem, precoItem));
        }

        Pedido novoPedido = pedidoService.registrarPedido(nomeCliente, itens);
        System.out.println("\n Pedido registrado com sucesso!");
        exibirResumoDoPedido(novoPedido);
    }

    private static void removerPedido() {
        System.out.print("Digite o número do pedido a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (pedidoService.removerPedido(id)) {
            System.out.println("Pedido removido com sucesso!");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private static void listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();

        if (pedidos.isEmpty()) {
            System.out.println("\n Nenhum pedido registrado no momento. Faça o primeiro!");
            return;
        }

        System.out.println("\n Pedidos Ativos: ");
        for (Pedido pedido : pedidos) {
            exibirResumoDoPedido(pedido);
        }
    }
}