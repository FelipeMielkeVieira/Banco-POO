package br.senai.sc.banco.model.dao;

import br.senai.sc.banco.model.entities.ContaPessoal;

import java.util.ArrayList;

public class ContaDAO {
    private static ArrayList<ContaPessoal> listaContas = new ArrayList<>();


    public ContaPessoal selecionarPorCartao(String numeroCartao) {
        for (ContaPessoal conta : listaContas) {
            if (conta.getNumero().equals(numeroCartao)) {
                return conta;
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
