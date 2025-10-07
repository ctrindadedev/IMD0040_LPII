package main.java.ufrn.imd.lp2.lab02.models;

public class ContaCorrente extends Conta implements ITributavel {

    @Override
    public  void sacarValor(Integer numeroConta, double valor){
        valor = valor*1.05;
        if(valor>0 && valor<=this.saldo){
            this.saldo -= valor;
        }
        else{
          throw new RuntimeException("Saldo insuficiente.")
        }
    };

    @Override

    public boolean transferirValor(double valor, Conta contaDestino) {
        if (this.sacar(valor)) { 
            contaDestino.depositarValor(valor);
            return true;
        }
        return false;
    }


    @Override
    public double calculaTributos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculaTributos'");
    }
 private static final double TAXA_SAQUE = 0.05; // 5%
    private static final double TRIBUTO_SALDO = 0.01; // 1%

    public ContaCorrente(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor) {
        double valorComTaxa = valor + (valor * TAXA_SAQUE);
        if (valor > 0 && this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if (this.sacar(valor)) { // Reutiliza a lógica de saque (com taxa)
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public double calculaTributos() {
        return this.saldo * TRIBUTO_SALDO;
    }

    @Override
    public String toString() {
        return "[Conta Corrente] " + super.toString();
    }
}
ContaPoupanca.java

Java

package ufrn.imd.lp2.lab02.models;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir
    @Override
    public String toString() {
        return "[Conta Poupança] " + super.toString();
    }
}

