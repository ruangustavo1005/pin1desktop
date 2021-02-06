package model;

/**
 * Modelo de um determinado veículo
 * @author Ruan
 */
public class Modelo extends Model {
    
    private int    ano;
    private int    codigo;
    private Marca  marca;
    private String nome;

    public Modelo() {
        this.marca = new Marca();
    }

    public Modelo(int ano, int codigo, Marca marca, String nome) {
        this.ano = ano;
        this.codigo = codigo;
        this.marca = marca;
        this.nome = nome;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}