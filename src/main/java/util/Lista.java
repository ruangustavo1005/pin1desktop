package util;

/**
 * @author Ruan
 */
public class Lista {

    private int    codigo;
    private String nome;

    public Lista() {
        
    }
    
    public Lista(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCodigo() == ((Lista) obj).getCodigo();
    }
    
}