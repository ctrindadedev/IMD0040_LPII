package main.java.ufrn.imd.lp2.lab02.models;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacarValor(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferirValor(double valor, Conta contaDestino) {
        if (this.sacarValor(valor)) {
            contaDestino.depositarValor(valor);
            return true;
        }
        return false;
    }
}