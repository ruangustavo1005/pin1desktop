/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Agendamento;
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
    public Dao getInstanceDao() {
        return new Dao(Agendamento.class);
    }

    @Override
    public ViewIndex getView() {
        return (ViewIndex) super.getView();
    }

    @Override
    public boolean processaDados() {
        return super.processaDados();
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
        this.getView().getLabelUsuarioLogado().setText(ControllerLogin.getUsuarioLogado().getNome());
    }

    @Override
    protected void onSelectRegistroConsulta() {
        int index = this.getView().getTable().getSelectedRow();
        if (index > -1 && ((Agendamento)this.getView().getTableModel().get(index)).isSituacaoAberto()) {
            super.onSelectRegistroConsulta();
        }
        else {
            this.setEnabledAcoesGrid(false);
        }
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
                    this.getView().showMensagem("Houve um erro ao cancelado o Agendamento.");
                }
            }
        });
    }
    
}
