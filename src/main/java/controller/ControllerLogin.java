package controller;

import model.Funcionario;
import model.Model;
import view.View;
import view.ViewLogin;

/**
 *
 * @author Ruan
 */
public class ControllerLogin extends ControllerManutencao {

    @Override
    public Model getInstanceModel() {
        return new Funcionario();
    }

    @Override
    public View getInstanceView() {
        return new ViewLogin();
    }
    
}