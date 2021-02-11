package model;

import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
public class ImagemCarro extends Model implements Comparator<ImagemCarro>, ListagemParcial {
    
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

    @Override
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }

    @Override
    public int compare(ImagemCarro imagemCarro1, ImagemCarro imagemCarro2) {
        return imagemCarro1.getCodigo() - imagemCarro2.getCodigo();
    }

    @Override
    public List<String> getCamposIgnorar() {
        ArrayList<String> campos = new ArrayList<>();
        campos.add("conteudo");
        return campos;
    }
    
}