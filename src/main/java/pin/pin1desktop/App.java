package pin.pin1desktop;

import controller.ControllerLogin;

/**
 * Classe main do sistema
 * Será a classe que vai chamar o processo de início do sistema.
 * @author Ruan
 */
public class App {
    
    public static void main(String[] args) {
        (new ControllerLogin(null)).montaTela();
    }
    
}