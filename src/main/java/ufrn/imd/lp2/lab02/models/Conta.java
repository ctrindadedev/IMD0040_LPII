package main.java.ufrn.imd.lp2.lab02.models;

public abstract class Conta  {
    protected int numero;
    protected String cliente;
    protected double saldo;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public Integer getNumeroConta() {
        return numero;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numero = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void depositarValor(double valor){
         if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }

    }

    public abstract boolean sacarValor(double valor);
    public abstract  boolean transferirValor(double valor, Conta conta);


}
