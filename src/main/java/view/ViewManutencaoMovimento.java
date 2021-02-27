package view;

import java.util.Date;
import javax.swing.JButton;
import model.Movimento;
import util.DateUtils;
import util.Lista;
import util.NumberUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoMovimento extends ViewManutencao {

    static public int TIPO_MOVIMENTO_ENTRADA = 1;
    static public int TIPO_MOVIMENTO_SAIDA   = 2;
    
    public ViewManutencaoMovimento() {
        initComponents();
        
        this.campoTipoMovimento.addItem(new Lista(TIPO_MOVIMENTO_ENTRADA, "Entrada"));
        this.campoTipoMovimento.addItem(new Lista(TIPO_MOVIMENTO_SAIDA,   "Saída"));
        
        formataCampo(campoData,  "##/##/####", '0');
        formataCampo(campoHora,  "##:##",      '0');
        formataCampo(campoValor, "###.###,##", '0');

        campoData.setText(DateUtils.dateToString(new Date(System.currentTimeMillis())));
        campoHora.setText(DateUtils.hourToString(new Date(System.currentTimeMillis())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        botaoConfirmar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        campoTipoMovimento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoValor = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        campoData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        campoHora = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimento");

        botaoConfirmar.setText("Confirmar");

        botaoLimpar.setText("Limpar");

        botaoSair.setText("Sair");

        jLabel1.setText("Tipo:");

        jLabel2.setText("Valor:");

        jLabel3.setText("Observação:");

        jLabel4.setText("Data:");

        jLabel5.setText("Hora:");

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane1.setViewportView(campoDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTipoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoData, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                            .addComponent(campoValor))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTipoMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoSair))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Movimento getModelFromDadosTela() {
        Movimento movimento = this.getModel();
        movimento.setDataHora(DateUtils.stringToDateHour(campoData.getText() + " " + campoHora.getText()));
        movimento.setDescricao(campoDescricao.getText());
        
        float valor = NumberUtils.parseFloat(campoValor.getText());
        if (((Lista) campoTipoMovimento.getSelectedItem()).getCodigo() == TIPO_MOVIMENTO_SAIDA) {
            valor *= -1;
        }
        movimento.setValor(valor);
        
        return movimento;
    }

    @Override
    public void beanDados() {
//      Não é possível alterar os movimentos.
    }

    @Override
    public Movimento getInstanceModel() {
        return new Movimento();
    }

    @Override
    public Movimento getModel() {
        return (Movimento) super.getModel();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JFormattedTextField campoHora;
    private javax.swing.JComboBox<Lista> campoTipoMovimento;
    private javax.swing.JFormattedTextField campoValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
