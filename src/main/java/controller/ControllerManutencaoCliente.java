package controller;

import dao.Dao;
import model.Cliente;
import view.ViewManutencaoCliente;

/**
 * @author Ruan
 */
public class ControllerManutencaoCliente extends ControllerManutencao {

    public ControllerManutencaoCliente(Controller caller) {
        super(caller);
    }

    @Override
    public boolean processaDados() {
        boolean retorno;
        this.setModel(this.getView().getModelFromDadosTela());
        if (this.getModel().isChavePreenchida()) {
            retorno = this.getDao().update(this.getModel());
        }
        else {
            retorno = this.getDao().add(this.getModel());
        }
        if (retorno) {
            ((ControllerConsulta) this.getCaller()).atualizaConsulta(this.getModel());
        }
        return retorno;
    }

    @Override
    public Cliente getInstanceModel() {
        return new Cliente();
    }

    @Override
    public ViewManutencaoCliente getInstanceView() {
        return new ViewManutencaoCliente();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Cliente.class);
    }

    @Override
    public ViewManutencaoCliente getView() {
        return (ViewManutencaoCliente) super.getView();
    }

    @Override
    public Cliente getModel() {
        return (Cliente) super.getModel();
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerInserir();
        this.addListenerLimpar();
        this.addListenerSair();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            if (this.processaDados()) {
                this.getView().showMensagem("Sucesso na operacao!");
                this.getView().dispose();
            }
            else {
                this.getView().showMensagem("Houve um erro ao executar a operação, tente novamente mais tarde.");
            }
        });
    }
    
    private void addListenerLimpar() {
        this.getView().getBotaoLimpar().addActionListener((e) -> {
            this.getView().clearAll();
        });
    }
                
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            this.getView().dispose();
        });
    }
    
}