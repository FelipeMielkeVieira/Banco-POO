package br.senai.sc.banco.model.entities;

import br.senai.sc.banco.view.Login;

public class ContaCorrente extends ContaPessoal {
    public ContaCorrente(String numero, String agencia, String senha, Double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
    }

    @Override
    public void diminuirSaldo(Double valor) {

        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
        } else {
            throw new RuntimeException("Saldo Insuficiente!");
        }
    }

    public static ContaCorrente cadastrar(String numero, String agencia, String senha, Cliente cliente) {
        ContaCorrente conta = new ContaCorrente(numero, agencia, senha, 0.0, cliente, Login.banco);
        return conta;
    }

}
