package view;

import interfaces.ListagemAdicional;
import interfaces.ListagemMaqueada;
import interfaces.ListagemParcial;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import util.StringUtils;

/**
 * Modelo de tabelas padrão para consultas no sistema
 * No geral, não há necessidade de criar um modelo específico para a consulta, apenas em casos muito específicos.
 * @see ListagemAdicional interface a ser implementada no modelo de dados (model) para adicionar colunas (possívelmente calculadas)
 * @see ListagemMaqueada  interface a ser implementada no modelo de dados (model) para alterar o título das colunas da consulta
 * @see ListagemParcial   interface a ser implementada no modelo de dados (model) para remover colunas da listagem
 * @author Ruan
 */
public class TableModelPadrao<Type> extends AbstractTableModel {
    
    protected List<Type>   modelos;
    protected Type         modelo;
    protected List<String> atributos;

    public TableModelPadrao(Type modelo) {
        this.modelo  = modelo;
        this.modelos = new ArrayList<>();
        this.iniAtributos();
    }

    public TableModelPadrao(ArrayList<Type> modelos) {
        this.modelos = modelos;
        this.modelo  = modelos.get(0);
        this.iniAtributos();
    }
    
    protected final void iniAtributos() {
        this.atributos = new ArrayList<>();
        Class classAtual = modelo.getClass();
        while (!classAtual.isInstance(new Object())) {
            for (Field field : classAtual.getDeclaredFields()) {
                this.atributos.add(field.getName());
            }
            classAtual = classAtual.getSuperclass();
        }
        if (modelo instanceof ListagemParcial) {
            ((ListagemParcial) modelo).getCamposIgnorar().forEach(atributo -> {
                this.atributos.remove(atributo);
            });
        }
        if (modelo instanceof ListagemAdicional) {
            ((ListagemAdicional) modelo).getCamposAdicionar().forEach(atributo -> {
                this.atributos.add(atributo);
            });
        }
    }
    
    public List<Type> getModelos() {
        return this.modelos;
    }

    public void setModelos(List<Type> modelos) {
        this.modelos = modelos;
    }

    @Override
    public void fireTableChanged(TableModelEvent e) {
        this.sort();
        super.fireTableChanged(e);
    }
        
    public void sort() {
        if (modelo instanceof Comparator) {
            this.modelos.sort((Comparator<Type>) modelo);
        }
    }

    public void add(Type model) {
        modelos.add(model);
        int i = modelos.indexOf(model);
        fireTableRowsInserted(i, i);
    }

    public void remove(Type model) {
        int i = modelos.indexOf(model);
        this.remove(i);
    }
    
    public void remove(int i) {
        modelos.remove(i);
        fireTableRowsDeleted(i, i);
    }

    public void update(int i) {
        fireTableRowsUpdated(i, i);
    }

    public Type get(int i) {
        return modelos.get(i);
    }

    public int indexOf(Type model) {
        return modelos.indexOf(model);
    }
    
    @Override
    public int getRowCount() {
        return this.getModelos().size();
    }

    @Override
    public int getColumnCount() {
        return this.getQuantidadeAtributos();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.getAtributo(this.modelos.get(rowIndex), columnIndex);
    }
    
    @Override
    public String getColumnName(int column) {
        String nome = StringUtils.ucfirst(this.getNomeAtributo(column));
        if (modelo instanceof ListagemMaqueada) {
            nome = ((ListagemMaqueada) modelo).getTitulosColunas().getOrDefault(this.getNomeAtributo(column), nome);
        }
        return nome;
    }
    
    protected int getQuantidadeAtributos() {
        return this.atributos.size();
    }

    protected String getNomeAtributo(int pos) {
        return this.atributos.get(pos);
    }
    
    protected Object getAtributo(Type model, int pos){
        Object retorno = null;
        String nome    = this.getNomeAtributo(pos);
        String metodo  = "get" + StringUtils.ucfirst(nome);
        try {
            retorno = model.getClass().getMethod(metodo).invoke(model);
        } catch (NoSuchMethodException
               | SecurityException
               | IllegalAccessException
               | IllegalArgumentException
               | InvocationTargetException ex) {
            System.out.println("O método " + metodo + " não pode ser acessado na classe " + model.getClass().getName() + "!");
        }
        return retorno;
    }
    
}