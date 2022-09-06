package br.senai.sc.banco.model.entities;

public class Cliente {
    private String cpf, nome, endereco, profissao;
    private double renda;

    public Cliente(String cpf, String nome, String endereco, String profissao, double renda) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.profissao = profissao;
        this.renda = renda;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", profissao='" + profissao + '\'' +
                ", renda=" + renda +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }
}
