/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Venta;

import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TVenta;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gerar
 */
public class TableModelTodasVentas extends AbstractTableModel{
    private ArrayList<TVenta> tVentas;
    private String[] nomColumnas = { "IDVenta","IDSesion", "Pelicula", "Sala","Empleado", "Fecha",
			"Hora", "Cantidad", "Precio"};
    
    @Override
    public int getRowCount() {
        int filas = 0;
        for (TVenta tVenta : tVentas) {
        	filas += tVenta.getLineasVentas().size();
           
        }
        return filas;
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
        int n = 0;
        LineaVenta lineaVenta = null;
        TVenta idVentaSeleccionada = null;
        for (TVenta tVenta : tVentas) {
        	Collection<LineaVenta> lineasVentas = tVenta.getLineasVentas().values();
        	for (LineaVenta lineaVentaAux : lineasVentas) {       		
                if(n == rowIndex){
                    lineaVenta = lineaVentaAux;
                    idVentaSeleccionada = tVenta;
                    break;
                }
                n++; 
			}
        	if(lineaVenta != null){
        		break;
        	}
        }
        switch(columnIndex){
            case 0:
                return idVentaSeleccionada.getIdVenta();
            case 1:
                return lineaVenta.gettSesion().getIdSesion();
            case 2:
                return lineaVenta.gettSesion().gettPelicula().getTitulo();
            case 3:
                return lineaVenta.gettSesion().gettSala().getNombre();
            case 4:
                return idVentaSeleccionada.gettEmpleado().getDni();
            case 5:
                return lineaVenta.gettSesion().getFecha();
            case 6:
                return lineaVenta.gettSesion().getHora();
            case 7:
                return lineaVenta.getCant();
            case 8:
                return lineaVenta.gettSesion().getPrecioUnitario();
        }
        return null;
    }
    
    public TableModelTodasVentas(ArrayList<TVenta> tVentas){
    	this.tVentas = tVentas;
    }
    
}
