/**
 * 
 */
package Negocio.Pelicula;

import java.util.ArrayList;
import java.util.Date;

import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Pelicula.DAOPelicula;
import Integracion.Sesion.DAOSesion;
import Negocio.Pelicula.TPelicula;
import Negocio.Sesion.TSesion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioPeliculaImp implements ServicioPelicula {
	/** 
	 * (non-Javadoc)
	 * @see ServicioPelicula#anadirPelicula(TPelicula tPelicula)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirPelicula(TPelicula tPelicula) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente		
		if(tPelicula.getTitulo().compareToIgnoreCase("") != 0 && tPelicula.getClasificacion().compareToIgnoreCase("") != 0
				&& tPelicula.getDuracion() > 0){
			FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
			DAOPelicula daoPelicula = fact.generaDAOPelicula();
			TPelicula tEpliculaAux = daoPelicula.read(tPelicula.getTitulo());
			if(tEpliculaAux == null){
				daoPelicula.create(tPelicula);			
				return 0;
			}
			else{
				return 1;
			}
		}else{
			return 1;
		}		
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioPelicula#eliminarPelicula(TPelicula tPelicula)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer eliminarPelicula(Integer idPelicula) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOPelicula daoPelicula = fact.generaDAOPelicula();
		DAOSesion daoSesion = fact.generaDAOSesion();
		ArrayList<TSesion> arraySesiones = daoSesion.readPorPelicula(idPelicula);
		if (arraySesiones.size() == 0) {
			daoPelicula.delete(idPelicula);
			return 0;
		} else {
			return 1;
		}
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioPelicula#modificarPelicula(TPelicula tPelicula)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer modificarPelicula(TPelicula tPelicula) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOPelicula daoPelicula = fact.generaDAOPelicula();
		DAOSesion daoSesion = fact.generaDAOSesion();
		ArrayList<TSesion> arraySesiones = daoSesion.readPorPelicula(tPelicula.getIdPelicula());
		if (arraySesiones.size() == 0) {
			daoPelicula.update(tPelicula);
			return 0;
		} else {
			return 1;
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see ServicioPelicula#getAllPeliculas()
	 */
	public ArrayList<TPelicula> getAllPeliculas() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOPelicula daoPelicula = fact.generaDAOPelicula();
		return daoPelicula.readAll();
		// end-user-code
	}

	@Override
	public ArrayList getAllPeliculasPorSesionFecha(Date fecha) {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOPelicula daoPelicula = fact.generaDAOPelicula();
		return daoPelicula.readAllPorSesionFecha(fecha);
	}
}