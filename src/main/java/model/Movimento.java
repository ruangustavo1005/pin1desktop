package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.DateUtils;
import util.NumberUtils;

/**
 * Modelo de um movimento financeiro (entrada/saída de dinheiro)
 * @author Ruan
 */
@Entity
@Table(name = "tbmovimento")
public class Movimento extends Model implements ListagemAdicional, ListagemMaqueada, ListagemParcial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movcodigo")
    private int    codigo;
    @Column(name = "movdatahora")
    private Date   dataHora;
    @Column(name = "movdescricao")
    private String descricao;
    @Column(name = "movvalor")
    private float  valor;

    public Movimento() {
        
    }

    public Movimento(int codigo, Date dataHora, String descricao, float valor) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataHoraConsulta() {
        return DateUtils.dateHourToString(this.getDataHora());
    }
    
    public String getValorConsulta() {
        return NumberUtils.formataValor(this.getValor(), 2, true);
    }

    @Override
    public String toString() {
        return this.getValorConsulta();
    }
    
    @Override
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulosColunas = new HashMap<>();
        titulosColunas.put("codigo",           "Código");
        titulosColunas.put("dataHoraConsulta", "Data/Hora");
        titulosColunas.put("descricao",        "Descrição");
        titulosColunas.put("valorConsulta",    "Valor");
        return titulosColunas;
    }

    @Override
    public List<String> getCamposIgnorar() {
        List<String> campos = new ArrayList<>();
        campos.add("dataHora");
        campos.add("valor");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        List<String> campos = new ArrayList<>();
        campos.add("dataHoraConsulta");
        campos.add("valorConsulta");
        return campos;
    }
    
}