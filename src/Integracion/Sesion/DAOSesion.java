/**
 * 
 */
package Integracion.Sesion;

import Negocio.Sesion.TSesion;
import java.util.ArrayList;
import java.util.Date;

import Negocio.Sala.TSala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOSesion {

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve una sesion a partir de un identificador de sesion
	 * <!-- end-UML-doc -->
	 * @param idSesion Identificador de sesion
	 * @return TSesion si existe o null si no existe
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TSesion read(Integer idSesion);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las sesiones
	 * <!-- end-UML-doc -->
	 * @return ArrayList de sesiones
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList readAll();

	/**
	 * Borra una sesion a partir de un identificador de sesion
	 * @param idSesion identificador de sesion
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int delete(Integer idSesion);

	/**
	 * Actualiza la informacion una sesion a partir de un identificador de sesion
	 * @param tSesion Informaciond de la sesion
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int update(TSesion tSesion);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las sesiones asocidadas a una sala 
	 * <!-- end-UML-doc -->
	 * @param tSala Informacion de la sala
	 * @return ArrayList de sesiones
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList readPorSala(TSala tSala);

	/**
	 * Crea una sesion
	 * @param tSesion Informacion de la sesion
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int create(TSesion tSesion);

	/**
	 * Devuelve todas las sesiones asociadas a una pelicula
	 * @param idPelicula identificador de la pelicula
	 * @return ArrayList de sesiones
	 */
    public ArrayList<TSesion> readPorPelicula(Integer idPelicula);
    /**
     * Devuelve todas las sesiones asociadas a una pelicula y una fecha
     * @param idPelicula identificador de la pelicula
     * @param fecha Fecha
     * @return ArrayList de sesiones
     */
    public ArrayList<TSesion> readPorPeliculaFecha(Integer idPelicula,Date fecha);
    /**
     * Devuelve todas las sesiones asociadas a una fecha
     * @param fecha Fecha
     * @return ArrayList de sesiones
     */
    public ArrayList<TSesion> readPorFecha(Date fecha);
    /**
     * Devuelve todas las sesiones asociadas a una sala y una fecha
     * @param idSala identificador de sala
     * @param fecha
     * @return ArrayList de sesiones
     */
    public ArrayList readPorSalaFecha(int idSala,Date fecha);
}