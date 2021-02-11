package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Modelo de funcionário
 * @author Ruan
 */
@Entity
public class Funcionario extends Pessoa {
    
    @Column(name = "pesdataadmissao")
    private Date    dataAdmissao;
    @Column(name = "pesgerente")
    private boolean gerente;
    @Column(name = "pessalario")
    private float   salario;
    @Column(name = "peslogin")
    private String  login;
    @Column(name = "pessenha")
    private String  senha;

    public Funcionario() {
        super();
    }

    public Funcionario(Date dataAdmissao, boolean gerente, float salario, String login, String senha, int codigo, String cpf, Date dataNascimento, String nome) {
        super(codigo, cpf, dataNascimento, nome);
        this.dataAdmissao = dataAdmissao;
        this.gerente = gerente;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
