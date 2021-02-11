package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import model.Agendamento;
import model.Model;

/**
 *
 * @author Ruan
 */
public class ViewIndex extends ViewConsulta {

    public ViewIndex() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAgendamentos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMarcas = new javax.swing.JMenuItem();
        menuModelos = new javax.swing.JMenuItem();
        menuVeiculos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fusuan Motors Internal System");

        tableAgendamentos.setModel(this.getTableModel());
        jScrollPane1.setViewportView(tableAgendamentos);

        jMenu1.setText("Gerenciamento");

        menuMarcas.setText("Marcas");
        jMenu1.add(menuMarcas);

        menuModelos.setText("Modelos");
        jMenu1.add(menuModelos);

        menuVeiculos.setText("Veículos");
        jMenu1.add(menuVeiculos);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Model getInstanceModel() {
        return new Agendamento();
    }

    public JMenuItem getMenuConsultarMarcas() {
        return menuMarcas;
    }

    public JMenuItem getMenuConsultarModelos() {
        return menuModelos;
    }
    
    public JMenuItem getMenuConsultarVeiculos() {
        return menuVeiculos;
    }

    @Override
    public JTable getTable() {
        return tableAgendamentos;
    }

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> acoes = new ArrayList<>();
        return acoes;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuMarcas;
    private javax.swing.JMenuItem menuModelos;
    private javax.swing.JMenuItem menuVeiculos;
    private javax.swing.JTable tableAgendamentos;
    // End of variables declaration//GEN-END:variables
}
