/**
 * 
 */
package Integracion.Ventas;

import java.util.ArrayList;

import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TVenta;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOVentas {
	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve una venta a partir de un identificador
	 * <!-- end-UML-doc -->
	 * @param idVenta Identificador de la venta
	 * @return TVenta si existe o null si no existe
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta read(Integer idVenta);
	/**
	 * Devuelve una linea de venta a partid de un identificador de venta y 
	 * un identificador de sesion
	 * @param idVenta Identificador de venta
	 * @param idSesion Identificador de sesion
	 * @return LineaVenta si existe y null si no existe
	 */
	public LineaVenta readLineaVenta(Integer idVenta,Integer idSesion);

	/**
	 * Devuelve todas las ventas
	 * @return ArrayList de ventas
	 */
	public ArrayList<TVenta> readAll();

	/**
	 * Borra la venta y todas sus lineas de venta asocidadas a un identificador de venta
	 * @param idVenta Identificador de venta
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int delete(Integer idVenta);
	/**
	 * Borra una linea de venta asociada a un identificador de venta y de sesion
	 * @param idVenta Identificador de venta
	 * @param idSesion Identificador de sesion
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int deleteLineaVenta(Integer idVenta,Integer idSesion);
	/**
	 * Borra todas las lineas de venta asociadas a una sesion
	 * @param idSesion Identificador de Sesion
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int deleteLineasVentaPorSesion(Integer idSesion);
	/**
	 * Borra todas las ventas asociadas a un identificador de empleado
	 * @param idEmpleado Identificador de empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int deleteByIDEmpleado(Integer idEmpleado);

	/**
	 * Modifica todas las lineas de venta asocidadas a una venta
	 * @param tVenta Informacion de la venta
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int update(TVenta tVenta);

	/**
	 * Crea una venta y todas sus lineas de venta sin identificador
	 * @param tVenta Informacion de la venta
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int create(TVenta tVenta);
	/**
	 * Crea una venta y todas sus lineas de venta con identificador
	 * @param tVenta Informacion de la venta
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int createWithID(TVenta tVenta);
	/**
	 * Devuelve todas las ventas asociadas a una sesion
	 * @param idSesion Identificador de sesion
	 * @return ArrayList de ventas
	 */
	public ArrayList readByIDSesion(int idSesion);
}