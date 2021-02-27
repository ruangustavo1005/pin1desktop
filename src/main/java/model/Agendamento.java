package model;

import interfaces.ListagemAdicional;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import util.DateUtils;

/**
 * Modelo de um agendamento efetuado pelo site
 * @author Ruan
 */
@Entity
@Table(name = "tbagendamento")
public class Agendamento extends Model implements ListagemAdicional, ListagemMaqueada, ListagemParcial, Comparator<Agendamento> {
    
    static public int SITUACAO_ABERTO     = 1;
    static public int SITUACAO_CONFIRMADO = 2;
    static public int SITUACAO_EFETUADO   = 3;
    static public int SITUACAO_ATRASADO   = 4;
    static public int SITUACAO_CANCELADO  = 5;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agecodigo")
    private int         codigo;
    @ManyToOne
    @JoinColumn(name = "pescodigocliente")
    private Cliente     cliente;
    @Column(name = "agedatahora")
    private Date        dataHora;
    @ManyToOne
    @JoinColumn(name = "pescodigofuncionario")
    private Funcionario funcionario;
    @Column(name = "agesituacao")
    private int         situacao;
    @ManyToOne
    @JoinColumn(name = "veiplaca")
    private Veiculo     veiculo;

    public Agendamento() {
        this.cliente     = new Cliente();
        this.funcionario = new Funcionario();
        this.veiculo     = new Veiculo();
    }

    public Agendamento(Cliente cliente, int codigo, Date dataHora, Funcionario funcionario, int situacao, Veiculo veiculo) {
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
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

    public boolean isSituacaoAberto() {
        return this.getSituacao() == SITUACAO_ABERTO;
    }
    
    public boolean isSituacaoConfirmado() {
        return this.getSituacao() == SITUACAO_CONFIRMADO;
    }
    
    public boolean isSituacaoEfetuado() {
        return this.getSituacao() == SITUACAO_EFETUADO;
    }
    
    public boolean isSituacaoAtrasado() {
        return this.getSituacao() == SITUACAO_ATRASADO;
    }
    
    public boolean isSituacaoCancelado() {
        return this.getSituacao() == SITUACAO_CANCELADO;
    }
    
    public String getSituacaoConsulta() {
        HashMap<Integer, String> situacoes = new HashMap<>();
        situacoes.put(SITUACAO_ABERTO,     "Aberto");
        situacoes.put(SITUACAO_CONFIRMADO, "Confirmado");
        situacoes.put(SITUACAO_EFETUADO,   "Efetuado");
        situacoes.put(SITUACAO_ATRASADO,   "Atrasado");
        situacoes.put(SITUACAO_CANCELADO,  "Cancelado");
        return situacoes.get(this.getSituacao());
    }
    
    public String getDataHoraConsulta() {
        return DateUtils.dateHourToString(this.getDataHora());
    }
    
    @Override
    public boolean isChavePreenchida() {
        return this.getCodigo() != 0;
    }

    @Override
    public Map<String, String> getTitulosColunas() {
        HashMap<String, String> titulosColunas = new HashMap<>();
        titulosColunas.put("codigo",           "Código");
        titulosColunas.put("funcionario",      "Funcionário");
        titulosColunas.put("dataHoraConsulta", "Data/Hora");
        titulosColunas.put("situacaoConsulta", "Situação");
        return titulosColunas;
    }

    @Override
    public List<String> getCamposIgnorar() {
        List<String> campos = new ArrayList<>();
        campos.add("SITUACAO_ABERTO");
        campos.add("SITUACAO_CONFIRMADO");
        campos.add("SITUACAO_EFETUADO");
        campos.add("SITUACAO_ATRASADO");
        campos.add("SITUACAO_CANCELADO");
        campos.add("dataHora");
        campos.add("situacao");
        return campos;
    }

    @Override
    public List<String> getCamposAdicionar() {
        List<String> campos = new ArrayList<>();
        campos.add("dataHoraConsulta");
        campos.add("situacaoConsulta");
        return campos;
    }

    @Override
    public int compare(Agendamento agendamento1, Agendamento agendamento2) {
        if (agendamento1.isSituacaoAberto() || agendamento1.isSituacaoConfirmado()) {
            if (agendamento2.isSituacaoAberto() || agendamento2.isSituacaoConfirmado()) {
//              Se os dois estiverem abertos, deve vir primeiro o que tiver a menor data
                return agendamento1.getDataHora().compareTo(agendamento2.getDataHora());
            }
            else {
//              Se o agendamento 2 não estiver aberto e o agendamento 1 estiver aberto, o agendamento 1 vem primeiro
                return -1;
            }
        }
        else {
            if (agendamento2.isSituacaoAberto() || agendamento2.isSituacaoConfirmado()) {
//              Se o agendamento 1 não estiver aberto e o agendamento 2 estiver aberto, o agendamento 2 vem primeiro
                return 1;
            }
            else {
//              Se os dois não estiverem abertos, deve vir primeiro o que tiver a maior data
                return agendamento2.getDataHora().compareTo(agendamento1.getDataHora());
            }
        }
    }
    
}