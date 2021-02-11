package controller;

import javax.swing.event.ListSelectionListener;
import model.Model;
import view.ViewConsulta;

/**
 * Controlador base para controladores de consultas
 * @author Ruan
 */
abstract public class ControllerConsulta extends Controller {
    
    public ControllerConsulta(Controller caller) {
        super(caller);
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.setEnabledAcoesGrid(false);
        this.getView().getTable().getSelectionModel().addListSelectionListener((e) -> {
            this.onSelectRegistroConsulta();
        });
        this.processaDados();
    }

    @Override
    public ViewConsulta getView() {
        return (ViewConsulta) super.getView();
    }

    @Override
    public boolean processaDados() {
        this.getView().getTableModel().setModelos(this.getDao().get());
        this.getView().getTableModel().sort();
        return true;
    }

    protected void setEnabledAcoesGrid(boolean enabled) {
        this.getView().getAcoesGrid().forEach((botao) -> {
            botao.setEnabled(enabled);
        });
    }
    
    public void atualizaConsulta(Model modelAtualizado) {
        if (this.getView().getTableModel().getModelos().contains(modelAtualizado)) {
            this.getView().getTableModel().remove(modelAtualizado);
        }
        this.getView().getTableModel().add(modelAtualizado);
        
    }
    
    protected void onSelectRegistroConsulta() {
        this.setEnabledAcoesGrid(this.getView().getTable().getSelectedRows().length == 1);
    }
    
}