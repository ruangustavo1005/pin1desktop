package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Modelo;
import model.Veiculo;
import util.NumberUtils;
import util.StringUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoVeiculo extends ViewManutencao {

    public ViewManutencaoVeiculo() {
        initComponents();
        formataCampo(this.campoAnoFabricacao, "####",       '0');
        formataCampo(this.campoPlaca,         "UUU#A##",    '0');
        formataCampo(this.campoQuilometragem, "###.###",    '0');
        formataCampo(this.campoValor,         "###.###,##", '0');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboBoxModelo = new javax.swing.JComboBox<>();
        botaoConfirmar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Quilometragem = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JFormattedTextField();
        campoAnoFabricacao = new javax.swing.JFormattedTextField();
        campoCor = new javax.swing.JFormattedTextField();
        campoValor = new javax.swing.JFormattedTextField();
        campoQuilometragem = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObservacao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veículo");
        setResizable(false);

        jLabel1.setText("Modelo:");

        botaoConfirmar.setText("Confirmar");

        botaoLimpar.setText("Limpar");

        botaoSair.setText("Sair");

        jLabel2.setText("Placa:");

        jLabel3.setText("Ano de Fabricação:");

        jLabel4.setText("Cor:");

        jLabel5.setText("Valor:");

        Quilometragem.setText("Quilometragem:");

        jLabel6.setText("Observação:");

        campoObservacao.setColumns(20);
        campoObservacao.setRows(5);
        jScrollPane1.setViewportView(campoObservacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)
                                        .addComponent(campoAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 108, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(Quilometragem)
                            .addComponent(jLabel6))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoQuilometragem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quilometragem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    public Veiculo getModelFromDadosTela() {
        Veiculo veiculo = this.getModel();
        veiculo.setAnoFabricacao(NumberUtils.parseInt(this.campoAnoFabricacao.getText()));
        veiculo.setCor(this.campoCor.getText());
        veiculo.setModelo((Modelo) this.comboBoxModelo.getSelectedItem());
        veiculo.setObservacao(this.campoObservacao.getText());
        veiculo.setPlaca(this.campoPlaca.getText());
        veiculo.setPreco(NumberUtils.parseFloat(this.campoValor.getText()));
        veiculo.setQuilometragem(NumberUtils.parseInt(this.campoQuilometragem.getText()));
        veiculo.setSituacao(Veiculo.SITUACAO_DISPONIVEL);
        return veiculo;
    }

    @Override
    public void beanDados() {
        this.campoAnoFabricacao.setText(String.valueOf(this.getModel().getAnoFabricacao()));
        this.campoCor.setText(this.getModel().getCor());
        this.comboBoxModelo.setSelectedItem(this.getModel().getModelo());
        this.campoObservacao.setText(this.getModel().getObservacao());
        this.campoPlaca.setText(this.getModel().getPlaca());
        this.campoValor.setText(StringUtils.lpad(NumberUtils.formataValor(this.getModel().getPreco(), 2, true), 10));
        this.campoQuilometragem.setText(StringUtils.lpad(NumberUtils.formataValor(this.getModel().getQuilometragem(), 0, true), 7));
        if (this.getModel().isChavePreenchida()) {
            this.campoPlaca.setEnabled(false);
        }
    }

    @Override
    public Veiculo getInstanceModel() {
        return new Veiculo();
    }

    @Override
    public Veiculo getModel() {
        return (Veiculo) super.getModel();
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

    public JComboBox<Modelo> getComboBoxModelo() {
        return comboBoxModelo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quilometragem;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JFormattedTextField campoAnoFabricacao;
    private javax.swing.JFormattedTextField campoCor;
    private javax.swing.JTextArea campoObservacao;
    private javax.swing.JFormattedTextField campoPlaca;
    private javax.swing.JFormattedTextField campoQuilometragem;
    private javax.swing.JFormattedTextField campoValor;
    private javax.swing.JComboBox<Modelo> comboBoxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
