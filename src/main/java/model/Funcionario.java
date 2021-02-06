package model;

/**
 * Modelo de funcionário
 * @author Ruan
 */
public class Funcionario extends Pessoa {
    
    private String  dataAdmissao;
    private boolean gerente;
    private float   salario;
    private String  login;
    private String  senha;

    public Funcionario() {
        super();
    }

    public Funcionario(String dataAdmissao, boolean gerente, float salario, String login, String senha, int codigo, int cpf, String dataNascimento, String nome) {
        super(codigo, cpf, dataNascimento, nome);
        this.dataAdmissao = dataAdmissao;
        this.gerente = gerente;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
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
