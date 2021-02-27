package model;

import com.sun.javafx.binding.StringFormatter;
import interfaces.ListagemAdicional;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import util.DateUtils;

/**
 * Modelo de determinada pessoa
 * @author Ruan
 */
@Entity
@Table(name = "tbpessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class Pessoa extends Model implements ListagemMaqueada, ListagemParcial, ListagemAdicional {
    
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

    public String getCpfConsulta() {
        return String.format("%s.%s.%s-%s", this.getCpf().substring(0, 3), this.getCpf().substring(3, 6), this.getCpf().substring(6, 9), this.getCpf().substring(9, 11));
    }
    
    public String getDataNascimentoConsulta() {
        return DateUtils.dateToString(this.getDataNascimento());
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    @Override
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulosColunas = new HashMap<>();
        titulosColunas.put("codigo",                 "Código");
        titulosColunas.put("cpfConsulta",            "CPF");
        titulosColunas.put("dataNascimentoConsulta", "Data de Nasc.");
        return titulosColunas;
    }

    @Override
    public List<String> getCamposIgnorar() {
        List<String> campos = new ArrayList<>();
        campos.add("cpf");
        campos.add("dataNascimento");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        List<String> campos = new ArrayList<>();
        campos.add("cpfConsulta");
        campos.add("dataNascimentoConsulta");
        return campos;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCodigo() == ((Pessoa) obj).getCodigo();
    }
    
}