package view;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import model.Venda;
import model.Veiculo;
import model.Cliente;
import model.Funcionario;
import model.Movimento;
import util.DateUtils;
import util.NumberUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoVenda extends ViewManutencao {

    public ViewManutencaoVenda() {
        initComponents();
        formataCampo(campoData,       "##/##/####", '0');
        formataCampo(campoValorFinal, "###.###,##", '0');
        
        campoData.setText(DateUtils.dateToString(new Date(System.currentTimeMillis())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoConfirmar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoVeiculo = new javax.swing.JComboBox<>();
        campoFuncionario = new javax.swing.JComboBox<>();
        campoCliente = new javax.swing.JComboBox<>();
        campoData = new javax.swing.JFormattedTextField();
        campoValorFinal = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");

        botaoConfirmar.setText("Confirmar");

        botaoLimpar.setText("Limpar");

        botaoSair.setText("Sair");

        jLabel1.setText("Veículo:");

        jLabel2.setText("Funcionário:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Data:");

        jLabel5.setText("Valor Final:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoSair)
                    .addComponent(botaoLimpar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Venda getModelFromDadosTela() {
        Venda venda = this.getModel();
        venda.setVeiculo((Veiculo) campoVeiculo.getSelectedItem());
        venda.setFuncionario((Funcionario) campoFuncionario.getSelectedItem());
        venda.setCliente((Cliente) campoCliente.getSelectedItem());
        venda.setDataVenda(DateUtils.stringToDate(campoData.getText()));
        
        Movimento movimento = venda.getMovimento();
        movimento.setValor(NumberUtils.parseFloat(campoValorFinal.getText()));
        movimento.setDataHora(DateUtils.stringToDate(campoData.getText()));
        movimento.setDescricao("Venda do veículo " + venda.getVeiculo().getModelo().getNome() + " (" + venda.getVeiculo().getPlaca() + ")");
        
        return venda;
    }

    @Override
    public void beanDados() {
        campoCliente.setSelectedItem(this.getModel().getCliente());
        campoFuncionario.setSelectedItem(this.getModel().getFuncionario());
        campoVeiculo.setSelectedItem(this.getModel().getVeiculo());
    }

    @Override
    public Venda getInstanceModel() {
        return new Venda();
    }

    @Override
    public Venda getModel() {
        return (Venda) super.getModel();
    }

    public JButton getBotaoConfirmar() {
        return botaoConfirmar;
    }

    public JButton getBotaoLimpar() {
        return botaoLimpar;
    }

    public JButton getBotaoSair() {
        return botaoSair;
    }

    public JComboBox<Cliente> getCampoCliente() {
        return campoCliente;
    }

    public JComboBox<Funcionario> getCampoFuncionario() {
        return campoFuncionario;
    }

    public JComboBox<Veiculo> getCampoVeiculo() {
        return campoVeiculo;
    }

    public JFormattedTextField getCampoValorFinal() {
        return campoValorFinal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JComboBox<Cliente> campoCliente;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JComboBox<Funcionario> campoFuncionario;
    private javax.swing.JFormattedTextField campoValorFinal;
    private javax.swing.JComboBox<Veiculo> campoVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
