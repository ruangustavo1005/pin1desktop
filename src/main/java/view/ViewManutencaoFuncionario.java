package view;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import model.Funcionario;
import util.DateUtils;
import util.MD5;
import util.NumberUtils;
import util.StringUtils;

/**
 *
 * @author Ruan
 */
public class ViewManutencaoFuncionario extends ViewManutencao {

    public ViewManutencaoFuncionario() {
        initComponents();
        formataCampo(campoCpf,            "###.###.###-##", '0');
        formataCampo(campoDataNascimento, "##/##/####",     '0');
        formataCampo(campoDataAdmissao,   "##/##/####",     '0');
        formataCampo(campoSalario,        "##.###,##",      '0');
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
        campoDataAdmissao = new javax.swing.JFormattedTextField();
        campoGerente = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        campoSalario = new javax.swing.JFormattedTextField();
        labelSenhaAnterior = new javax.swing.JLabel();
        campoSenhaAnterior = new javax.swing.JPasswordField();
        campoSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        campoConfirmaSenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");

        botaoConfirmar.setText("Confirmar");

        botaoLimpar.setText("Limpar");

        botaoSair.setText("Sair");

        jLabel1.setText("CPF:");

        jLabel2.setText("Data de Nasc.:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Data de Admissão:");

        campoGerente.setText("É Gerente?");

        jLabel5.setText("Salário:");

        labelSenhaAnterior.setText("Senha Anterior:");

        jLabel7.setText("Senha:");

        jLabel8.setText("Confirmação da Senha:");

        jLabel9.setText("Login:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoSalario))
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(labelSenhaAnterior)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoSenha)
                                    .addComponent(campoSenhaAnterior)
                                    .addComponent(campoConfirmaSenha)
                                    .addComponent(campoLogin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoGerente)
                                .addGap(4, 4, 4)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                    .addComponent(campoDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(campoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoGerente)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenhaAnterior)
                    .addComponent(campoSenhaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    public Funcionario getModelFromDadosTela() {
        Funcionario funcionario = this.getModel();
        funcionario.setCpf(StringUtils.removeChars(campoCpf.getText(), '.', '-'));
        funcionario.setDataAdmissao(DateUtils.stringToDate(campoDataAdmissao.getText()));
        funcionario.setDataNascimento(DateUtils.stringToDate(campoDataNascimento.getText()));
        funcionario.setGerente(campoGerente.isSelected());
        funcionario.setLogin(campoLogin.getText());
        funcionario.setNome(campoNome.getText());
        funcionario.setSalario(NumberUtils.parseFloat(campoSalario.getText()));
        funcionario.setSenha(MD5.md5(campoSenha.getPassword()));
        return funcionario;
    }

    @Override
    public void beanDados() {
        campoCpf.setText(this.getModel().getCpf());
        campoDataAdmissao.setText(DateUtils.dateToString(this.getModel().getDataAdmissao()));
        campoDataNascimento.setText(DateUtils.dateToString(this.getModel().getDataNascimento()));
        campoGerente.setSelected(this.getModel().isGerente());
        campoLogin.setText(this.getModel().getLogin());
        campoNome.setText(this.getModel().getNome());
        campoSalario.setText(StringUtils.lpad(NumberUtils.formataValor(this.getModel().getSalario(), 2, true), 9));
        this.campoSenhaAnterior.setVisible(true);
        this.labelSenhaAnterior.setVisible(true);
    }

    @Override
    public void setVisible(boolean b) {
        this.campoSenhaAnterior.setVisible(false);
        this.labelSenhaAnterior.setVisible(false);
        super.setVisible(b);
    }
    
    @Override
    public Funcionario getInstanceModel() {
        return new Funcionario();
    }

    @Override
    public Funcionario getModel() {
        return (Funcionario) super.getModel();
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

    public JPasswordField getCampoConfirmaSenha() {
        return campoConfirmaSenha;
    }

    public JPasswordField getCampoSenha() {
        return campoSenha;
    }

    public JPasswordField getCampoSenhaAnterior() {
        return campoSenhaAnterior;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JPasswordField campoConfirmaSenha;
    private javax.swing.JFormattedTextField campoCpf;
    private javax.swing.JFormattedTextField campoDataAdmissao;
    private javax.swing.JFormattedTextField campoDataNascimento;
    private javax.swing.JCheckBox campoGerente;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoSalario;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPasswordField campoSenhaAnterior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelSenhaAnterior;
    // End of variables declaration//GEN-END:variables
}
