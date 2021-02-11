package model;

import java.util.Date;
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
    private String cpf;
    @Column(name = "pesdatanascimento")
    private Date   dataNascimento;
    @Column(name = "pesnome")
    private String nome;

    public Pessoa() {
        
    }
    
    public Pessoa(int codigo, String cpf, Date dataNascimento, String nome) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }
    
}