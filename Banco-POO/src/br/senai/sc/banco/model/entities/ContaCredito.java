package br.senai.sc.banco.model.entities;

import br.senai.sc.banco.view.Login;

public class ContaCredito extends ContaPessoal {
    private double limite;

    public ContaCredito(double limite, String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
        this.limite = limite;
    }

    public static ContaCredito cadastrar(String numero, String agencia, String senha, Cliente cliente, Double dadoAdicional) {
        ContaCredito conta = new ContaCredito(dadoAdicional, numero, agencia, senha, 0, cliente, Login.banco);
        return conta;
    }

    @Override
    public String toString() {
        return super.toString() + "ContaCredito{" +
                "limite=" + limite +
                '}';
    }

    @Override
    public void sacar() {

    }

    public void pagarBoleto(Boleto boleto) {

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
