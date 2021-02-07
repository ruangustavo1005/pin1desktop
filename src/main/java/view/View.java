package view;

import javax.swing.JFrame;
import model.Model;

/**
 * Tela base para as diversas telas do sistema
 * @author Ruan
 */
abstract public class View extends JFrame {
    
    protected Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}