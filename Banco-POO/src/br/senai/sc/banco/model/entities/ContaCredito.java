package br.senai.sc.banco.model.entities;

public class ContaCredito extends ContaPessoal {
    private double limite;

    public ContaCredito(double limite, String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        super(numero, agencia, senha, saldo, cliente, banco);
        this.limite = limite;
    }

    @Override
    public String toString() {
        return super.toString() + "ContaCredito{" +
                "limite=" + limite +
                '}';
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
