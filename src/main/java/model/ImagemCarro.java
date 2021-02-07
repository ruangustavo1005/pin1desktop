package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo para cada imagem de determinado veículo/carro
 * @author Ruan
 */
@Entity
@Table(name = "tbfotoveiculo")
public class ImagemCarro extends Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ftvcodigo")
    private int    codigo;
    @Column(name = "ftvconteudo")
    private byte[] conteudo;
    @ManyToOne
    @JoinColumn(name = "veiplaca")
    private Veiculo veiculo;

    public ImagemCarro() {
        this.veiculo = new Veiculo();
    }

    public ImagemCarro(int codigo, byte[] conteudo, Veiculo veiculo) {
        this.codigo = codigo;
        this.conteudo = conteudo;
        this.veiculo = veiculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
   
}