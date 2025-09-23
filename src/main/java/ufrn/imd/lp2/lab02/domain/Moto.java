package main.java.ufrn.imd.lp2.lab02.domain;

public class Moto extends Veiculo {

    public Moto(String placa, int ano) {
        super();
    }

    @Override
    public double calcularCustoFrete(double distanciaEmKm){
        double frete = distanciaEmKm*0.45;
        return frete;
    }
}
