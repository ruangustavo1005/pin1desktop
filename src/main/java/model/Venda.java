package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de uma venda de um veículo
 * @author Ruan
 */
@Entity
@Table(name = "tbvenda")
public class Venda extends Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vencodigo")
    private int         codigo;
    @ManyToOne
    @Column(name = "pescodigocliente")
    private Cliente     cliente;
    @Column(name = "vendata")
    private String      dataVenda;
    @Column(name = "vendesconto")
    private float       desconto;
    @ManyToOne
    @Column(name = "pescodigofuncionario")
    private Funcionario funcionario;
    @ManyToOne
    private Movimento   movimento;
    @ManyToOne
    private Veiculo     veiculo;

    public Venda() {
        this.cliente     = new Cliente();
        this.funcionario = new Funcionario();
        this.movimento   = new Movimento();
        this.veiculo     = new Veiculo();
    }

    public Venda(Cliente cliente, int codigo, String dataVenda, float desconto, Funcionario funcionario, Movimento movimento, Veiculo veiculo) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.dataVenda = dataVenda;
        this.desconto = desconto;
        this.funcionario = funcionario;
        this.movimento = movimento;
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}