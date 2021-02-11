package controller;

import dao.Dao;
import dao.DaoImagemCarro;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.ImagemCarro;
import util.ImageUtils;
import view.ViewManutencaoImagemVeiculo;

/**
 * @author Ruan
 */
public class ControllerManutencaoImagemVeiculo extends ControllerManutencao {

    public ControllerManutencaoImagemVeiculo(Controller caller) {
        super(caller);
    }

    @Override
    public boolean processaDados() {
        this.setModel(this.getView().getModelFromDadosTela());
        boolean retorno = this.getDao().add(this.getModel());
        if (retorno) {
            ((ControllerConsulta) this.getCaller()).atualizaConsulta(this.getModel());
        }
        return retorno;
    }

    @Override
    public ImagemCarro getInstanceModel() {
        return new ImagemCarro();
    }

    @Override
    public ViewManutencaoImagemVeiculo getInstanceView() {
        return new ViewManutencaoImagemVeiculo();
    }

    @Override
    public DaoImagemCarro getInstanceDao() {
        return new DaoImagemCarro();
    }
    
    @Override
    public ViewManutencaoImagemVeiculo getView() {
        return (ViewManutencaoImagemVeiculo) super.getView();
    }

    @Override
    public ImagemCarro getModel() {
        return (ImagemCarro) super.getModel();
    }

    @Override
    public DaoImagemCarro getDao() {
        return (DaoImagemCarro) super.getDao();
    }
    
    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
        this.getView().getModel().setVeiculo(this.getModel().getVeiculo());
    }
    
    private void addListenerAcoes() {
        this.addListenerInserir();
        this.addListenerSelecionarImagem();
        this.addListenerSair();
    }
    
    private void addListenerInserir() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            if (this.processaDados()) {
                this.getView().showMensagem("Sucesso na operacao!");
                this.getView().dispose();
            }
            else {
                this.getView().showMensagem("Houve um erro ao executar a operação, tente novamente mais tarde.");
            }
        });
    }
    
    private void addListenerSelecionarImagem() {
        this.getView().getBotaoSelecionarImagem().addActionListener((e) -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png");
            chooser.setFileFilter(filter);
            int escolha = chooser.showOpenDialog(this.getView());
            if(escolha == JFileChooser.APPROVE_OPTION) {
                try {
                    byte[] bytes = ImageUtils.getBytes(chooser.getSelectedFile());
                    this.getView().getModel().setConteudo(bytes);
                    this.getView().getLabelVisualizaçãoImagem().setIcon(ImageUtils.getImageIcon(bytes));
                }
                catch (IOException ex) {
                    this.getView().showMensagem("Houve um erro ao selecionar o arquivo, tente novamente.");
                }
            }
        });
    }
    
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            this.getView().dispose();
        });
    }
    
}