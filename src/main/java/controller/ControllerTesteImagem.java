package controller;

import model.ImagemCarro;
import view.ViewTesteImagem;

/**
 *
 * @author Ruan
 */
public class ControllerTesteImagem extends ControllerManutencao {
    
    @Override
    public ImagemCarro getInstanceModel() {
        return new ImagemCarro();
    }

    @Override
    public ViewTesteImagem getInstanceView() {
        return new ViewTesteImagem();
    }

}