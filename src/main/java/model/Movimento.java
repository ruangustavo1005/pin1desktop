package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de um movimento financeiro (entrada/saída de dinheiro)
 * @author Ruan
 */
@Entity
@Table(name = "tbmovimento")
public class Movimento extends Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movcodigo")
    private int    codigo;
    @Column(name = "movdatahora")
    private String dataHora;
    @Column(name = "movdescricao")
    private String descricao;
    @Column(name = "movvalor")
    private float  valor;

    public Movimento() {
        
    }

    public Movimento(int codigo, String dataHora, String descricao, float valor) {
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
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
    
}
