package main.java.ufrn.imd.lp2.lab02.service;
import main.java.ufrn.imd.lp2.lab02.models.*;
import main.java.ufrn.imd.lp2.lab02.repository.ContaRepository;

public class BancoService {
    private ContaRepository repository = new ContaRepository();

    public void criarConta(String nomeCliente, int tipoConta) {
        int numeroConta = repository.getProximoNumeroConta();
        Conta novaConta;
    if (tipoConta != 1 && tipoConta != 2) {
        System.out.println("Erro: Tipo de conta inválido. Por favor, escolha 1 para Corrente ou 2 para Poupança.");
        return; 
    }
        if (tipoConta == 1) {
            novaConta = new ContaCorrente(numeroConta, nomeCliente);
        } 
        else {
            novaConta = new ContaPoupanca(numeroConta, nomeCliente);
        }
        repository.adicionarConta(novaConta);
        System.out.println("Conta criada com sucesso! Número da conta: " + numeroConta);
    }

    public void realizarDeposito(int numeroConta, double valor) {
        Conta conta = repository.buscarPorNumero(numeroConta);
        if (conta != null) {
            conta.depositarValor(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarSaque(int numeroConta, double valor) {
        Conta conta = repository.buscarPorNumero(numeroConta);
        if (conta != null) {
            if (conta.sacarValor(valor)) {
                System.out.println("Saque realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente ou valor inválido.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarTransferencia(int numContaOrigem, int numContaDestino, double valor) {
        Conta contaOrigem = repository.buscarPorNumero(numContaOrigem);
        Conta contaDestino = repository.buscarPorNumero(numContaDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.transferirValor(valor, contaDestino)) {
                System.out.println("Transferência realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente na conta de origem.");
            }
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    public void listarContas() {
        System.out.println("\n========================================");
        System.out.println("\nLista de Contas Cadastradas");
        if (repository.listarTodas().isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (Conta conta : repository.listarTodas()) {
                System.out.println(conta.toString());
            }
            
        }
        System.out.println("\n========================================");
    }

    public void calcularTotalTributos() {
        double totalTributos = 0.0;
        for (Conta conta : repository.listarTodas()) {
            if (conta instanceof ITributavel) { 
                // Se sim, fazemos um "cast" para poder chamar o método da interface 
                ITributavel contaTributavel = (ITributavel) conta;
                totalTributos += contaTributavel.calculaTributos();
            }
        }
        System.out.println("\n========================================");
        System.out.println("Total de tributos a recolher: R$ " + String.format("%.2f", totalTributos));
        System.out.println("========================================");
    }
}