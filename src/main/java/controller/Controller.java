package controller;

/**
 * Controlador base para os outros diversos
 * @author Ruan
 * @param <TypeModel>      Tipo do modelo
 * @param <TypeView>       Tipo da tela
 */
abstract public class Controller<TypeModel, TypeView> {
    
    protected TypeModel model;
    protected TypeView  view;
    
    /**
     * Método que irá criar e setar tudo o que é necessário na View e deixá-la visível
     */
    abstract public void montaTela();

    public TypeModel getModel() {
        return model;
    }

    public void setModel(TypeModel model) {
        this.model = model;
    }

    public TypeView getView() {
        return view;
    }

}