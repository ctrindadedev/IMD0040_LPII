package main.java.ufrn.imd.lp2.lab_extra.domain;

public class Autonomo extends Entregador{

    public Autonomo(String placa, String cpf) {
        super();
    }

    @Override
    public double calcularCustoFrete(double distanciaEmKm){
        double frete = distanciaEmKm*0.95;
        return frete;
    }
}
