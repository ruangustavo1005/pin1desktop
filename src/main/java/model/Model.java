package model;

import java.io.Serializable;

/**
 * Modelo base para outros modelos do sistema
 * @author Ruan
 */
abstract public class Model implements Serializable {
    
    abstract public boolean isChavePreenchida();
    
}