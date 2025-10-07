package main.java.ufrn.imd.lp2.lab02.repository;

import main.java.ufrn.imd.lp2.lab02.models.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaRepository {
    private List<Conta> contas = new ArrayList<>();
    private int proximoNumeroConta = 100;

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null; 
    }

    public List<Conta> listarTodas() {
        return contas;
    }

    public int getProximoNumeroConta() {
        return proximoNumeroConta++;
    }
}