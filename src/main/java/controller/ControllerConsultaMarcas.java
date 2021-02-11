package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Marca;
import view.ViewConsultaMarca;

/**
 *
 * @author Ruan
 */
public class ControllerConsultaMarcas extends ControllerConsulta {

    public ControllerConsultaMarcas(Controller caller) {
        super(caller);
    }

    @Override
    public Marca getInstanceModel() {
        return new Marca();
    }

    @Override
    public ViewConsultaMarca getInstanceView() {
        return new ViewConsultaMarca();
    }

    @Override
    public ViewConsultaMarca getView() {
        return (ViewConsultaMarca) super.getView();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Marca.class);
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
            (new ControllerManutencaoMarca(this)).montaTela();
        });
    }
    
    private void addListenerAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            ControllerManutencaoMarca controllerManutencaoMarcas = new ControllerManutencaoMarca(this);
            controllerManutencaoMarcas.setModel((Marca) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow()));
            controllerManutencaoMarcas.montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Marca modelSelecionado = (Marca) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
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