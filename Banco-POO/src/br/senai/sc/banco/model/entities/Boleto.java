package br.senai.sc.banco.model.entities;

public class Boleto {
    private String codigoBarras, dataVencimento;
    private double valor;

    public Boleto(String codigoBarras, String dataVencimento, double valor) {
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
