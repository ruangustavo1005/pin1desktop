package controller;

import dao.Dao;
import dao.DaoMovimento;
import model.Cliente;
import model.Funcionario;
import model.Movimento;
import model.Veiculo;
import model.Venda;
import util.NumberUtils;
import util.StringUtils;
import view.ViewManutencaoVenda;

/**
 * @author Ruan
 */
public class ControllerManutencaoVenda extends ControllerManutencao {

    public ControllerManutencaoVenda(Controller caller) {
        super(caller);
    }

    @Override
    public boolean processaDados() {
        this.setModel(this.getView().getModelFromDadosTela());
        boolean retorno = (new DaoMovimento()).add(this.getModel().getMovimento());
        if (retorno) {
            retorno = this.getDao().add(this.getModel());
        }
        return retorno;
    }

    @Override
    public void montaTela() {
        super.montaTela();
        this.addListenerAcoes();
    }

    @Override
    protected void beanDadosTela() {
        (new Dao<>(Veiculo.class)).get().forEach((veiculo) -> {
            this.getView().getCampoVeiculo().addItem(veiculo);
        });
        (new Dao<>(Funcionario.class)).get().forEach((funcionario) -> {
            this.getView().getCampoFuncionario().addItem(funcionario);
        });
        (new Dao<>(Cliente.class)).get().forEach((cliente) -> {
            this.getView().getCampoCliente().addItem(cliente);
        });
        
        this.getView().getCampoVeiculo().addItemListener((e) -> {
            this.getView().getCampoValorFinal().setText(StringUtils.lpad(NumberUtils.formataValor(((Veiculo) e.getItem()).getPreco(), 2, true), 10));
        });
        
        this.getView().getCampoValorFinal().setText(StringUtils.lpad(NumberUtils.formataValor(this.getView().getCampoVeiculo().getItemAt(0).getPreco(), 2, true), 10));
        
        if (this.getCaller() instanceof ControllerIndex) {
            this.getView().setModel(this.getModel());
            this.getView().beanDados();
        }
    }
    
    @Override
    public Venda getInstanceModel() {
        return new Venda();
    }

    @Override
    public ViewManutencaoVenda getInstanceView() {
        return new ViewManutencaoVenda();
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
    public ViewManutencaoVenda getView() {
        return (ViewManutencaoVenda) super.getView();
    }
    
    private void addListenerAcoes() {
        this.addListenerConfirmar();
        this.addListenerLimpar();
        this.addListenerSair();
    }
    
    private void addListenerConfirmar() {
        this.getView().getBotaoConfirmar().addActionListener((e) -> {
            if (this.processaDados()) {
                this.getView().showMensagem("Sucesso na operação!");
                this.getView().dispose();
            }
            else {
                this.getView().showMensagem("Houve um erro ao executar a operação, tente novamente mais tarde.");
            }
        });
    }
    
    private void addListenerLimpar() {
        this.getView().getBotaoLimpar().addActionListener((e) -> {
            this.getView().clearAll();
        });
    }
                
    private void addListenerSair() {
        this.getView().getBotaoSair().addActionListener((e) -> {
            this.getView().dispose();
        });
    }
    
}