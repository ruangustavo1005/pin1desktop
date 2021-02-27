package controller;

import dao.Dao;
import model.Funcionario;
import util.MD5;
import view.ViewManutencaoFuncionario;

/**
 * @author Ruan
 */
public class ControllerManutencaoFuncionario extends ControllerManutencao {

    public ControllerManutencaoFuncionario(Controller caller) {
        super(caller);
    }

    @Override
    public boolean processaDados() {
        boolean retorno;
        if (this.getModel().isChavePreenchida()) {
            retorno = this.getDao().update(this.getModel());
        }
        else {
            retorno = this.getDao().add(this.getModel());
        }
        if (retorno) {
            ((ControllerConsulta) this.getCaller()).atualizaConsulta(this.getModel());
        }
        return retorno;
    }

    private boolean validaDados() {
        boolean retorno;
        if (this.getModel().isChavePreenchida()) {
            retorno = this.validaDadosAlteracao();
        }
        else {
            retorno = this.validaDadosInclusao();
        }
        return retorno;
    }
    
    private boolean validaDadosInclusao() {
        boolean retorno = false;
        if (MD5.md5(this.getView().getCampoSenha().getPassword()).equals(MD5.md5(this.getView().getCampoConfirmaSenha().getPassword()))) {
            retorno = true;
        }
        if (!retorno) {
            this.getView().showMensagem("As senhas não são iguais! Verifique!");
        }
        return retorno;
    }

    private boolean validaDadosAlteracao() {
        boolean retorno = false;
        if (this.validaDadosInclusao()) {
            if (MD5.md5(this.getView().getCampoSenhaAnterior().getPassword()).equals(this.getModel().getSenha())) {
                retorno = true;
            }
        }
        if (!retorno) {
            this.getView().showMensagem("A senha anterior está incorreta! Verifique!");
        }
        return retorno;
    }
    
    @Override
    public Funcionario getInstanceModel() {
        return new Funcionario();
    }

    @Override
    public ViewManutencaoFuncionario getInstanceView() {
        return new ViewManutencaoFuncionario();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Funcionario.class);
    }

    @Override
    public ViewManutencaoFuncionario getView() {
        return (ViewManutencaoFuncionario) super.getView();
    }

    @Override
    public Funcionario getModel() {
        return (Funcionario) super.getModel();
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerInserir();
        this.addListenerLimpar();
        this.addListenerSair();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            this.setModel(this.getView().getModelFromDadosTela());
            if (this.validaDados()) {
                if (this.processaDados()) {
                    this.getView().showMensagem("Sucesso na operacao!");
                    this.getView().dispose();
                }
                else {
                    this.getView().showMensagem("Houve um erro ao executar a operação, tente novamente mais tarde.");
                }
            }
        });
    }
    
    private void addListenerLimpar() {
        this.getView().getBotaoLimpar().addActionListener((e) -> {
            this.getView().clearAll();
        });
    }
                
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            this.getView().dispose();
        });
    }
    
}