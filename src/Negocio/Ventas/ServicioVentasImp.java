/**
 * 
 */
package Negocio.Ventas;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Sesion.DAOSesion;
import Integracion.Ventas.DAOVentas;
import Negocio.Sesion.TSesion;
import Presentacion.Controlador.Controlador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioVentasImp implements ServicioVentas {
	/** 
	 * (non-Javadoc)
	 * @see ServicioVentas#AbrirVenta(Integer idVenta, Integer idSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int AbrirVenta(Integer idVenta, Integer idSesion) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return 1;
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioVentas#CerrarVenta(Integer idVenta)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int CerrarVenta(TVenta tVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if(tVenta != null){
			if(!tVenta.getLineasVentas().isEmpty()){
				boolean correcto = true;
				Object[] lineasVenta = tVenta.getLineasVentas().values().toArray();
				FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
				DAOSesion daoSesion = factInteg.generaDAOSesion();
				for (int i = 0; i < lineasVenta.length; i++) {
					LineaVenta lineaVenta = (LineaVenta) lineasVenta[i];
					Date actual = new Date();
					TSesion tSesionAux = daoSesion.read(lineaVenta.gettSesion().getIdSesion());
					Date fechaSeleccionada = tSesionAux.getFecha();
					if(fechaSeleccionada == null){
						//Si la fecha es null
						correcto = false;
						break;
					}else if(actual.after(fechaSeleccionada) && actual.getYear() != fechaSeleccionada.getYear() 
							&& actual.getMonth() != fechaSeleccionada.getMonth()
							&& actual.getDate() != fechaSeleccionada.getDate()){
						//Fecha anterior 
						correcto = false;
						break;
		            }else if(tSesionAux.getCantLibres() < lineaVenta.getCant()){
		            	//Si la cantidad de butacas a vender es superior a las butacas libres en la sesion
		            	correcto = false;
						break;
		            }
				}
				if(correcto){
					
					DAOVentas daoVenta = factInteg.generaDAOVentas();
					for (int i = 0; i < lineasVenta.length; i++) {
						LineaVenta lineaVenta = (LineaVenta) lineasVenta[i];
						TSesion tSesionAux = daoSesion.read(lineaVenta.gettSesion().getIdSesion());
						tSesionAux.setCantLibres(tSesionAux.getCantLibres()-lineaVenta.getCant());
						int error = daoSesion.update(tSesionAux);
						if(error != 0){
							return error;
						}
					}
					return daoVenta.create(tVenta);
				}else{
					//Error en las fechas de sesion o en cantidad
					return 1;
				}								
			}else{
				//Error la lineas de ventas esta vacia
				return 2;
			}
		}else{
			//Error la venta esta vacia
			return 1;
		}
		// end-user-code
	}


	/** 
	 * (non-Javadoc)
	 * @see ServicioVentas#AnularVenta(TVenta idventa)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int AnularVenta(Integer idventa) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
		DAOVentas daoVenta = factInteg.generaDAOVentas();
		return daoVenta.delete(idventa);
		// end-user-code
	}


	/** 
	 * (non-Javadoc)
	 * @see ServicioVentas#ModificarVenta()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int ModificarVenta(TVenta tVenta) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
		DAOVentas daoVenta = factInteg.generaDAOVentas();
		Integer idVenta = tVenta.getIdVenta();
		TVenta tVentaAux = daoVenta.read(idVenta);
		DAOSesion daoSesion = factInteg.generaDAOSesion();
		for (LineaVenta lineaVenta : tVentaAux.getLineasVentas().values()) {			
			TSesion tSesion = lineaVenta.gettSesion();
			tSesion.setCantLibres(tSesion.getCantLibres()+lineaVenta.getCant());
			daoSesion.update(tSesion);
		}
		for (LineaVenta lineaVenta : tVenta.getLineasVentas().values()) {
			TSesion tSesion = daoSesion.read(lineaVenta.gettSesion().getIdSesion());
			tSesion.setCantLibres(tSesion.getCantLibres()-lineaVenta.getCant());
			daoSesion.update(tSesion);
		}
		daoVenta.delete(idVenta);
		daoVenta.createWithID(tVenta);
		return 1;
		// end-user-code
	}

	@Override
	public ArrayList<TVenta> getAllVentas() {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
		DAOVentas daoVenta = factInteg.generaDAOVentas();
		return daoVenta.readAll();
	}

	@Override
	public TVenta getVenta(Integer idVenta) {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
		DAOVentas daoVenta = factInteg.generaDAOVentas();
		return daoVenta.read(idVenta);
	}

	@Override
	public int eliminarLineaVenta(Integer idVenta, Integer idSesion) {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
		DAOVentas daoVenta = factInteg.generaDAOVentas();
		LineaVenta lineaVenta = daoVenta.readLineaVenta(idVenta, idSesion);
		DAOSesion daoSesion = factInteg.generaDAOSesion();
		TSesion tSesion = lineaVenta.gettSesion();
		tSesion.setCantLibres(tSesion.getCantLibres()+lineaVenta.getCant());
		daoSesion.update(tSesion);
		return daoVenta.deleteLineaVenta(idVenta, idSesion);
	}

}