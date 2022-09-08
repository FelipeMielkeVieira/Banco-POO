package br.senai.sc.banco.model.service;

import br.senai.sc.banco.model.dao.BancoDAO;
import br.senai.sc.banco.model.entities.ContaPessoal;

public class ContaService {
    BancoDAO dao = new BancoDAO();

    public ContaPessoal selecionarPorCartao(String numeroCartao) {
        return dao.selecionarPorCartao(numeroCartao);
    }

    public void inserir(ContaPessoal conta) {
        dao.inserir(conta);
    }
}
