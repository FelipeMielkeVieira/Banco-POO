package br.senai.sc.banco.model.entities;

public abstract class ContaPessoal {
    private String numero, agencia, senha;
    private Double saldo;
    private Cliente cliente;
    private Banco banco;

    public ContaPessoal(String numero, String agencia, String senha, Double saldo, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = saldo;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Número da Conta: " + this.getNumero() +
                "\nAgência: " + this.getAgencia() +
                "\nProprietário: " + this.getCliente().getNome() +
                "\nBanco: " + this.getBanco().getNome() +
                "\nSaldo: " + this.getSaldo();
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getSenha() {
        return senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void depositar(Double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public String imprimirDados() {
        return this.toString();
    }

    public ContaPessoal validaLogin(String senha) {
        if (this.getSenha().equals(senha)) {
            return this;
        }
        throw new RuntimeException("Senha incorreta");
    }

    public abstract void diminuirSaldo(Double valor);
}
