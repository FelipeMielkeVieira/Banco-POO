package br.senai.sc.banco.model.dao;

import br.senai.sc.banco.model.entities.ContaPessoal;
import br.senai.sc.banco.view.Login;

public class BancoDAO {

    public ContaPessoal selecionarPorCartao(String numeroCartao) {
        for (ContaPessoal conta : Login.banco.getListaContas()) {
            if (conta.getNumero().equals(numeroCartao)) {
                return conta;
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    public void inserir(ContaPessoal conta) {
        Login.banco.getListaContas().add(conta);
    }
}
