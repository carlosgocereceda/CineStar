/**
 * 
 */
package Negocio.Sesion;

import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Sala.DAOSala;
import Integracion.Sesion.DAOSesion;
import Integracion.Ventas.DAOVentas;
import Negocio.Pelicula.TPelicula;
import Negocio.Sala.TSala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioSesionImp implements ServicioSesion {
	/** 
	 * (non-Javadoc)
	 * @see ServicioSesion#crearSesion(Integer idPelicula, Integer idSala, Date fechaHora)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crearSesion(TSesion tSesion) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		FactoriaIntegracion factIntegracion = FactoriaIntegracion.getInstancia();
		DAOSesion daoSesion = factIntegracion.generaDAOSesion();
		DAOSala daoSala = factIntegracion.generaDAOSala();
		TSala tsalaAux = daoSala.read(tSesion.gettSala().getNombre());
		ArrayList<Date> horasDisponibles = getHorasDisponibles(tSesion.gettSala(),tSesion.gettPelicula(),tSesion.getFecha());
		if(tsalaAux.isEstado()){
			Date horaInicio = (Date) tSesion.getHora().clone();
			Date horaFin = (Date) tSesion.getHora().clone();
			horaFin.setMinutes(horaFin.getMinutes()+tSesion.gettPelicula().getDuracion());
			boolean encontrado;
			while((horaInicio.getHours() < horaFin.getHours()) 
					|| (horaInicio.getHours() == horaFin.getHours() && horaInicio.getMinutes() <= horaFin.getMinutes())){
				encontrado = false;
				for (Date date : horasDisponibles) {
					if(horaInicio.getHours() == date.getHours() && horaInicio.getMinutes() == date.getMinutes()){
						encontrado = true;
						break;
					}
				}
				if(!encontrado){
					return 1;
				}
				horaInicio.setMinutes(horaInicio.getMinutes()+5);
			}
			return daoSesion.create(tSesion);
		}else{
			//ERROR
			return 1;
		}		
		// end-user-code*/
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioSesion#modificarSesion(TSesion tSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarSesion(TSesion tSesion) {

		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOSesion daoSesion = fact.generaDAOSesion();
		TSesion tsesionAux = daoSesion.read(tSesion.getIdSesion());
		ArrayList<Date> horasDisponibles = getHorasDisponibles(tSesion.gettSala(),tSesion.gettPelicula(),tSesion.getFecha());	
		TSesion tSesionAntigua = daoSesion.read(tSesion.getIdSesion());
		Date horaInicio = (Date) tSesionAntigua.getHora().clone();
		Date horaFin = (Date) horaInicio.clone();
		horaInicio.setMinutes(horaInicio.getMinutes()-tSesionAntigua.gettPelicula().getDuracion());
		horaFin.setMinutes(horaFin.getMinutes()+tSesionAntigua.gettPelicula().getDuracion());
		while(horaInicio.getHours() < horaFin.getHours() || 
                (horaInicio.getHours() == horaFin.getHours() &&  horaInicio.getMinutes() <= horaFin.getMinutes())){                
            horasDisponibles.add(horaInicio);
            horaInicio = (Date) horaInicio.clone();                
            horaInicio.setMinutes(horaInicio.getMinutes()+5);
        }
		if(tsesionAux != null){
			if(tSesion.gettSala().isEstado()){
				horaInicio = (Date) tSesion.getHora().clone();
				horaFin = (Date) tSesion.getHora().clone();
				horaFin.setMinutes(horaFin.getMinutes()+tSesion.gettPelicula().getDuracion());
				boolean encontrado = false;
				while((horaInicio.getHours() < horaFin.getHours()) 
						|| (horaInicio.getHours() == horaFin.getHours() && horaInicio.getMinutes() <= horaFin.getMinutes())){
					encontrado = false;
					for (Date date : horasDisponibles) {
						if(horaInicio.getHours() == date.getHours() && horaInicio.getMinutes() == date.getMinutes()){
							encontrado = true;
							break;
						}
					}
					if(!encontrado){
						return 1;
					}
					horaInicio = (Date) horaInicio.clone();
					horaInicio.setMinutes(horaInicio.getMinutes()+5);
				}
				if(!encontrado){
					return 1;
				}
				return daoSesion.update(tSesion);
			}else{
				//ERROR
				return 1;
			}
		}else {
			return 1;
		}
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioSesion#eliminarSesion(Integer idSesion)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int eliminarSesion(Integer idSesion) {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOSesion daoSesion = fact.generaDAOSesion();
		TSesion tsesionAux = daoSesion.read(idSesion);
		GregorianCalendar calendar = new GregorianCalendar();
		Date fechaActual = calendar.getTime();
		if(tsesionAux != null){
			Date fecha = tsesionAux.getFecha();
			Date hora = tsesionAux.getHora();
			if(fechaActual.after(fecha)){
				//Fecha igual o anterior a fecha actual
				if(fecha.getYear() == fechaActual.getYear() && fecha.getMonth() == fechaActual.getMonth() 
						&& fecha.getDate() == fechaActual.getDate()){
					//Fecha igual a fecha actual
					return 1;
				}else{
					//Correcto
					DAOVentas daoVentas = fact.generaDAOVentas();
					if(daoVentas.deleteLineasVentaPorSesion(idSesion) == 0){
						return daoSesion.delete(idSesion);
					}else {
						return 1;
					}							
				}
			}
		}
		return 1;
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioSesion#getAllSesiones()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList getAllSesiones() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		FactoriaIntegracion factIntegracion = FactoriaIntegracion
				.getInstancia();
		DAOSesion daoSesion = factIntegracion.generaDAOSesion();
		return daoSesion.readAll();
		// end-user-code
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioSesion#getAllSesionesPorSala(TSala tSala)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList getAllSesionesPorSala(TSala tSala) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		FactoriaIntegracion factIntegracion = FactoriaIntegracion
				.getInstancia();
		DAOSesion daoSesion = factIntegracion.generaDAOSesion();
		return daoSesion.readPorSala(tSala);
		// end-user-code
	}
	
	@Override
    public ArrayList<Date> getHorasDisponibles(TSala tSala,TPelicula tPelicula,Date fecha) {
        FactoriaIntegracion factIntegracion = FactoriaIntegracion.getInstancia();
        DAOSesion daoSesion = factIntegracion.generaDAOSesion();         
        ArrayList<TSesion> tSesiones = daoSesion.readPorSalaFecha(tSala.getIdSala(), fecha);
        ArrayList<Date> horasOcupadas = new ArrayList();
        Date horaFin = null;

        for (TSesion tSesion : tSesiones) {
            Date hora = (Date) tSesion.getHora().clone();
            horaFin = (Date) hora.clone();
            horaFin.setMinutes(((Date) hora.clone()).getMinutes()+tSesion.gettPelicula().getDuracion());  
            hora.setMinutes(hora.getMinutes()-tPelicula.getDuracion());
            while(hora.getHours() < horaFin.getHours() || 
                    (hora.getHours() == horaFin.getHours() &&  hora.getMinutes() < horaFin.getMinutes())){  
                if(!horasOcupadas.contains(hora)){
                    horasOcupadas.add(hora);
                }                
                hora = (Date) hora.clone();
                hora.setMinutes(hora.getMinutes()+5);
            }
            horasOcupadas.add(horaFin);
        }
        ArrayList<Date> horasDisponibles = new ArrayList();
        Date hora = new Date();
        hora.setHours(12);
        hora.setMinutes(00);
        boolean contiene;
        do{
            contiene = false;
            for (Date date : horasOcupadas) {
                if(date.getHours() == hora.getHours() && date.getMinutes() == hora.getMinutes()){
                    contiene = true;
                    hora = (Date) hora.clone();
                    hora.setMinutes(hora.getMinutes()+5);
                    break;
                }
            }
        }while(contiene && hora.getHours() != 0);
        if(!contiene){
            horasDisponibles.add(hora);
            hora = (Date) hora.clone();
            hora.setMinutes(hora.getMinutes()+5);
            while(hora.getHours() != 0){
                contiene = false;
                for (Date date : horasOcupadas) {
                    if(date.getHours() == hora.getHours() && date.getMinutes() == hora.getMinutes()){
                        contiene = true;
                        break;
                    }
                }
                if(!contiene){
                   horasDisponibles.add(hora); 
                }
                hora = (Date) hora.clone();
                hora.setMinutes(hora.getMinutes()+5);
                                
            }
        }      
        return horasDisponibles;
    }

    @Override
    public ArrayList<TSesion> getAllSesionesPorPeliculaFecha(TPelicula tPelicula,Date fecha) {
        FactoriaIntegracion factIntegracion = FactoriaIntegracion
				.getInstancia();
        DAOSesion daoSesion = factIntegracion.generaDAOSesion();
        return daoSesion.readPorPeliculaFecha(tPelicula.getIdPelicula(),fecha);
    }

	@Override
	public ArrayList<TSesion> getAllSesionesPorFecha(Date fecha) {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factIntegracion = FactoriaIntegracion
				.getInstancia();
        DAOSesion daoSesion = factIntegracion.generaDAOSesion();
        return daoSesion.readPorFecha(fecha);
	}
	
	public ArrayList<TSesion> getAllSesionesPorSalaFecha(int idSala,Date fecha) {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factIntegracion = FactoriaIntegracion
				.getInstancia();
        DAOSesion daoSesion = factIntegracion.generaDAOSesion();
        return daoSesion.readPorSalaFecha(idSala, fecha);
	}
    
}