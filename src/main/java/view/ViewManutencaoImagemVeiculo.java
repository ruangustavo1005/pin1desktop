package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import model.ImagemCarro;

/**
 * @author Ruan
 */
public class ViewManutencaoImagemVeiculo extends ViewManutencao {

    public ViewManutencaoImagemVeiculo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoConfirmar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        botaoSelecionarImagem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelVisualizaçãoImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir Imagem");
        setResizable(false);

        botaoConfirmar.setText("Confirmar");

        botaoSair.setText("Sair");

        botaoSelecionarImagem.setText("Selecionar uma imagem");

        jLabel1.setText("Pré-visualização:");

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
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoSelecionarImagem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVisualizaçãoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoSelecionarImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(labelVisualizaçãoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoSair))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public ImagemCarro getModelFromDadosTela() {
        ImagemCarro ImagemCarro = this.getModel();
        return ImagemCarro;
    }

    @Override
    public void beanDados() {
    }
    
    @Override
    public ImagemCarro getModel() {
        return (ImagemCarro) super.getModel();
    }

    @Override
    public ImagemCarro getInstanceModel() {
        return new ImagemCarro();
    }

    public JButton getBotaoSelecionarImagem() {
        return botaoSelecionarImagem;
    }

    public JLabel getLabelVisualizaçãoImagem() {
        return labelVisualizaçãoImagem;
    }
    
    public JButton getBotaoConfirmar() {
        return botaoConfirmar;
    }

    public JButton getBotaoSair() {
        return botaoSair;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoSelecionarImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelVisualizaçãoImagem;
    // End of variables declaration//GEN-END:variables
}
