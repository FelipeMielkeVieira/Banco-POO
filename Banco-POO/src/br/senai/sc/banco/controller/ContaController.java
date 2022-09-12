package br.senai.sc.banco.controller;

import br.senai.sc.banco.model.entities.*;
import br.senai.sc.banco.model.service.ContaService;

public class ContaController {
    ContaPessoal model;

    public ContaPessoal validaLogin(String numeroCartao, String senha) {
        ContaService service = new ContaService();
        model = service.selecionarPorCartao(numeroCartao);
        return model.validaLogin(senha);
    }

    public void diminuirSaldo(ContaPessoal conta, String valor) {
        model = conta;
        model.diminuirSaldo(Double.parseDouble(valor));
    }

    public void cadastrar(String numero, String agencia, String senha, String cpf, TipoConta tipoConta, String dadoAdicional) {
        ClienteController controllerCliente = new ClienteController();
        ContaService contaService = new ContaService();
        Boolean contaExiste = true;
        Cliente cliente = controllerCliente.validar(cpf);

        try {
            contaService.selecionarPorCartao(numero);
        } catch (Exception exception) {
            ContaPessoal conta = null;
            switch (tipoConta.getTipo()) {
                case "Corrente":
                    conta = ContaCorrente.cadastrar(numero, agencia, senha, cliente);
                    break;
                case "Crédito":
                    conta = ContaCredito.cadastrar(numero, agencia, senha, cliente, Double.parseDouble(dadoAdicional));
                    break;
                case "Poupança":
                    conta = ContaPoupanca.cadastrar(numero, agencia, senha, cliente, Double.parseDouble(dadoAdicional));
                    break;
            }
            contaService.inserir(conta);
            contaExiste = false;
        }

        if (contaExiste) {
            throw new RuntimeException("Número de cartão já existente!");
        }

    }

    public void depositar(ContaPessoal conta, String valor) {
        conta.depositar(Double.parseDouble(valor));
    }

    public String imprimirDados(ContaPessoal conta) {
        return conta.imprimirDados();
    }

    public void transferir(ContaPessoal conta, String numeroDestinatario, String valor) {
        ContaService service = new ContaService();
        ContaPessoal contaDestinario = service.selecionarPorCartao(numeroDestinatario);
        conta.diminuirSaldo(Double.parseDouble(valor));
        contaDestinario.depositar(Double.parseDouble(valor));
    }
}
