package main.java.ufrn.imd.lp2.lab02.models;

public abstract class Conta {
    public Integer numeroConta;
    public Double saldo;
    public String cliente;

    public void depositarValor(double valor){
        this.saldo += valor;
    }

    public abstract void sacarValor(double valor);

    public abstract  void transferirValor(double valor, Conta conta);


}
