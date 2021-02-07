package controller;

import model.Model;
import view.View;

/**
 * Controlador base para os outros diversos
 * @author Ruan
 */
abstract public class Controller {
    
    protected Model model;
    protected View  view;

    public Controller() {
        this.model = this.getInstanceModel();
        this.view  = this.getInstanceView();
    }

    abstract public Model getInstanceModel();
    
    abstract public View getInstanceView();
    
    public void montaTela() {
        this.getView().setVisible(true);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

}