package view;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Ruan
 */
abstract public class ViewConsulta extends View {
    
    protected TableModelPadrao tableModel;

    /**
     * Ações que dependem de uma seleção de registro da consulta
     * @return ArrayList
     */
    abstract public ArrayList<JButton> getAcoesGrid();
    
    abstract public JTable getTable();
    
    public ViewConsulta() throws HeadlessException {
        this.tableModel = this.getInstanceTableModel();
    }

    protected TableModelPadrao getInstanceTableModel() {
        return new TableModelPadrao<>(this.getInstanceModel());
    }
    
    public TableModelPadrao getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModelPadrao tableModel) {
        this.tableModel = tableModel;
    }
    
}