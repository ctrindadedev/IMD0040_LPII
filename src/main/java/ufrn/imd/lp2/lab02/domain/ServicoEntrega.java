package main.java.ufrn.imd.lp2.lab02.domain;
import java.util.ArrayList;
import java.util.List;

public class ServicoEntrega {
    public List<Fretavel> itensDaEntrega = new ArrayList<>();
    public Double distancia;

    public ServicoEntrega() {
        itensDaEntrega = new ArrayList();
    }
    // tratar todos de forma igual (POLIMORFISMO!)
    public double calcularCustoTotal() {
        double total = 0;
        for (Fretavel item : itensDaEntrega) {
            total += item.calcularCustoFrete(distancia);
        }
        return total;
    }
}
