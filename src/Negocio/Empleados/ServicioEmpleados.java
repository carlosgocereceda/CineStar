/**
 * 
 */
package Negocio.Empleados;

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ServicioEmpleados {

	/**
	 * Comprueba que el DNI del empleados no existe si se cumple se da de alta al empleado
	 * @param tEmpleado Informaciond del empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public Integer DarDeAltaEmpleado(TEmpleado tEmpleado);

	/**
	 * Comprueba si el empleado existe y si existe da de baja al empleado y borra todas las 
	 * ventas asociadas a el
	 * @param idEmp Identificador del empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public Integer DarDeBajaEmpleado(Integer idEmp);

	/**
	 * Comprueba si el empleado existe y si existe modifica el empleado
	 * @param tEmpleado Informacion del empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public Integer ModificarEmpleado(TEmpleado tEmpleado);

	
	/**
	 * Devuelve todos los empleados.
	 * @return ArrayList de Empleados
	 */
	public ArrayList<TEmpleado> getAllEmpleados();
	/**
	 * Devuelve un empleado a partir de un identificador
	 * @param idEmpleado Identificador del empleado
	 * @return TEmpleado si existe el empelado o null si no existe
	 */
	public TEmpleado getEmpleado(int idEmpleado);

}