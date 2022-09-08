package br.senai.sc.banco.model.entities;

public enum TipoConta {
    CORRENTE("Corrente"), POUPANCA("Poupança"), CREDITO("Crédito");
    String tipo;
    TipoConta(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }
}
