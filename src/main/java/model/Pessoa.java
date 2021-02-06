package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Modelo de determinada pessoa
 * @author Ruan
 */
@Entity
@Table(name = "tbpessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class Pessoa extends Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pescodigo")
    private int    codigo;
    @Column(name = "pescpf")
    private int    cpf;
    @Column(name = "pesdatanascimento")
    private String dataNascimento;
    @Column(name = "pesnome")
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