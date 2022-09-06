package br.senai.sc.banco.model.entities;

import java.util.ArrayList;

public class Banco {
    private String cnpj, nome;
    private ArrayList<ContaPessoal> listaContas = new ArrayList<>();

    public Banco(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", listaContas=" + listaContas +
                '}';
    }

    public void criarContas() {

    }

    public void removerConta() {

    }

    public void relatorioContas() {

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ContaPessoal> getListaContas() {
        return listaContas;
    }

    public void setListaContas(ArrayList<ContaPessoal> listaContas) {
        this.listaContas = listaContas;
    }
}
