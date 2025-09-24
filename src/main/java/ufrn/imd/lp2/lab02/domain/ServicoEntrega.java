package main.java.ufrn.imd.lp2.lab02.domain;
import java.util.ArrayList;
import java.util.List;

public class ServicoEntrega {
    private List<Fretavel> itensFretados;

    public ServicoEntrega() {
        this.itensFretados = new ArrayList<>();
    }
    public void adicionaItem(Fretavel item) {
        this.itensFretados.add(item);
    }

    public void limparLista() {
        this.itensFretados.clear();
    }


    public double calcularCustoTotal(double distancia) {
        double custoTotal = 0.0;
        for (Fretavel item : itensFretados) {
            custoTotal += item.calcularCustoFrete(distancia);
        }
        return custoTotal;
    }
}
