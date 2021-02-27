package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Cliente;
import view.ViewConsultaCliente;

/**
 * @author Ruan
 */
public class ControllerConsultaCliente extends ControllerConsulta {

    public ControllerConsultaCliente(Controller caller) {
        super(caller);
    }

    @Override
    public Cliente getInstanceModel() {
        return new Cliente();
    }

    @Override
    public ViewConsultaCliente getInstanceView() {
        return new ViewConsultaCliente();
    }

    @Override
    public ViewConsultaCliente getView() {
        return (ViewConsultaCliente) super.getView();
    }
    
    @Override
    public Dao getInstanceDao() {
        return new Dao(Cliente.class);
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
            (new ControllerManutencaoCliente(this)).montaTela();
        });
    }
    
    private void addListenerAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            ControllerManutencaoCliente controllerManutencaoCliente = new ControllerManutencaoCliente(this);
            controllerManutencaoCliente.setModel((Cliente) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow()));
            controllerManutencaoCliente.montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Cliente modelSelecionado = (Cliente) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
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