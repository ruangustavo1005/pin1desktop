package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Modelo de um cliente
 * @author Ruan
 */
@Entity
public class Cliente extends Pessoa {
    
    @Column(name = "pesemail")
    private String email;
    @Column(name = "pestelefone")
    private String telefone;

    public Cliente() {
        super();
    }

    public Cliente(String email, String telefone, int codigo, String cpf, Date dataNascimento, String nome) {
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
    
    public String getTelefoneConsulta() {
        return String.format("(%s)%s-%s", this.getTelefone().substring(0, 2), this.getTelefone().substring(2, 7), this.getTelefone().substring(7, 11));
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        Map<String, String> titulosColunas = super.getTitulosColunas();
        titulosColunas.put("email",            "E-mail");
        titulosColunas.put("telefoneConsulta", "Telefone");
        return titulosColunas;
    }

    @Override
    public List<String> getCamposIgnorar() {
        List<String> campos = super.getCamposIgnorar();
        campos.add("telefone");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        List<String> campos = super.getCamposAdicionar();
        campos.add("telefoneConsulta");
        return campos;
    }
    
}