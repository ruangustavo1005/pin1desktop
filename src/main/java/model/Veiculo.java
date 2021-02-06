package model;

import util.NumberUtils;

/**
 * Modelo de um veículo vrum vrum
 * @author Ruan
 */
public class Veiculo extends Model {
    
    private int    anoFabricacao;
    private String cor;
    private Modelo modelo;
    private String observacao;
    private String placa;
    private float  preco;
    private int    quilometragem;

    public Veiculo() {
    }

    public Veiculo(int anoFabricacao, String cor, Modelo modelo, String observacao, String placa, float preco, int quilometragem) {
        this.anoFabricacao = anoFabricacao;
        this.cor           = cor;
        this.modelo        = modelo;
        this.observacao    = observacao;
        this.placa         = placa;
        this.preco         = preco;
        this.quilometragem = quilometragem;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

}