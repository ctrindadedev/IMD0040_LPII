package main.java.ufrn.imd.lp2.lab02.domain;

public class Funcionario extends  Entregador{

    public Funcionario(String placa, String cpf) {
        super();
    }
    @Override
    public double calcularCustoFrete(double distanciaEmKm){
        double frete = 5.00;
        return frete;
    }

}
