/**
 * 
 */
package Negocio.Sala;

import java.util.ArrayList;
import Negocio.Sala.TSala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ServicioSala {
	/** 
	 * <!-- begin-UML-doc -->
	 * Comprueba que el nombre de la sala no existe y si es asi 
	 * la añade
	 * <!-- end-UML-doc -->
	 * @param tSala informacion de la sala
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirSala(TSala tSala);

	/**
	 * Comprueba que existe la sala y si existe comprueba que no tiene sesiones asociadas
	 * @param tSala informacion de la sala
	 * @return 0 si todo se cumple y 1 si se produce algun error
	 */
	public Integer eliminarSala(TSala tSala);
	/**
	 * Comprueba que existe la sala y si existe comprueba que no tiene sesiones asociadas
	 * @param tSala informacion de la sala
	 * @return 0 si todo se cumple y 1 si se produce algun error
	 */
	public Integer modificarSala(TSala tSala);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las salas
	 * <!-- end-UML-doc -->
	 * @return ArrayList de salas
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList getAllSalas();

	
}