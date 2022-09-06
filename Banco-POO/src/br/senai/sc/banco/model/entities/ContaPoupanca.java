package br.senai.sc.banco.model.entities;

public class ContaPoupanca extends ContaPessoal {
    private double taxaPercentual;

    public ContaPoupanca(double taxaPercentual, String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
        this.taxaPercentual = taxaPercentual;
    }

    public void transferir() {}

}
