/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dao;
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
    public boolean processaDados() {
        return true;
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
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerMenuConsultarMarcas();
        this.addListenerMenuConsultarModelos();
        this.addListenerMenuConsultarVeiculos();
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
    
}
