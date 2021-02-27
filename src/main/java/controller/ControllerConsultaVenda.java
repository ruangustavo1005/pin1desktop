package controller;

import dao.Dao;
import dao.DaoMovimento;
import javax.swing.JOptionPane;
import model.Movimento;
import model.Venda;
import view.ViewConsultaVenda;

/**
 * @author Ruan
 */
public class ControllerConsultaVenda extends ControllerConsulta {

    public ControllerConsultaVenda(Controller caller) {
        super(caller);
    }

    @Override
    public Venda getInstanceModel() {
        return new Venda();
    }

    @Override
    public ViewConsultaVenda getInstanceView() {
        return new ViewConsultaVenda();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Venda.class);
    }

    @Override
    public Venda getModel() {
        return (Venda) super.getModel();
    }

    @Override
    public ViewConsultaVenda getView() {
        return (ViewConsultaVenda) super.getView();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }
    
    private void addListenerAcoes() {
        this.addListenerInserir();
        this.addListenerExcluir();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoVenda(this)).montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Venda modelSelecionado = (Venda) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
                if (this.getDao().remove(modelSelecionado)
                 && (new DaoMovimento()).remove(modelSelecionado.getMovimento())) {
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