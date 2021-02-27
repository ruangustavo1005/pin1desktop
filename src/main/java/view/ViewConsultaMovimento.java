package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import model.Movimento;

/**
 *
 * @author Ruan
 */
public class ViewConsultaMovimento extends ViewConsulta {

    /**
     * Creates new form ViewConsultaMovimento
     */
    public ViewConsultaMovimento() {
        initComponents();
        formataCampo(campoValorTotal, "###.###,##", '0');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoInserir = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMovimentos = new javax.swing.JTable();
        campoValorTotal = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consuta de Movimentos");

        botaoInserir.setText("Inserir um novo Movimento");

        botaoExcluir.setText("Excluir");

        tableMovimentos.setModel(this.getTableModel());
        jScrollPane1.setViewportView(tableMovimentos);

        jLabel2.setText("Total em caixa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addGap(345, 345, 345)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(botaoExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> acoes = new ArrayList<>();
        acoes.add(this.getBotaoExcluir());
        return acoes;
    }

    @Override
    public JTable getTable() {
        return this.tableMovimentos;
    }

    @Override
    public Movimento getInstanceModel() {
        return new Movimento();
    }

    @Override
    public Movimento getModel() {
        return (Movimento) super.getModel();
    }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    public JButton getBotaoInserir() {
        return botaoInserir;
    }

    public JFormattedTextField getCampoValorTotal() {
        return campoValorTotal;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JFormattedTextField campoValorTotal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMovimentos;
    // End of variables declaration//GEN-END:variables
}
