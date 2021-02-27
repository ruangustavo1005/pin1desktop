package controller;

import dao.Dao;
import dao.DaoMovimento;
import model.Movimento;
import view.ViewManutencaoMovimento;

/**
 * @author Ruan
 */
public class ControllerManutencaoMovimento extends ControllerManutencao {

    public ControllerManutencaoMovimento(Controller caller) {
        super(caller);
    }

    @Override
    public boolean processaDados() {
        this.setModel(this.getView().getModelFromDadosTela());
        boolean retorno = this.getDao().add(this.getModel());
        if (retorno) {
            ((ControllerConsulta) this.getCaller()).atualizaConsulta(this.getModel());
        }
        return retorno;
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }

    @Override
    public Movimento getInstanceModel() {
        return new Movimento();
    }

    @Override
    public ViewManutencaoMovimento getInstanceView() {
        return new ViewManutencaoMovimento();
    }

    @Override
    public DaoMovimento getInstanceDao() {
        return new DaoMovimento();
    }

    @Override
    public Movimento getModel() {
        return (Movimento) super.getModel();
    }

    @Override
    public ViewManutencaoMovimento getView() {
        return (ViewManutencaoMovimento) super.getView();
    }
    
    private void addListenerAcoes() {
        this.addListenerConfirmar();
        this.addListenerLimpar();
        this.addListenerSair();
    }
    
    private void addListenerConfirmar() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            if (this.processaDados()) {
                this.getView().showMensagem("Sucesso na operação!");
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