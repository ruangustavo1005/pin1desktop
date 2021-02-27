package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import model.Venda;

/**
 *
 * @author Ruan
 */
public class ViewConsultaVenda extends ViewConsulta {

    public ViewConsultaVenda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new javax.swing.JTable();
        botaoInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Vendas");

        botaoExcluir.setText("Excluir");

        tableVendas.setModel(this.getTableModel());
        jScrollPane1.setViewportView(tableVendas);

        botaoInserir.setText("Inserir uma nova Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExcluir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoInserir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
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
        return this.tableVendas;
    }

    @Override
    public Venda getInstanceModel() {
        return new Venda();
    }

    @Override
    public Venda getModel() {
        return (Venda) super.getModel();
    }

    public JButton getBotaoInserir() {
        return botaoInserir;
    }
    
    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVendas;
    // End of variables declaration//GEN-END:variables
}
