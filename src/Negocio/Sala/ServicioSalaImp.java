/**
 * 
 */
package Negocio.Sala;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Sala.DAOSala;
import Integracion.Sesion.DAOSesion;

import Negocio.Sesion.TSesion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author usuario_local
 * @generated 
 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioSalaImp implements ServicioSala {
	/**
	 * (non-Javadoc)
	 * 
	 * @see ServicioSala#anadirSala(TSala tSala)
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirSala(TSala tSala) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOSala daoSala = fact.generaDAOSala();
		TSala tSalaAux = daoSala.read(tSala.getNombre());
		if (tSalaAux == null) {
			daoSala.create(tSala);
			return 0;
		}
		else{
			return 1;
		}
		// end-user-code
	}
	@Override
	public Integer eliminarSala(TSala tSala) {
		// TODO Apéndice de método generado automáticamente
				FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
				DAOSala daoSala = fact.generaDAOSala();
				DAOSesion daoSesion = fact.generaDAOSesion();
				TSala tSalaAux = daoSala.read(tSala.getNombre());
				if (tSalaAux == null) {
					return 2;
				} else {
					Date fecha = new GregorianCalendar().getTime();
					ArrayList<TSesion> arraySesiones = daoSesion.readPorSala(tSala);
					if (arraySesiones.size() == 0) {
						daoSala.delete(tSala);
						return 0;
					} else {
						return 1;
					}
				}
	}

	@Override
	public Integer modificarSala(TSala tSala) {
		// TODO Apéndice de método generado automáticamente
				FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
				DAOSala daoSala = fact.generaDAOSala();
				DAOSesion daoSesion = fact.generaDAOSesion();
				TSala tSalaAux = daoSala.read(tSala.getNombre());
				if (tSalaAux == null) {
					return 2;
				} 
				else {
					ArrayList<TSesion> arraySesiones = daoSesion.readPorSala(tSala);
					if (arraySesiones.size() == 0) {
					daoSala.update(tSala);
					return 0;
				} else {
					return 1;
				}
			}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ServicioSala#getAllSalas()
	 * @generated 
	 *            "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList getAllSalas() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOSala daoSala = fact.generaDAOSala();
		return daoSala.readAll();
		// end-user-code
	}

	
	
}