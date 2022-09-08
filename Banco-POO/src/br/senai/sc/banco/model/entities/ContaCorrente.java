package br.senai.sc.banco.model.entities;

import br.senai.sc.banco.view.Login;

public class ContaCorrente extends ContaPessoal {
    public ContaCorrente(String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
    }

    @Override
    public void sacar() {

    }

    public static ContaCorrente cadastrar(String numero, String agencia, String senha, Cliente cliente) {
        ContaCorrente conta = new ContaCorrente(numero, agencia, senha, 0, cliente, Login.banco);
        return conta;
    }

    public void transferir() {

    }

    public void pagarBoleto(Boleto boleto) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
