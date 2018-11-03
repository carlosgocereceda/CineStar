/**
 * 
 */
package Integracion.Factoria;

import Integracion.Sala.DAOSala;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Pelicula.DAOPelicula;
import Integracion.Sesion.DAOSesion;
import Integracion.Ventas.DAOVentas;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaIntegracion {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaIntegracion instancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve una impementacion de DAOSala
	 * <!-- end-UML-doc -->
	 * @return DAOSala
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOSala generaDAOSala();

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve una impementacion de DAOPelicula
	 * <!-- end-UML-doc -->
	 * @return DAOPelicula
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOPelicula generaDAOPelicula();

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve una impementacion de DAOSesion
	 * <!-- end-UML-doc -->
	 * @return DAOSesion
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOSesion generaDAOSesion();

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve una impementacion de DAOEmpleados
	 * <!-- end-UML-doc -->
	 * @return DAOEmpleados
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOEmpleados generaDAOEmpleados();


	/**
	 * Devuelve una impementacion de DAOVentas
	 * @return DAOVentas
	 */
	public abstract DAOVentas generaDAOVentas();

	/** 
	 * @return the instancia
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaIntegracion getInstancia() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (instancia == null) {
			instancia = new FactoriaIntegracionImp();
		}
		return instancia;
		// end-user-code
	}

	/** 
	 * @param instancia the instancia to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setInstancia(FactoriaIntegracion instancia) {
		// begin-user-code
		FactoriaIntegracion.instancia = instancia;
		// end-user-code
	}
}