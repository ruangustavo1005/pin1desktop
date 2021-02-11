package model;

import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de marcas de carros
 * @author Ruan
 */
@Entity
@Table(name="tbmarca")
public class Marca extends Model implements Comparator<Marca> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marcodigo")
    private int    codigo;
    @Column(name = "marnome")
    private String nome;

    public Marca() {
        
    }

    public Marca(int codigo, String nome) {
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
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }

    @Override
    public int compare(Marca marca1, Marca marca2) {
        return marca1.getCodigo() - marca2.getCodigo();
    }

}