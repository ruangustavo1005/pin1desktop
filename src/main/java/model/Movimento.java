package model;

/**
 * Modelo de um movimento financeiro (entrada/saída de dinheiro)
 * @author Ruan
 */
public class Movimento extends Model {
    
    private int    codigo;
    private String dataHora;
    private String descricao;
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
