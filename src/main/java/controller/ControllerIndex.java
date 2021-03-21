package controller;

import dao.DaoAgendamento;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Agendamento;
import util.DateUtils;
import view.ViewIndex;

/**
 *
 * @author Ruan
 */
public class ControllerIndex extends ControllerConsulta {

    public ControllerIndex(Controller caller) {
        super(caller);
    }

    @Override
    public Agendamento getInstanceModel() {
        return new Agendamento();
    }

    @Override
    public ViewIndex getInstanceView() {
        return new ViewIndex();
    }

    @Override
    public DaoAgendamento getInstanceDao() {
        return new DaoAgendamento();
    }

    @Override
    public DaoAgendamento getDao() {
        return (DaoAgendamento) super.getDao();
    }
    
    @Override
    public ViewIndex getView() {
        return (ViewIndex) super.getView();
    }

    @Override
    public boolean processaDados() {
        this.atrasaAgendamentosAtrasados();
        return super.processaDados();
    }
    
    private void atrasaAgendamentosAtrasados() {
        ArrayList<Agendamento> agendamentosAtrasados = this.getDao().buscaAgendamentosAtrasados();
        
        agendamentosAtrasados.forEach((agendamento) -> {
            agendamento.setSituacao(Agendamento.SITUACAO_ATRASADO);
            this.getDao().update(agendamento);
        });
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
        this.getView().getLabelUsuarioLogado().setText(ControllerLogin.getUsuarioLogado().getNome());
    }

    @Override
    protected void setEnabledAcoesGrid(boolean enabled) {
        super.setEnabledAcoesGrid(enabled);
        
        if (enabled) {
            Agendamento agendamento = (Agendamento) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
            JButton botaoCancelarAgendamento  = this.getView().getBotaoCancelarAgendamento();
            JButton botaoEfetuarAgendamento   = this.getView().getBotaoEfetuarAgendamento();
            JButton botaoConfirmarAgendamento = this.getView().getBotaoConfirmarAgendamento();
            
            if (agendamento.isSituacaoAberto()) {
                botaoCancelarAgendamento.setEnabled(true);
                botaoEfetuarAgendamento.setEnabled(true);
                botaoConfirmarAgendamento.setEnabled(true);
            }
            else if (agendamento.isSituacaoAtrasado()) {
                botaoCancelarAgendamento.setEnabled(true);
                botaoEfetuarAgendamento.setEnabled(true);
                botaoConfirmarAgendamento.setEnabled(false);
            }
            else if (agendamento.isSituacaoCancelado()) {
                botaoCancelarAgendamento.setEnabled(false);
                botaoEfetuarAgendamento.setEnabled(false);
                botaoConfirmarAgendamento.setEnabled(false);
            }
            else if (agendamento.isSituacaoConfirmado()) {
                botaoCancelarAgendamento.setEnabled(true);
                botaoEfetuarAgendamento.setEnabled(true);
                botaoConfirmarAgendamento.setEnabled(false);
            }
            else if (agendamento.isSituacaoEfetuado()) {
                botaoCancelarAgendamento.setEnabled(false);
                botaoEfetuarAgendamento.setEnabled(false);
                botaoConfirmarAgendamento.setEnabled(false);
            }
        }
    }
    
    private boolean enviaEmailConfirmacaoAgendamento(Agendamento agendamento) {
        ControllerEmail controllerEmail = new ControllerEmail(this);
        controllerEmail.setDestinatarios(agendamento.getCliente().getEmail());
        controllerEmail.setTitulo("Olá, seu agendamento foi confirmado!");
        controllerEmail.setConteudo("Seu agendamento para o dia/hora " + DateUtils.dateHourToString(agendamento.getDataHora()) + " para o veículo " + agendamento.getVeiculo() + " foi confirmado por um de nossos gerentes!\n\n"
                                  + "Compareça à concessionária na data e hora para ser atendido(a)!\n\n"
                                  + "Agradeçemos à preferência!");
        
        return controllerEmail.processaDados();
    }
    
    private void addListenerAcoes() {
        this.addListenerMenuConsultarMarcas();
        this.addListenerMenuConsultarModelos();
        this.addListenerMenuConsultarVeiculos();
        this.addListenerMenuConsultarClientes();
        this.addListenerMenuConsultarFuncionarios();
        this.addListenerMenuConsultarMovimentos();
        this.addListenerMenuConsultarVendas();
        this.addListenerBotaoLogout();
        this.addListenerBotaoEfetuarAgendamento();
        this.addListenerBotaoCancelarAgendamento();
        this.addListenerBotaoConfirmarAgendamento();
    }
    
    private void addListenerMenuConsultarMarcas() {
        this.getView().getMenuConsultarMarcas().addActionListener((e) -> {
            (new ControllerConsultaMarcas(this)).montaTela();
        });
    }
    
    private void addListenerMenuConsultarModelos() {
        this.getView().getMenuConsultarModelos().addActionListener((e) -> {
            (new ControllerConsultaModelo(this)).montaTela();
        });
    }
    
    private void addListenerMenuConsultarVeiculos() {
        this.getView().getMenuConsultarVeiculos().addActionListener((e) -> {
            (new ControllerConsultaVeiculo(this)).montaTela();
        });
    }
    
    private void addListenerMenuConsultarClientes() {
        this.getView().getMenuConsultarClientes().addActionListener((e) -> {
            (new ControllerConsultaCliente(this)).montaTela();
        });
    }
    
    private void addListenerMenuConsultarFuncionarios() {
        this.getView().getMenuConsultarFuncionarios().addActionListener((e) -> {
            (new ControllerConsultaFuncionario(this)).montaTela();
        });
    }
    
    private void addListenerMenuConsultarMovimentos() {
        this.getView().getMenuConsultarMovimentos().addActionListener((e) -> {
            (new ControllerConsultaMovimento(this)).montaTela();
        });
    }
    
    private void addListenerMenuConsultarVendas() {
        this.getView().getMenuConsultarVendas().addActionListener((e) -> {
            (new ControllerConsultaVenda(this)).montaTela();
        });
    }
    
    private void addListenerBotaoLogout() {
        this.getView().getBotaoLogout().addActionListener((e) -> {
            ControllerLogin.setUsuarioLogado(null);
            this.getView().dispose();
            (new ControllerLogin(this)).montaTela();
        });
    }
    
    private void addListenerBotaoEfetuarAgendamento() {
        this.getView().getBotaoEfetuarAgendamento().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja efetuar o Agendamento selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Agendamento modelSelecionado = (Agendamento) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
                modelSelecionado.setSituacao(Agendamento.SITUACAO_EFETUADO);
                
                if (this.getDao().update(modelSelecionado)) {
                    this.atualizaConsulta(modelSelecionado);
                    
                    if (this.getView().showDialog("Agendamento efetuado com sucesso!\n\n"
                                                + "O Agendamento gerou uma venda?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ControllerManutencaoVenda controllerManutencaoVenda = new ControllerManutencaoVenda(this);
                        
                        controllerManutencaoVenda.getModel().setCliente(modelSelecionado.getCliente());
                        controllerManutencaoVenda.getModel().setFuncionario(modelSelecionado.getFuncionario());
                        controllerManutencaoVenda.getModel().setVeiculo(modelSelecionado.getVeiculo());
                        
                        controllerManutencaoVenda.montaTela();
                    }
                }
                else {
                    this.getView().showMensagem("Houve um erro ao efetuar o Agendamento.");
                }
            }
        });
    }
    
    private void addListenerBotaoCancelarAgendamento() {
        this.getView().getBotaoCancelarAgendamento().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja cancelar o Agendamento selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Agendamento modelSelecionado = (Agendamento) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
                modelSelecionado.setSituacao(Agendamento.SITUACAO_CANCELADO);
                
                if (this.getDao().update(modelSelecionado)) {
                    this.getView().showMensagem("Agendamento cancelado com sucesso!");
                    this.atualizaConsulta(modelSelecionado);
                }
                else {
                    this.getView().showMensagem("Houve um erro ao cancelar o Agendamento.");
                }
            }
        });
    }
    
    private void addListenerBotaoConfirmarAgendamento() {
        this.getView().getBotaoConfirmarAgendamento().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja confirmar o Agendamento selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Agendamento modelSelecionado = (Agendamento) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
                modelSelecionado.setSituacao(Agendamento.SITUACAO_CONFIRMADO);
                
                if (this.getDao().update(modelSelecionado)
                 && this.enviaEmailConfirmacaoAgendamento(modelSelecionado)) {
                    this.getView().showMensagem("Agendamento confirmado com sucesso!");
                    this.atualizaConsulta(modelSelecionado);
                }
                else {
                    this.getView().showMensagem("Houve um erro ao confirmar o Agendamento.");
                }
            }
        });
    }
    
}
