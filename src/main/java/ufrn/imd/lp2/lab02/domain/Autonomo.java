package main.java.ufrn.imd.lp2.lab02.domain;

public class Autonomo extends Entregador{
    @Override
    public double calcularCustoFrete(double distanciaEmKm){
        double frete = distanciaEmKm*0.95;
        return frete;
    }
}
