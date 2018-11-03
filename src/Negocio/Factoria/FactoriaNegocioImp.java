/**
 * 
 */
package Negocio.Factoria;

import Negocio.Sala.ServicioSala;
import Negocio.Empleados.ServicioEmpleados;
import Negocio.Empleados.ServicioEmpleadosImp;
import Negocio.Pelicula.ServicioPelicula;
import Negocio.Sesion.ServicioSesion;
import Negocio.Sesion.ServicioSesionImp;
import Negocio.Pelicula.ServicioPeliculaImp;
import Negocio.Sala.ServicioSalaImp;
import Negocio.Ventas.ServicioVentas;
import Negocio.Ventas.ServicioVentasImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaNegocioImp extends FactoriaNegocio {
	/** 
	 * (non-Javadoc)
	 * @see FactoriaNegocio#generaServicioSala()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ServicioSala generaServicioSala() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new ServicioSalaImp();
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see FactoriaNegocio#generaServicioPelicula()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ServicioPelicula generaServicioPelicula() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new ServicioPeliculaImp();
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see FactoriaNegocio#generaServicioSesion()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ServicioSesion generaServicioSesion() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new ServicioSesionImp();
		// end-user-code
	}

	@Override
	public ServicioVentas generaServicioVentas() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new ServicioVentasImp();
	}

	@Override
	public ServicioEmpleados generaServicioEmpleados() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new ServicioEmpleadosImp();
	}
}