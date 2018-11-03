/**
 * 
 */
package Integracion.Factoria;

import Integracion.Sala.DAOSala;
import Integracion.Empleados.DAOEmpleados;
import Integracion.Empleados.DAOEmpleadosImp;
import Integracion.Pelicula.DAOPelicula;
import Integracion.Sesion.DAOSesion;
import Integracion.Sesion.DAOSesionImp;
import Integracion.Pelicula.DAOPeliculaImp;
import Integracion.Sala.DAOSalaImp;
import Integracion.Ventas.DAOVentas;
import Integracion.Ventas.DAOVentasImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaIntegracionImp extends FactoriaIntegracion {
	/** 
	 * (non-Javadoc)
	 * @see FactoriaIntegracion#generaDAOSala()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOSala generaDAOSala() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOSalaImp();
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see FactoriaIntegracion#generaDAOPelicula()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOPelicula generaDAOPelicula() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOPeliculaImp();
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see FactoriaIntegracion#generaDAOSesion()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOSesion generaDAOSesion() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOSesionImp();
		// end-user-code
	}

	@Override
	public DAOEmpleados generaDAOEmpleados() {
		return new DAOEmpleadosImp();
	}

	@Override
	public DAOVentas generaDAOVentas() {
		// TODO Apéndice de método generado automáticamente
		return new DAOVentasImp();
	}
}