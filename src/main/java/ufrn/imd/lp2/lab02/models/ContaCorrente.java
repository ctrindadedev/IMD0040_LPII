package main.java.ufrn.imd.lp2.lab02.models;

public class ContaCorrente extends Conta implements ITributavel{

    public  void sacarValor(double valor){
        if(valor>0 && valor<=this.saldo){
            this.saldo -= valor;
        }
        else{
            System.out.println("Valor insuficiente");
        }
    };

    public void transferirValor(double valor, Conta conta){
        if (valor>0 && valor<=this.saldo){
            this.saldo -= valor;
            conta.saldo += valor;
        }
    };

    public  double calculaTributos(double valor){
        return 1.0;
    }


}
