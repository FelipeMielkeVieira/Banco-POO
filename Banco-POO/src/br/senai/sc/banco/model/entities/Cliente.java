package br.senai.sc.banco.model.entities;

public class Cliente {
    private String cpf, nome, endereco, profissao;
    private Double renda;

    public Cliente(String cpf, String nome, String endereco, String profissao, Double renda) {
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

    public String getNome() {
        return nome;
    }

}
