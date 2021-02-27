package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.ViewConsultaFuncionario;

/**
 * @author Ruan
 */
public class ControllerConsultaFuncionario extends ControllerConsulta {

    public ControllerConsultaFuncionario(Controller caller) {
        super(caller);
    }

    @Override
    public Funcionario getInstanceModel() {
        return new Funcionario();
    }

    @Override
    public ViewConsultaFuncionario getInstanceView() {
        return new ViewConsultaFuncionario();
    }

    @Override
    public ViewConsultaFuncionario getView() {
        return (ViewConsultaFuncionario) super.getView();
    }
    
    @Override
    public Dao getInstanceDao() {
        return new Dao(Funcionario.class);
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerInserir();
        this.addListenerAlterar();
        this.addListenerExcluir();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoFuncionario(this)).montaTela();
        });
    }
    
    private void addListenerAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            ControllerManutencaoFuncionario controllerManutencaoFuncionario = new ControllerManutencaoFuncionario(this);
            controllerManutencaoFuncionario.setModel((Funcionario) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow()));
            controllerManutencaoFuncionario.montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Funcionario modelSelecionado = (Funcionario) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
                if (this.getDao().remove(modelSelecionado)) {
                    this.getView().showMensagem("Registro removido com sucesso!");
                    this.getView().getTableModel().remove(modelSelecionado);
                }
                else {
                    this.getView().showMensagem("Houve um erro ao remover o registro.");
                }
            }
        });
    }
 
}