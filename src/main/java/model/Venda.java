package model;

/**
 * Modelo de uma venda de um veículo
 * @author Ruan
 */
public class Venda extends Model {
    
    private Cliente     cliente;
    private int         codigo;
    private String      dataVenda;
    private float       desconto;
    private Funcionario funcionario;
    private Movimento   movimento;
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