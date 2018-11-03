package Presentacion.Venta;


import javax.swing.table.AbstractTableModel;


import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TVenta;


import java.util.HashMap;

public class TableModelVentas extends AbstractTableModel{

	private TVenta tVenta;
	private String[] nomColumnas = { "idSesion", "Pelicula", "Sala", "Fecha",
			"Hora", "Cantidad", "Precio"};
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

	public TableModelVentas(TVenta tVenta) {
		this.tVenta = tVenta;
	}

	/** 
	 * @return el tSalas
	 */
	public TVenta gettVenta() {
		// begin-user-code
		return tVenta;
		// end-user-code
	}

	/** 
	 * @param tSalas el tSalas a establecer
	 */
	public void settVenta(TVenta tVenta) {
		// begin-user-code
		this.tVenta = tVenta;
		// end-user-code
	}

	@Override
	public int getRowCount() {
		//System.out.println(tVenta.getIdVenta());
		return tVenta.getLineasVentas().size();
		//return 1;
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
        HashMap<Integer,LineaVenta> ventasSesiones = tVenta.getLineasVentas();
        Object[] it =  ventasSesiones.values().toArray();
        LineaVenta lineaVenta = (LineaVenta) it[rowIndex];
		switch (columnIndex) {
                    case 0:
                            return lineaVenta.gettSesion().getIdSesion();
                    case 1:
                            return lineaVenta.gettSesion().gettPelicula().getTitulo();
                    case 2:
                            return lineaVenta.gettSesion().gettSala().getNombre();
                    case 3:
                            return lineaVenta.gettSesion().getFecha();
                    case 4:
                            return lineaVenta.gettSesion().getHora();
                    case 5:
                            return lineaVenta.getCant();
                    case 6:
                            return lineaVenta.gettSesion().getPrecioUnitario();
                            /*String estado;
                            if (tSalas.get(rowIndex).isEstado()) {
                                    estado = "Habilitada";
                            } else {
                                    estado = "Deshabilitada";
                            }
                            return estado;*/
		}
		return null;
	}

        public LineaVenta getSelectedLineaVenta(int selectedRow){
        	HashMap<Integer,LineaVenta> ventasSesiones = tVenta.getLineasVentas();
        	Object[] it =  ventasSesiones.values().toArray();
            LineaVenta lineaVenta = (LineaVenta) it[selectedRow];
            return lineaVenta;
        }
        
	@Override
	public void fireTableDataChanged() {		
		super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
	}
}
