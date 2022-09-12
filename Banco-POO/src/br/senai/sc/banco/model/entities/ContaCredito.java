package br.senai.sc.banco.model.entities;

import br.senai.sc.banco.view.Login;

public class ContaCredito extends ContaPessoal {
    private Double limite;

    public ContaCredito(Double limite, String numero, String agencia, String senha, Double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
        this.limite = limite;
    }

    public static ContaCredito cadastrar(String numero, String agencia, String senha, Cliente cliente, Double dadoAdicional) {
        ContaCredito conta = new ContaCredito(dadoAdicional, numero, agencia, senha, 0.0, cliente, Login.banco);
        return conta;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLimite: " + this.getLimite();
    }

    @Override
    public void diminuirSaldo(Double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
        } else if(this.getSaldo() + this.getLimite() >= valor) {
            this.setSaldo(0.0);
            valor -= this.getSaldo();
            this.setLimite(this.getLimite() - valor);
        } else {
            throw new RuntimeException("Saldo Insuficiente!");
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
