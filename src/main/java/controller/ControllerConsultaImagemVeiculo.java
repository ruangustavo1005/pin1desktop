package controller;

import dao.DaoImagemCarro;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import model.ImagemCarro;
import util.ImageUtils;
import view.ViewConsultaImagemVeiculo;

/**
 * @author Ruan
 */
public class ControllerConsultaImagemVeiculo extends ControllerConsulta {

    public ControllerConsultaImagemVeiculo(Controller caller) {
        super(caller);
    }

    @Override
    public ImagemCarro getInstanceModel() {
        return new ImagemCarro();
    }

    @Override
    public ViewConsultaImagemVeiculo getInstanceView() {
        return new ViewConsultaImagemVeiculo();
    }

    @Override
    public DaoImagemCarro getInstanceDao() {
        return new DaoImagemCarro();
    }

    @Override
    public ImagemCarro getModel() {
        return (ImagemCarro) super.getModel();
    }

    @Override
    public ViewConsultaImagemVeiculo getView() {
        return (ViewConsultaImagemVeiculo) super.getView();
    }

    @Override
    public DaoImagemCarro getDao() {
        return (DaoImagemCarro) super.getDao();
    }
    
    @Override
    public boolean processaDados() {
        this.getView().getTableModel().setModelos(this.getDao().getAllFromVeiculo(this.getModel().getVeiculo()));
        this.getView().getTableModel().sort();
        return true;
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
            ControllerManutencaoImagemVeiculo controllerManutencaoImagemVeiculo = new ControllerManutencaoImagemVeiculo(this);
            controllerManutencaoImagemVeiculo.getModel().setVeiculo(this.getModel().getVeiculo());
            controllerManutencaoImagemVeiculo.montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int indexSelecionado = this.getView().getTable().getSelectedRow();
                ImagemCarro modelSelecionado = (ImagemCarro) this.getView().getTableModel().get(indexSelecionado);
                if (this.getDao().remove(modelSelecionado)) {
                    this.getView().showMensagem("Registro removido com sucesso!");
                    this.limpaLabelVisualizacaoImagem();
                    this.getView().getTableModel().remove(indexSelecionado);
                }
                else {
                    this.getView().showMensagem("Houve um erro ao remover o registro.");
                }
            }
        });
    }

    @Override
    protected void onSelectRegistroConsulta() {
        super.onSelectRegistroConsulta();
        if (this.getView().getTable().getSelectedRows().length == 1) {
            ImagemCarro modelSelecionado = (ImagemCarro) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
            Icon icon = ImageUtils.getImageIcon(modelSelecionado.getConteudo());
            this.getView().getLabelVisualizacaoImagem().setIcon(icon);
        }
        else if (this.getView().getTable().getSelectedRows().length == 0) {
            this.limpaLabelVisualizacaoImagem();
        }
    }
 
    protected void limpaLabelVisualizacaoImagem() {
        this.getView().getLabelVisualizacaoImagem().setIcon(null);
    }
    
}