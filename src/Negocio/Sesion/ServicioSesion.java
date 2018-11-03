/**
 * 
 */
package Negocio.Sesion;

import java.util.ArrayList;
import java.util.Date;

import Negocio.Pelicula.TPelicula;
import Negocio.Sala.TSala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author gerar
 */
public interface ServicioSesion {
	/**
	 * Crea una sesion a partir de un TSesion comprobando que la sala seleccionada no este deshabilitada
	 * y que la fecha sea posterior a la fecha actual 
	 * @param tSesion
	 * @return 0 si todo es correcto sino 1 por error
	 */
	public int crearSesion(TSesion tSesion);

	/**
	 * Comprueba que la sesion que se va a actualizar existe y que la sala seleccionada no este deshabilitada 
	 * y que la fecha sea posterior a la fecha actual si todo es correcto se actualizan
	 * @param tSesion
	 * @return 0 si todo es correcto sino 1 por error
	 */
	public int modificarSesion(TSesion tSesion);

	/**
	 * Comprueba que la sesion que se va a actualizar existe y que la fecha es anterior a la fecha actual
	 * si todo es correcto borra tambien las lineas de venta asociadas a la sesion.
	 * @param idSesion
	 * @return 0 si todo es correcto sino 1 por error
	 */
	public int eliminarSesion(Integer idSesion);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las sesiones.
	 * <!-- end-UML-doc -->
	 * @return Arraylist que contiene todas las sesiones.
	 */
	public ArrayList<TSesion> getAllSesiones();

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las sesiones asociadas a una sala
	 * <!-- end-UML-doc -->
	 * @param tSala
	 * @return ArrayList que contiene todas las sesiones.
	 */
	public ArrayList<TSesion> getAllSesionesPorSala(TSala tSala);
	/**
	 * Devuelve todas las sesiones asociadas a una pelicula y una fecha
	 * @param tPelicula
	 * @param fecha
	 * @return ArrayList que contiene todas las sesiones.
	 */
    public ArrayList<TSesion> getAllSesionesPorPeliculaFecha(TPelicula tPelicula,Date fecha);
    /**
     * Devuelve todas las sesiones asociadas a una fecha
     * @param fecha
     * @return ArrayList que contiene todas las sesiones.
     */
    public ArrayList<TSesion> getAllSesionesPorFecha(Date fecha);
    /**
     * Devuelve todas las sesiones asocidas a una sala y una fecha.
     * @param idSala
     * @param fecha
     * @return ArrayList que contiene todas las sesiones.
     */
    public ArrayList<TSesion> getAllSesionesPorSalaFecha(int idSala,Date fecha); 
    /**
     * Devuelve todas las horas disponibles de una sala para una pelicula en una fecha determinada.
     * @param tSala
     * @param tPelicula
     * @param fecha
     * @return ArrayList que contiene todas las horas disponibles.
     */
    public ArrayList<Date> getHorasDisponibles(TSala tSala,TPelicula tPelicula,Date fecha);
}