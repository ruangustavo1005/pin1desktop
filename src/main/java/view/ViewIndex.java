package view;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        labelUsuarioLogado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoLogout = new javax.swing.JButton();
        botaoCancelarAgendamento = new javax.swing.JButton();
        botaoEfetuarAgendamento = new javax.swing.JButton();
        botaoConfirmarAgendamento = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMarcas = new javax.swing.JMenuItem();
        menuModelos = new javax.swing.JMenuItem();
        menuVeiculos = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenuItem();
        menuMovimentos = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fusuan Motors Internal System");

        tableAgendamentos.setModel(this.getTableModel());
        jScrollPane1.setViewportView(tableAgendamentos);

        labelUsuarioLogado.setText(" ");

        jLabel2.setText("Logado como:");

        botaoLogout.setText("Logout");

        botaoCancelarAgendamento.setText("Cancelar Agendamento");

        botaoEfetuarAgendamento.setText("Agendamento Já Efetuado");

        botaoConfirmarAgendamento.setText("Confirmar Agendamento");

        jMenu1.setText("Gerenciamento");

        menuMarcas.setText("Marcas");
        jMenu1.add(menuMarcas);

        menuModelos.setText("Modelos");
        jMenu1.add(menuModelos);

        menuVeiculos.setText("Veículos");
        jMenu1.add(menuVeiculos);

        menuClientes.setText("Clientes");
        jMenu1.add(menuClientes);

        menuFuncionarios.setText("Funcionario");
        jMenu1.add(menuFuncionarios);

        menuMovimentos.setText("Movimento");
        jMenu1.add(menuMovimentos);

        menuVendas.setText("Venda");
        jMenu1.add(menuVendas);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoLogout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoConfirmarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEfetuarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelarAgendamento)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelarAgendamento)
                    .addComponent(botaoEfetuarAgendamento)
                    .addComponent(botaoConfirmarAgendamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLogout)
                    .addComponent(jLabel2)
                    .addComponent(labelUsuarioLogado))
                .addContainerGap())
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

    public JMenuItem getMenuConsultarClientes() {
        return menuClientes;
    }

    public JMenuItem getMenuConsultarFuncionarios() {
        return menuFuncionarios;
    }

    public JMenuItem getMenuConsultarMovimentos() {
        return menuMovimentos;
    }

    public JMenuItem getMenuConsultarVendas() {
        return menuVendas;
    }

    public JButton getBotaoLogout() {
        return botaoLogout;
    }

    public JButton getBotaoCancelarAgendamento() {
        return botaoCancelarAgendamento;
    }

    public JButton getBotaoEfetuarAgendamento() {
        return botaoEfetuarAgendamento;
    }

    public JButton getBotaoConfirmarAgendamento() {
        return botaoConfirmarAgendamento;
    }
    
    @Override
    public JTable getTable() {
        return tableAgendamentos;
    }

    @Override
    public ArrayList<JButton> getAcoesGrid() {
        ArrayList<JButton> acoes = new ArrayList<>();
        acoes.add(botaoEfetuarAgendamento);
        acoes.add(botaoCancelarAgendamento);
        acoes.add(botaoConfirmarAgendamento);
        return acoes;
    }

    public JLabel getLabelUsuarioLogado() {
        return labelUsuarioLogado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarAgendamento;
    private javax.swing.JButton botaoConfirmarAgendamento;
    private javax.swing.JButton botaoEfetuarAgendamento;
    private javax.swing.JButton botaoLogout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuFuncionarios;
    private javax.swing.JMenuItem menuMarcas;
    private javax.swing.JMenuItem menuModelos;
    private javax.swing.JMenuItem menuMovimentos;
    private javax.swing.JMenuItem menuVeiculos;
    private javax.swing.JMenuItem menuVendas;
    private javax.swing.JTable tableAgendamentos;
    // End of variables declaration//GEN-END:variables
}
