package br.senai.sc.banco.model.entities;

import br.senai.sc.banco.view.Login;

public class ContaPoupanca extends ContaPessoal {
    private double taxaPercentual;

    public ContaPoupanca(double taxaPercentual, String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
        this.taxaPercentual = taxaPercentual;
    }

    public static ContaPoupanca cadastrar(String numero, String agencia, String senha, Cliente cliente, Double dadoAdicional) {
        ContaPoupanca conta = new ContaPoupanca(dadoAdicional, numero, agencia, senha, 0, cliente, Login.banco);
        return conta;
    }

    public void transferir() {}

    @Override
    public void sacar() {

    }

    @Override
    public String toString() {
        return super.toString() + "ContaPoupanca{" +
                "taxaPercentual=" + taxaPercentual +
                '}';
    }
}
