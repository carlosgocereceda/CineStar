/**
 * 
 */
package Presentacion.Sesion;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import Negocio.Sesion.TSesion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 */
public class TableModelSesionPorSala extends AbstractTableModel {
	private String[] nomColumnas = { "Pelicula", "Hora Inicio", "Hora Fin",
			"Plazas Libres", "Precio Unitario" };

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

	private ArrayList<TSesion> tSesionesPorSala;

	public TableModelSesionPorSala(ArrayList<TSesion> tSesionesPorSala) {
		this.tSesionesPorSala = tSesionesPorSala;
	}

	@Override
	public int getRowCount() {
		return tSesionesPorSala.size();
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
			return tSesionesPorSala.get(rowIndex).gettPelicula().getTitulo();
		case 1:
			Date hora = (Date) tSesionesPorSala.get(rowIndex).getHora().clone();
			return hora.getHours() + ":"
					+ String.format("%02d", hora.getMinutes());
		case 2:
			hora = (Date) tSesionesPorSala.get(rowIndex).getHora().clone();
			Integer duracion = tSesionesPorSala.get(rowIndex).gettPelicula()
					.getDuracion();
			/*Integer horas,minutos;
			horas = duracion/60;
			minutos = duracion%60;
			fecha.setHours(fecha.getHours()+horas);*/
			hora.setMinutes(hora.getMinutes() + duracion);
			return hora.getHours() + ":"
					+ String.format("%02d", hora.getMinutes());
		case 3:
			return tSesionesPorSala.get(rowIndex).getCantLibres();
		case 4:
			return tSesionesPorSala.get(rowIndex).getPrecioUnitario();
		}
		return null;
	}

	public ArrayList<TSesion> gettSesionesPorSala() {
		return tSesionesPorSala;
	}

	public void settSesionesPorSala(ArrayList<TSesion> tSesionesPorSala) {
		this.tSesionesPorSala = tSesionesPorSala;
	}

}
