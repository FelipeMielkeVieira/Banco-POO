package br.senai.sc.banco.controller;

import br.senai.sc.banco.model.entities.ContaPessoal;
import br.senai.sc.banco.model.service.ContaService;

public class ContaController {
    ContaPessoal model;

    public ContaPessoal validaLogin(String numeroCartao, String senha) {
        ContaService service = new ContaService();
        model = service.selecionarPorCartao(numeroCartao);
        return model.validaLogin(senha);
    }

    public boolean validaValor(ContaPessoal conta, String valor) {
        model = conta;
        return model.validaValor(Float.parseFloat(valor));
    }

    public void diminuirSaldo(ContaPessoal conta, String valor) {
        model = conta;
        model.diminuirSaldo(Float.parseFloat(valor));
    }
}
