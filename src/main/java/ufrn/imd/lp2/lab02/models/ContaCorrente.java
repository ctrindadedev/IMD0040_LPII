package main.java.ufrn.imd.lp2.lab02.models;

public class ContaCorrente extends Conta implements ITributavel {

    public ContaCorrente(int numero, String cliente) {
        super(numero, cliente);
    }

 private static final double TAXA_SAQUE = 0.05;
 private static final double TRIBUTO_SALDO = 0.01; 

    @Override
    public  boolean sacarValor(double valor){
       
        double valorComTaxa = valor + (valor * TAXA_SAQUE);
        if (valor > 0 && this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa;
            return true;
        }
        return false;
    };

    @Override
    public boolean transferirValor(double valor, Conta contaDestino) {
        if (this.sacarValor(valor)) { 
            contaDestino.depositarValor(valor);
            return true;
        }
        return false;
    }

    @Override
    public double calculaTributos() {
        return this.saldo * TRIBUTO_SALDO;
    }
}