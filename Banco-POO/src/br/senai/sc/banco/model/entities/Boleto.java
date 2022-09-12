package br.senai.sc.banco.model.entities;

public class Boleto {
    private String codigoBarras, dataVencimento;
    private Double valor;

    public Boleto(String codigoBarras, String dataVencimento, Double valor) {
        this.codigoBarras = codigoBarras;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", dataVencimento='" + dataVencimento + '\'' +
                ", valor=" + valor +
                '}';
    }

}
