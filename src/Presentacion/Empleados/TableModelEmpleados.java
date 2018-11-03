/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Empleados;

import Negocio.Empleados.TEmpleado;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gerar
 */
public class TableModelEmpleados extends AbstractTableModel{
    private ArrayList<TEmpleado> tEmpleados;
    private String[] nomColumnas = { "DNI", "Nombre", "Apellidos","Tipo", "Password"};
    
    
    public TableModelEmpleados(ArrayList<TEmpleado> tEmpleados){
        this.tEmpleados = tEmpleados;
    }
    
    @Override
    public int getRowCount() {
        return tEmpleados.size();
    }

    @Override
    public int getColumnCount() {
        return nomColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
            return this.nomColumnas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return tEmpleados.get(rowIndex).getDni();
            case 1:
                return tEmpleados.get(rowIndex).getNombre();
            case 2:
                return tEmpleados.get(rowIndex).getApellidos();
            case 3: 
                return tEmpleados.get(rowIndex).getTipo();
            case 4:
                return tEmpleados.get(rowIndex).getPassword();
        }
        return null;
    }

    public ArrayList<TEmpleado> gettEmpleados() {
        return tEmpleados;
    }

    public void settEmpleados(ArrayList<TEmpleado> tEmpleados) {
        this.tEmpleados = tEmpleados;
    }
    
    
    
}
