package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import model.Model;

/**
 * Tela base para as diversas telas do sistema
 * @author Ruan
 */
abstract public class View extends JFrame {
    
    protected Model model;

    public View() throws HeadlessException {
        this.model = this.getInstanceModel();
    }

    abstract public Model getInstanceModel();
    
    /**
     * Dispara uma mensagem 
     */
    public void showMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    /**
     * Dispara uma mensagem de pergunta
     * @param mensagem          Mensagem
     * @param titulo            Título
     * @param opcoesDisponiveis Opções na tela: <code>YES_NO_OPTION</code>, <code>YES_NO_CANCEL_OPTION</code> ou <code>OK_CANCEL_OPTION</code>
     * @return int 
     */
    public int showDialog(String mensagem, String titulo, int opcoesDisponiveis) {
        return JOptionPane.showConfirmDialog(this, mensagem, titulo, opcoesDisponiveis);
    }
    
    protected void formataCampo(JFormattedTextField campo, String formato) {
        this.formataCampo(campo, formato, ' ');
    }
    
    protected void formataCampo(JFormattedTextField campo, String formato, char placeHolder) {
        try {
            MaskFormatter mask = new MaskFormatter(formato);
            mask.setPlaceholderCharacter(placeHolder);
            mask.install(campo);
        }
        catch (ParseException ex) {
            this.showMensagem("Erro ao formatar o campo");
        }
    }
    
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void clearAll() {
        for (Component c : this.getComponents()) {
            if (c instanceof JTextField || c instanceof JTextArea) {
                ((JTextComponent) c).setText("");
            }
            else if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
            }
            else if (c instanceof JComboBox) {
                if (((JComboBox) c).getItemCount() > 0) {
                    ((JComboBox) c).setSelectedIndex(0);
                }
            }
            else if (c instanceof Container) {
                this.clearAll((Container) c);
            }
        }
    }
    
    public void clearAll(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField || c instanceof JTextArea) {
                ((JTextComponent) c).setText("");
            }
            else if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
            }
            else if (c instanceof JComboBox) {
                ((JComboBox) c).removeAllItems();
            }
            else if (c instanceof Container) {
                this.clearAll((Container) c);
            }
        }
    }
    
}