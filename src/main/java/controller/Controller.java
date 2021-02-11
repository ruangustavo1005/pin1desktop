package controller;

import dao.Dao;
import model.Model;
import view.View;

/**
 * Controlador base para os outros diversos
 * @author Ruan
 */
abstract public class Controller {
    
    protected Controller caller;
    protected Model      model;
    protected View       view;
    protected Dao        dao;

    public Controller(Controller caller) {
        this.caller = caller;
        this.model  = this.getInstanceModel();
        this.view   = this.getInstanceView();
        this.dao    = this.getInstanceDao();
    }

    abstract public boolean processaDados();
    
    abstract public Model getInstanceModel();
    
    abstract public View getInstanceView();
    
    abstract public Dao getInstanceDao();
    
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

    public Dao getDao() {
        return dao;
    }

    public Controller getCaller() {
        return caller;
    }

}