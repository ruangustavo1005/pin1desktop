package model;

/**
 * Modelo de marcas de carros
 * @author Ruan
 */
public class Marca extends Model {
    
    private int    codigo;
    private String nome;

    public Marca() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}