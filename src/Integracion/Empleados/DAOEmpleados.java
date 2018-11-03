/**
 * 
 */
package Integracion.Empleados;

import java.util.ArrayList;

import Negocio.Empleados.TEmpleado;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOEmpleados {
	/**
	 * Crea un empleado 
	 * @param TEmpleado Informacion del empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int create(TEmpleado TEmpleado);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve la informacion de un empleado a partir de un identificador
	 * <!-- end-UML-doc -->
	 * @param idEmpleado Identificador del empleado
	 * @return TEmpleado si existe o null si no existe
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TEmpleado read(int idEmpleado);

	/**
	 * Actualiza la informaciond de un empleado
	 * @param tEmpleado Informacion de un empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int update(TEmpleado tEmpleado);

	/**
	 * Borra un empleado a partir de un identificador de empleado.
	 * @param idEmp Identificador de un empleado
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int delete(Integer idEmp);

	/**
	 * Devuelve todos los empleados
	 * @return ArrayList de empleados
	 */
	public ArrayList<TEmpleado> readAll();
	/**
	 * Devuelve la informacion de un empleado a partir de un DNI
	 * @param DNI DNI del empleado
	 * @return TEmpleado si existe o null si no existe
	 */
	public TEmpleado readByDNI(String DNI);
}