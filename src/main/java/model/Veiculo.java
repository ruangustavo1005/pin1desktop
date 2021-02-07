package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de um veículo vrum vrum
 * @author Ruan
 */
@Entity
@Table(name = "tbveiculo")
public class Veiculo extends Model {
    
    @Id
    @Column(name = "veiplaca")
    private String placa;
    @Column(name = "veianofabricacao")
    private int    anoFabricacao;
    @Column(name = "veicor")
    private String cor;
    @ManyToOne
    @JoinColumn(name = "modcodigo")
    private Modelo modelo;
    @Column(name = "veiobservacao")
    private String observacao;
    @Column(name = "veipreco")
    private float  preco;
    @Column(name = "veiquilometragem")
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