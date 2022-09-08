package br.senai.sc.banco.controller;

import br.senai.sc.banco.model.entities.Cliente;
import br.senai.sc.banco.model.service.BancoService;

public class ClienteController {
    public void cadastrar(String cpf, String nome, String endereco, String profissao, String renda) {
        Cliente cliente = new Cliente(cpf, nome, endereco, profissao, Double.parseDouble(renda));
        BancoService service = new BancoService();
        service.inserir(cliente);
    }

    public Cliente validar(String cpf) {
        BancoService bancoService = new BancoService();
        return bancoService.validar(cpf);
    }
}
