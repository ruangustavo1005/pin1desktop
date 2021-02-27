package view;

import javax.swing.JButton;
import model.Cliente;
import util.DateUtils;
import util.StringUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoCliente extends ViewManutencao {

    public ViewManutencaoCliente() {
        initComponents();
        formataCampo(campoCpf,            "###.###.###-##", '0');
        formataCampo(campoDataNascimento, "##/##/####",     '0');
        formataCampo(campoTelefone,       "(##)#####-####", '0');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoConfirmar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        campoDataNascimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");

        botaoConfirmar.setText("Confirmar");

        botaoLimpar.setText("Limpar");

        botaoSair.setText("Sair");

        jLabel1.setText("CPF:");

        jLabel2.setText("Data de Nasc.:");

        jLabel3.setText("Nome:");

        jLabel4.setText("E-mail:");

        jLabel5.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 47, Short.MAX_VALUE))
                            .addComponent(campoNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoEmail))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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
    public Cliente getModelFromDadosTela() {
        Cliente cliente = this.getModel();
        cliente.setCpf(StringUtils.removeChars(campoCpf.getText(), '.', '-'));
        cliente.setDataNascimento(DateUtils.stringToDate(campoDataNascimento.getText()));
        cliente.setEmail(campoEmail.getText());
        cliente.setNome(campoNome.getText());
        cliente.setTelefone(StringUtils.removeChars(campoTelefone.getText(), '(', ')', '-'));
        return cliente;
    }

    @Override
    public void beanDados() {
        campoCpf.setText(this.getModel().getCpf());
        campoDataNascimento.setText(DateUtils.dateToString(this.getModel().getDataNascimento()));
        campoEmail.setText(this.getModel().getEmail());
        campoNome.setText(this.getModel().getNome());
        campoTelefone.setText(this.getModel().getTelefone());
    }

    @Override
    public Cliente getInstanceModel() {
        return new Cliente();
    }

    @Override
    public Cliente getModel() {
        return (Cliente) super.getModel();
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
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JFormattedTextField campoDataNascimento;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
