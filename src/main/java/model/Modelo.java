package model;

import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de um determinado veículo
 * @author Ruan
 */
@Entity
@Table(name = "tbmodelo")
public class Modelo extends Model implements Comparator<Modelo> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modcodigo")
    private int    codigo;
    @Column(name = "modano")
    private int    ano;
    @ManyToOne
    @JoinColumn(name = "marcodigo")
    private Marca  marca;
    @Column(name = "modnome")
    private String nome;

    public Modelo() {
        this.marca = new Marca();
    }

    public Modelo(int ano, int codigo, Marca marca, String nome) {
        this.ano = ano;
        this.codigo = codigo;
        this.marca = marca;
        this.nome = nome;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return marca.getNome() + " " + nome + " " + ano;
    }

    @Override
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }

    @Override
    public int compare(Modelo modelo1, Modelo modelo2) {
        return modelo1.getCodigo() - modelo2.getCodigo();
    }

    @Override
    public boolean equals(Object obj) {
        return this.compare(this, (Modelo) obj) == 0;
    }
    
}