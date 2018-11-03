/**
 * 
 */
package Negocio.Factoria;


import Negocio.Empleados.ServicioEmpleados;
import Negocio.Pelicula.ServicioPelicula;
import Negocio.Sala.ServicioSala;
import Negocio.Sesion.ServicioSesion;
import Negocio.Ventas.ServicioVentas;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaNegocio {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaNegocio instancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract ServicioSala generaServicioSala();

	/** 
	 * <!-- begin-UML-doc -->
	 * Genera una implementacion de ServicioPelicula
	 * <!-- end-UML-doc -->
	 * @return ServicioPelicula
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract ServicioPelicula generaServicioPelicula();
	/**
	 * Genera una implementacion de ServicioVenta
	 * @return ServicioVenta
	 */
	public abstract ServicioVentas generaServicioVentas();
	/**
	 * Genera una implementacion de ServicioEmpleados
	 * @return ServicioEmpleados
	 */
	public abstract ServicioEmpleados generaServicioEmpleados();

	/** 
	 * <!-- begin-UML-doc -->
	 * Genera una implementacion de ServicioSesion
	 * <!-- end-UML-doc -->
	 * @return ServicioSesion
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract ServicioSesion generaServicioSesion();

	/** 
	 * @return the instancia
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaNegocio getInstancia() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (instancia == null) {
			instancia = new FactoriaNegocioImp();
		}
		return instancia;
		// end-user-code
	}

	/** 
	 * @param instancia the instancia to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setInstancia(FactoriaNegocio instancia) {
		// begin-user-code
		FactoriaNegocio.instancia = instancia;
		// end-user-code
	}
}