package br.senai.sc.banco.model.entities;

import br.senai.sc.banco.view.Login;

public class ContaPoupanca extends ContaPessoal {
    private Double taxaPercentual;

    public ContaPoupanca(Double taxaPercentual, String numero, String agencia, String senha, Double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
        this.taxaPercentual = taxaPercentual;
    }

    public static ContaPoupanca cadastrar(String numero, String agencia, String senha, Cliente cliente, Double dadoAdicional) {
        ContaPoupanca conta = new ContaPoupanca(dadoAdicional, numero, agencia, senha, 0.0, cliente, Login.banco);
        return conta;
    }

    @Override
    public void diminuirSaldo(Double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
        } else {
            throw new RuntimeException("Saldo Insuficiente!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "ContaPoupanca{" +
                "taxaPercentual=" + taxaPercentual +
                '}';
    }
}
