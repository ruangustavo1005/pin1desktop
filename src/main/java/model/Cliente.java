package model;

/**
 * Modelo de um cliente
 * @author Ruan
 */
public class Cliente extends Pessoa {
    
    private String email;
    private String telefone;

    public Cliente() {
        super();
    }

    public Cliente(String email, String telefone, int codigo, int cpf, String dataNascimento, String nome) {
        super(codigo, cpf, dataNascimento, nome);
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}