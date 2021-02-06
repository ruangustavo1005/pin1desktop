package model;

/**
 * Modelo de um agendamento efetuado pelo site
 * @author Ruan
 */
public class Agendamento extends Model {
    
    private Cliente     cliente;
    private int         codigo;
    private String      dataHora;
    private Funcionario funcionario;
    private int         situacao;
    private Veiculo     veiculo;

    public Agendamento() {
        this.cliente     = new Cliente();
        this.funcionario = new Funcionario();
        this.veiculo     = new Veiculo();
    }

    public Agendamento(Cliente cliente, int codigo, String dataHora, Funcionario funcionario, int situacao, Veiculo veiculo) {
        this.cliente     = cliente;
        this.codigo      = codigo;
        this.dataHora    = dataHora;
        this.funcionario = funcionario;
        this.situacao    = situacao;
        this.veiculo     = veiculo;
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}