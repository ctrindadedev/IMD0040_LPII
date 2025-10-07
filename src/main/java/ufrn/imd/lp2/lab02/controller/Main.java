package main.java.ufrn.imd.lp2.lab02.controller;

import main.java.ufrn.imd.lp2.lab02.service.BancoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoService service = new BancoService();
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Bem-vindo ao Banco Nubank ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Transferência");
            System.out.println("5. Listar Contas");
            System.out.println("6. Calcular Total de Tributos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Escolha o tipo da conta (1 - Corrente, 2 - Poupança): ");
                    int tipo = scanner.nextInt();
                    service.criarConta(nome, tipo);
                    break;
                case 2:
                    System.out.print("Digite o número da conta: ");
                    int numDeposito = scanner.nextInt();
                    System.out.print("Digite o valor do depósito: ");
                    double valDeposito = scanner.nextDouble();
                    service.realizarDeposito(numDeposito, valDeposito);
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    int numSaque = scanner.nextInt();
                    System.out.print("Digite o valor do saque: ");
                    double valSaque = scanner.nextDouble();
                    service.realizarSaque(numSaque, valSaque);
                    break;
                case 4:
                    System.out.print("Digite o número da conta de origem: ");
                    int numOrigem = scanner.nextInt();
                    System.out.print("Digite o número da conta de destino: ");
                    int numDestino = scanner.nextInt();
                    System.out.print("Digite o valor da transferência: ");
                    double valTransf = scanner.nextDouble();
                    service.realizarTransferencia(numOrigem, numDestino, valTransf);
                    break;
                case 5:
                    service.listarContas();
                    break;
                case 6:
                    service.calcularTotalTributos();
                    break;
                case 7:
                    executando = false;
                    System.out.println("Obrigado por usar o Banco Nubank");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}