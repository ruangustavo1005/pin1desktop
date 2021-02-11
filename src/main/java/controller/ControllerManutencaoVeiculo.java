package controller;

import dao.Dao;
import model.Modelo;
import model.Veiculo;
import view.ViewManutencaoVeiculo;

/**
 * @author Ruan
 */
public class ControllerManutencaoVeiculo extends ControllerManutencao {

    public ControllerManutencaoVeiculo(Controller caller) {
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
    public void montaTela() {
        super.montaTela();
        (new Dao(Modelo.class)).get().forEach((Modelo) -> {
            this.getView().getComboBoxModelo().addItem((Modelo) Modelo);
        });
        this.addListenerAcoes();
    }

    @Override
    public Veiculo getInstanceModel() {
        return new Veiculo();
    }

    @Override
    public ViewManutencaoVeiculo getInstanceView() {
        return new ViewManutencaoVeiculo();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Veiculo.class);
    }

    @Override
    public Veiculo getModel() {
        return (Veiculo) super.getModel();
    }

    @Override
    public ViewManutencaoVeiculo getView() {
        return (ViewManutencaoVeiculo) super.getView();
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