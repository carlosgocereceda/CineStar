/**
 * 
 */
package Negocio.Ventas;

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ServicioVentas {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idVenta
	 * @param idSesion
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int AbrirVenta(Integer idVenta, Integer idSesion);

	/**
	 * Recibe un tVenta donde contiene el empleado y las lineas de venta y comprueba que las fechas sean posteriores a la fecha actual
	 * y que la cantidad a vender no sea superior a la cantidad de plazas libres de la sesion.
	 * @param tVenta
	 * @return 0 si todo es correcto sino 1 por error
	 */
	public int CerrarVenta(TVenta tVenta);


	/**
	 * Borra una venta
	 * @param idventa
	 * @return 0 si todo es correcto sino 1 por error
	 */
	public int AnularVenta(Integer idventa);
	
	/**
	 * Elimina una linea de venta y actualiza las plazas libres de la sesion.
	 * @param idVenta
	 * @param idSesion
	 * @return 0 si todo es correcto sino 1 por error
	 */
	public int eliminarLineaVenta(Integer idVenta,Integer idSesion);

	/**
	 * Borra los datos asociados a ese idventa actualizando las plazas libres de las sesiones y 
	 * añade las lineas de venta nuevas.
	 * @param tVenta
	 * @return
	 */
	public int ModificarVenta(TVenta tVenta);
	
	/**
	 * Obtiene todas las ventas realizadas.
	 * @return ArrayList que contiene todas las ventas.
	 */
	public ArrayList<TVenta> getAllVentas();
	
	/**
	 * Obtiene una venta a partir de un id.
	 * @param idVenta
	 * @return una venta.
	 */
	public TVenta getVenta(Integer idVenta);
}