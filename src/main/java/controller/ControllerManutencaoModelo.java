package controller;

import dao.Dao;
import model.Marca;
import model.Modelo;
import view.ViewManutencaoModelo;

/**
 * @author Ruan
 */
public class ControllerManutencaoModelo extends ControllerManutencao {

    public ControllerManutencaoModelo(Controller caller) {
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
        (new Dao(Marca.class)).get().forEach((marca) -> {
            this.getView().getComboBoxMarca().addItem((Marca) marca);
        });
        this.addListenerAcoes();
    }

    @Override
    public Modelo getInstanceModel() {
        return new Modelo();
    }

    @Override
    public ViewManutencaoModelo getInstanceView() {
        return new ViewManutencaoModelo();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Modelo.class);
    }

    @Override
    public Modelo getModel() {
        return (Modelo) super.getModel();
    }

    @Override
    public ViewManutencaoModelo getView() {
        return (ViewManutencaoModelo) super.getView();
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