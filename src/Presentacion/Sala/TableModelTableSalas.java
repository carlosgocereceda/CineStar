/**
 * 
 */
package Presentacion.Sala;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Negocio.Sala.TSala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author gerar
 */
public class TableModelTableSalas extends AbstractTableModel {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private ArrayList<TSala> tSalas;
	private String[] nomColumnas = { "idSala", "Nombre", "Columnas", "Filas",
			"Estado" };
	/** 
	 * @return the nomColumnas
	 */
	public String[] getNomColumnas() {
		// begin-user-code
		return nomColumnas;
		// end-user-code
	}


	/** 
	 * @param nomColumnas the nomColumnas to set
	 */
	public void setNomColumnas(String[] nomColumnas) {
		// begin-user-code
		this.nomColumnas = nomColumnas;
		// end-user-code
	}

	/*public TableModelTableSalas(ArrayList<TSala> tSalas) {
		this.tSalas = tSalas;
	}*/

	public TableModelTableSalas(ArrayList<TSala> tSalas) {
		this.tSalas = tSalas;
	}

	/** 
	 * @return el tSalas
	 */
	public ArrayList<TSala> gettSalas() {
		// begin-user-code
		return tSalas;
		// end-user-code
	}

	/** 
	 * @param tSalas el tSalas a establecer
	 */
	public void settSalas(ArrayList<TSala> tSalas) {
		// begin-user-code
		this.tSalas = tSalas;
		// end-user-code
	}

	@Override
	public int getRowCount() {
		return tSalas.size();
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
		switch (columnIndex) {
		case 0:
			return tSalas.get(rowIndex).getIdSala();
		case 1:
			return tSalas.get(rowIndex).getNombre();
		case 2:
			return tSalas.get(rowIndex).getColumnas();
		case 3:
			return tSalas.get(rowIndex).getFilas();
		case 4:
			String estado;
			if (tSalas.get(rowIndex).isEstado()) {
				estado = "Habilitada";
			} else {
				estado = "Deshabilitada";
			}
			return estado;
		}
		return null;
	}

	@Override
	public void fireTableDataChanged() {		
		super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
	}

}