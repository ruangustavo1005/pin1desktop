package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import model.Funcionario;

/**
 *
 * @author Ruan
 */
public class ViewConsultaFuncionario extends ViewConsulta {

    public ViewConsultaFuncionario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoInserir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Funcionários");

        botaoInserir.setText("Inserir um novo Funcionário");

        botaoAlterar.setText("Alterar");

        botaoExcluir.setText("Excluir");

        tableFuncionarios.setModel(this.getTableModel());
        jScrollPane1.setViewportView(tableFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoInserir)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBotaoInserir() {
        return botaoInserir;
    }

    public JButton getBotaoAlterar() {
        return botaoAlterar;
    }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> acoes = new ArrayList<>();
        acoes.add(this.getBotaoAlterar());
        acoes.add(this.getBotaoExcluir());
        return acoes;
    }

    @Override
    public JTable getTable() {
        return this.tableFuncionarios;
    }

    @Override
    public Funcionario getInstanceModel() {
        return new Funcionario();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFuncionarios;
    // End of variables declaration//GEN-END:variables
}
