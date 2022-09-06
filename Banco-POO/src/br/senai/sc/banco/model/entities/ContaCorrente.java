package br.senai.sc.banco.model.entities;

public class ContaCorrente extends ContaPessoal {
    public ContaCorrente(String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
    }

    public void transferir() {

    }

    public void pagarBoleto(Boleto boleto) {

    }
}
