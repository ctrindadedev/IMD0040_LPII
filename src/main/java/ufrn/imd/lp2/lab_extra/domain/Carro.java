package main.java.ufrn.imd.lp2.lab_extra.domain;

public class Carro extends  Veiculo {

    public Carro(String placa, int ano) {
        super();
    }

    @Override
    public double calcularCustoFrete(double distanciaEmKm){
        double frete = distanciaEmKm*1.25;
        return frete;
    }
}
