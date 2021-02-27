package controller;

import view.ViewManutencao;

/**
 * Controlador base para controladores de manutenção
 * @author Ruan
 */
abstract public class ControllerManutencao extends Controller {
    
    public ControllerManutencao(Controller caller) {
        super(caller);
    }

    @Override
    public ViewManutencao getView() {
        return (ViewManutencao) super.getView();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.beanDadosTela();
    }
    
    protected void beanDadosTela() {
        if (this.getModel().isChavePreenchida()) {
            this.getView().setModel(this.getModel());
            this.getView().beanDados();
        }
    }
    
}