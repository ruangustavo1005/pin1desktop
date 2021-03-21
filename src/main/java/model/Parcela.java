package model;

import java.util.Date;

/**
 * Não é persistida, apenas um recurso para uso nas simulações de financiamento
 *
 * @author Ruan
 */
public class Parcela {

    private int    sequencia;
    private double juros;
    private double amortizacao;
    private double saldoDevedor;
    private Date   data;

    public Parcela() {

    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getAmortizacao() {
        return amortizacao;
    }

    public void setAmortizado(double amortizacao) {
        this.amortizacao = amortizacao;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}