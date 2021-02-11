package controller;

import dao.Dao;
import dao.DaoLogin;
import model.Funcionario;
import view.ViewLogin;

/**
 *
 * @author Ruan
 */
public class ControllerLogin extends ControllerManutencao {

    static private Funcionario usuarioLogado;

    public ControllerLogin(Controller caller) {
        super(caller);
    }
    
    @Override
    public Funcionario getInstanceModel() {
        return new Funcionario();
    }

    @Override
    public ViewLogin getInstanceView() {
        return new ViewLogin();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }

    @Override
    public boolean processaDados() {
        boolean retorno = false;
        this.setModel(this.getView().getModelFromDadosTela());
        if (this.getModel().getLogin() != null && this.getModel().getSenha() != null) {
            retorno = this.getDao().dadosLoginCorretos(this.getModel());
            if (retorno) {
                ControllerLogin.setUsuarioLogado(this.getModel());
            }
        }
        return retorno;
    }

    private void addListenerAcoes() {
        this.addListenerEntrar();
        this.addListenerSair();
    }
    
    private void addListenerEntrar() {
        this.getView().getBotaoEntrar().addActionListener((e) -> {
            if (this.processaDados()) {
                this.getView().dispose();
                (new ControllerIndex(this)).montaTela();
            }
            else {
                this.getView().showMensagem("Dados incorretos!");
            }
        });
    }
    
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            System.exit(0);
        });
    }

    @Override
    public Funcionario getModel() {
        return (Funcionario) super.getModel();
    }

    @Override
    public ViewLogin getView() {
        return (ViewLogin) super.getView();
    }

    @Override
    public DaoLogin getDao() {
        return (DaoLogin) super.getDao();
    }

    @Override
    public DaoLogin getInstanceDao() {
        return new DaoLogin();
    }

    static public Funcionario getUsuarioLogado() {
        return ControllerLogin.usuarioLogado;
    }

    static public void setUsuarioLogado(Funcionario funcionario) {
        ControllerLogin.usuarioLogado = funcionario;
    }
    
}