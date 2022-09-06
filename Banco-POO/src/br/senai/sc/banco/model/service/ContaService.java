package br.senai.sc.banco.model.service;

import br.senai.sc.banco.model.dao.ContaDAO;
import br.senai.sc.banco.model.entities.ContaPessoal;

public class ContaService {
    ContaDAO dao = new ContaDAO();

    public ContaPessoal selecionarPorCartao(String numeroCartao) {
        return dao.selecionarPorCartao(numeroCartao);
    }
}
