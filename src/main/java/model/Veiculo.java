package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class Veiculo extends Model implements ListagemMaqueada, ListagemAdicional, ListagemParcial, Comparator<Veiculo> {
    
    static public int SITUACAO_DISPONIVEL = 1;
    static public int SITUACAO_VENDIDO    = 2;
    
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
    @Column(name = "veisituacao")
    private int    situacao;
    @Column(name = "veiquilometragem")
    private int    quilometragem;

    public Veiculo() {
        
    }

    public Veiculo(int anoFabricacao, String cor, Modelo modelo, String observacao, String placa, float preco, int situacao, int quilometragem) {
        this.anoFabricacao = anoFabricacao;
        this.cor           = cor;
        this.modelo        = modelo;
        this.observacao    = observacao;
        this.placa         = placa;
        this.preco         = preco;
        this.situacao      = situacao;
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

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }    
    
    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getSituacaoConsulta() {
        HashMap<Integer, String> situacoes = new HashMap<>();
        situacoes.put(SITUACAO_VENDIDO,    "Vendido");
        situacoes.put(SITUACAO_DISPONIVEL, "Disponível");
        return situacoes.get(this.getSituacao());
    }
    
    @Override
    public boolean isChavePreenchida() {
        return this.getPlaca() != null;
    }

    @Override
    public String toString() {
        return getModelo().getMarca().getNome() + " " + getModelo().getNome() + " " + cor + " " + anoFabricacao + "/" + getModelo().getAno() + " (" + placa + ")";
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulosColunas = new HashMap<>();
        titulosColunas.put("anoFabricacao",    "Ano de Fabricação");
        titulosColunas.put("observacao",       "Observação");
        titulosColunas.put("preco",            "Preço");
        titulosColunas.put("situacaoConsulta", "Situação");
        return titulosColunas;
    }

    @Override
    public List<String> getCamposAdicionar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("situacaoConsulta");
        return campos;
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("SITUACAO_DISPONIVEL");
        campos.add("SITUACAO_VENDIDO");
        campos.add("situacao");
        return campos;
    }

    @Override
    public int compare(Veiculo veiculo1, Veiculo veiculo2) {
        return veiculo1.getPlaca().compareTo(veiculo2.getPlaca());
    }

}