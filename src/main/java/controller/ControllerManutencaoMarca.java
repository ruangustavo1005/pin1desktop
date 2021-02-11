package controller;

import dao.Dao;
import model.Marca;
import view.ViewManutencaoMarca;

/**
 *
 * @author Ruan
 */
public class ControllerManutencaoMarca extends ControllerManutencao {

    public ControllerManutencaoMarca(Controller caller) {
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
    public Marca getInstanceModel() {
        return new Marca();
    }

    @Override
    public ViewManutencaoMarca getInstanceView() {
        return new ViewManutencaoMarca();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Marca.class);
    }
    
    @Override
    public ViewManutencaoMarca getView() {
        return (ViewManutencaoMarca) super.getView();
    }

    @Override
    public Marca getModel() {
        return (Marca) super.getModel();
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