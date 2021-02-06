package model;

/**
 * Modelo de determinada pessoa
 * @author Ruan
 */
abstract public class Pessoa extends Model {
    
    private int    codigo;
    private int    cpf;
    private String dataNascimento;
    private String nome;

    public Pessoa() {
        
    }
    
    public Pessoa(int codigo, int cpf, String dataNascimento, String nome) {
        this.codigo         = codigo;
        this.cpf            = cpf;
        this.dataNascimento = dataNascimento;
        this.nome           = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}