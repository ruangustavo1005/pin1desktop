package controller;

import dao.Dao;
import javax.swing.JOptionPane;
import model.ImagemCarro;
import model.Veiculo;
import view.ViewConsultaVeiculo;

/**
 * @author Ruan
 */
public class ControllerConsultaVeiculo extends ControllerConsulta {

    public ControllerConsultaVeiculo(Controller caller) {
        super(caller);
    }

    @Override
    public Veiculo getInstanceModel() {
        return new Veiculo();
    }

    @Override
    public ViewConsultaVeiculo getInstanceView() {
        return new ViewConsultaVeiculo();
    }

    @Override
    public Dao getInstanceDao() {
        return new Dao(Veiculo.class);
    }

    @Override
    public Veiculo getModel() {
        return (Veiculo) super.getModel();
    }

    @Override
    public ViewConsultaVeiculo getView() {
        return (ViewConsultaVeiculo) super.getView();
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
        this.addListenerGerenciarImagens();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoVeiculo(this)).montaTela();
        });
    }
    
    private void addListenerAlterar() {
        this.getView().getBotaoAlterar().addActionListener((e) -> {
            ControllerManutencaoVeiculo controllerManutencaoVeiculo = new ControllerManutencaoVeiculo(this);
            controllerManutencaoVeiculo.setModel((Veiculo) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow()));
            controllerManutencaoVeiculo.montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Veiculo modelSelecionado = (Veiculo) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
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
    
    private void addListenerGerenciarImagens() {
        this.getView().getBotaoGerenciarImagens().addActionListener((e) -> {
            ControllerConsultaImagemVeiculo controllerConsultaImagemVeiculo = new ControllerConsultaImagemVeiculo(this);
            ImagemCarro imagemCarro = new ImagemCarro();
            imagemCarro.setVeiculo((Veiculo) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow()));
            controllerConsultaImagemVeiculo.setModel(imagemCarro);
            controllerConsultaImagemVeiculo.montaTela();
        });
    }
    
}