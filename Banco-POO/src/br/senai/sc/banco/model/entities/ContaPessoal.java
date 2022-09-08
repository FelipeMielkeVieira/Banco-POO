package br.senai.sc.banco.model.entities;

public abstract class ContaPessoal {
    private String numero, agencia, senha;
    private double saldo;
    private Cliente cliente;
    private Banco banco;

    public ContaPessoal(String numero, String agencia, String senha, double saldo, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = saldo;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "ContaPessoal{" +
                "numero='" + numero + '\'' +
                ", agencia='" + agencia + '\'' +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", banco=" + banco +
                '}';
    }

    public void depositar() {

    }

    public abstract void sacar();

    public String imprimirDados() {
        return this.toString();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
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

    public ContaPessoal validaLogin(String senha) {
        if (this.getSenha().equals(senha)) {
            return this;
        }
        throw new RuntimeException("Senha incorreta");
    }

    public boolean validaValor(double valor) {
        if (this instanceof ContaCredito) {
            if (this.getSaldo() + ((ContaCredito) this).getLimite() >= valor) {
                return true;
            }
        } else if (this.getSaldo() >= valor) {
            return true;
        }
        return false;
    }

    public void diminuirSaldo(double valor) {
        if (this instanceof ContaCredito) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
            } else {
                valor = (this.getSaldo() - valor) * -1;
                this.setSaldo(0);
                ((ContaCredito) this).setLimite(((ContaCredito) this).getLimite() - valor);
            }
        } else {
            this.setSaldo(this.getSaldo() - valor);
        }
    }
}
