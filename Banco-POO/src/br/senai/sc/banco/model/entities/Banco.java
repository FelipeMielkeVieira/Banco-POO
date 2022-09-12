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
                ", nome='" + nome + '\'';
    }


    public String getNome() {
        return nome;
    }

    public ArrayList<ContaPessoal> getListaContas() {
        return listaContas;
    }

}
