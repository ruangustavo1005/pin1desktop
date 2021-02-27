package controller;

import dao.Dao;
import dao.DaoMovimento;
import java.util.ArrayList;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import model.Model;
import model.Movimento;
import util.NumberUtils;
import util.StringUtils;
import view.ViewConsultaMovimento;

/**
 * @author Ruan
 */
public class ControllerConsultaMovimento extends ControllerConsulta {

    public ControllerConsultaMovimento(Controller caller) {
        super(caller);
    }

    @Override
    public Movimento getInstanceModel() {
        return new Movimento();
    }

    @Override
    public ViewConsultaMovimento getInstanceView() {
        return new ViewConsultaMovimento();
    }

    @Override
    public DaoMovimento getInstanceDao() {
        return new DaoMovimento();
    }

    @Override
    public Movimento getModel() {
        return (Movimento) super.getModel();
    }

    @Override
    public ViewConsultaMovimento getView() {
        return (ViewConsultaMovimento) super.getView();
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }

    @Override
    public boolean processaDados() {
        boolean retorno = super.processaDados();
        float totalMovimentos = 0;
        
        ArrayList<Movimento> movimentos = (ArrayList<Movimento>) this.getView().getTableModel().getModelos();
        
        for (Movimento movimento : movimentos) {
            totalMovimentos += movimento.getValor();
        }
        
        this.getView().getCampoValorTotal().setText(StringUtils.lpad(NumberUtils.formataValor(totalMovimentos, 2, true), 10));
        
        return retorno;
    }

    @Override
    public void atualizaConsulta(Model modelAtualizado) {
        super.atualizaConsulta(modelAtualizado);
        float valorAnterior = NumberUtils.parseFloat(this.getView().getCampoValorTotal().getText());
        this.getView().getCampoValorTotal().setText(StringUtils.lpad(NumberUtils.formataValor(valorAnterior + ((Movimento) modelAtualizado).getValor(), 2, true), 10));
    }
    
    private void addListenerAcoes() {
        this.addListenerInserir();
        this.addListenerExcluir();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoInserir().addActionListener((e) -> {
            (new ControllerManutencaoMovimento(this)).montaTela();
        });
    }
    
    private void addListenerExcluir() {
        this.getView().getBotaoExcluir().addActionListener((e) -> {
            if (this.getView().showDialog("Deseja excluir o registro selecionado?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Movimento modelSelecionado = (Movimento) this.getView().getTableModel().get(this.getView().getTable().getSelectedRow());
                if (this.getDao().remove(modelSelecionado)) {
                    this.getView().showMensagem("Registro removido com sucesso!");
                    this.getView().getTableModel().remove(modelSelecionado);
                    float valorAnterior = NumberUtils.parseFloat(this.getView().getCampoValorTotal().getText());
                    this.getView().getCampoValorTotal().setText(StringUtils.lpad(NumberUtils.formataValor(valorAnterior + modelSelecionado.getValor() * -1, 2, true), 10));
                }
                else {
                    this.getView().showMensagem("Houve um erro ao remover o registro.");
                }
            }
        });
    }
    
}