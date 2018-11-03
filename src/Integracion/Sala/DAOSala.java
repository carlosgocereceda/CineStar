/**
 * 
 */
package Integracion.Sala;

import Negocio.Sala.TSala;

import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOSala {
	/**
	 * 
	 * @param tSala
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int create(TSala tSala);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve la informacion de una sala a partir de un nombre
	 * <!-- end-UML-doc -->
	 * @param Nombre Nombre de la sala 
	 * @return TSala si existe o null si no existe
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TSala read(String Nombre);

	/** 
	 * <!-- begin-UML-doc -->
	 * Todas las salas
	 * <!-- end-UML-doc -->
	 * @return ArrayList de salas
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList readAll();

	/**
	 * Actualiza la informacion de una sala 
	 * @param tSala Informacion de sala
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int update(TSala tSala);

	/**
	 * Borra una sala
	 * @param tSala Informacion de la sala
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int delete(TSala tSala);
}