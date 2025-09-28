package main.java.ufrn.imd.lp2.lab_extra.controller;
import main.java.ufrn.imd.lp2.lab_extra.domain.*;

public class Main {
    public static void main(String[] args) {
        ServicoEntrega servico = new ServicoEntrega();
        System.out.println("\nSimulação 1 ");

        //Simulação 1:  entrega de 10km feita por um Funcionario com um Carro
        Funcionario funcionario = new Funcionario("João Silva", "123.456.789-00");
        Carro carro = new Carro( "ABC-1234", 2010);

        servico.adicionaItem(funcionario);
        servico.adicionaItem(carro);

        double custoEntrega1 = servico.calcularCustoTotal(10);
        System.out.println("Custo total da entrega de 10km (Funcionário + Carro): R$ " + String.format("%.2f", custoEntrega1));

        servico.limparLista();

        // Simulação 2: Entrega de 25km por Autônomo com Motocicleta
        System.out.println("\nSimulação 2");

        Autonomo autonomo = new Autonomo("Maria Souza", "987.654.321-00");
        Moto moto = new Moto("ZYXW-123", 2010);

        servico.adicionaItem(autonomo);
        servico.adicionaItem(moto);

        double custoEntrega2 = servico.calcularCustoTotal(25);
        System.out.println("Custo total da entrega de 25km (Autônomo + Moto): R$ " + String.format("%.2f", custoEntrega2));
    }
}