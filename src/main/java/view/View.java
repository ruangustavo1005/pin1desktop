package view;

import javax.swing.JFrame;
import model.Model;

/**
 * Tela base para as diversas telas do sistema
 * @author Ruan
 */
abstract public class View extends JFrame implements Runnable {
    
    protected Model $model;
    
}