package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.Modelo;
import view.ViewConsultaModelo;

/**
 *
 * @author Ruan
 */
public class ControllerConsultaModelo extends ControllerConsulta {

    public ControllerConsultaModelo(Controller caller) {
        super(caller);
    }

    @Override
    public Modelo getInstanceModel() {
        return new Modelo();
    }

    @Override
    public ViewConsultaModelo getInstanceView() {
        return new ViewConsultaModelo();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Modelo.class);
    }

    @Override
    public Modelo getModel() {
        return (Modelo) super.getModel();
    }

    @Override
    public ViewConsultaModelo getView() {
        return (ViewConsultaModelo) super.getView();
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
            (new ControllerManutencaoModelo(this)).montaTela();
        });
    }
    
    private void addListenerAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            ControllerManutencaoModelo controllerManutencaoModelo = new ControllerManutencaoModelo(this);
            controllerManutencaoModelo.setModel((Modelo) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow()));
            controllerManutencaoModelo.montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Modelo modelSelecionado = (Modelo) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
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