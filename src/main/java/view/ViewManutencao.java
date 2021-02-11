package view;

import model.Model;

/**
 *
 * @author Ruan
 */
abstract public class ViewManutencao extends View {

    abstract public Model getModelFromDadosTela();
    
    abstract public void beanDados();
    
}