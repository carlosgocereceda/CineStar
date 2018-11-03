/**
 * 
 */
package Integracion.Pelicula;

import Negocio.Pelicula.TPelicula;
import java.util.ArrayList;
import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author gerar
 */
public interface DAOPelicula {
	/**
	 * Crea una pelicula
	 * @param tPelicula Informacion de la pelicula
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int create(TPelicula tPelicula);

	/**
	 * Borra una pelicula a partir de un identificador de pelicula
	 * @param idPelicula Identificador de pelicula
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int delete(Integer idPelicula);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve la informacion de una pelicula a partir de un nombre
	 * <!-- end-UML-doc -->
	 * @param nombre Nombre de la pelicula
	 * @return TPelicula si existe y null si no existe
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TPelicula read(String nombre);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las peliculas
	 * <!-- end-UML-doc -->
	 * @return ArrayList de peliculas
	 */
	public ArrayList<TPelicula> readAll();

	/**
	 * Actualiza la informacion de una pelicula
	 * @param tPelicula Informacion de una pelicula
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public int update(TPelicula tPelicula);
	/**
	 * Devuelve todas las peliculas asocidadas a una fecha
	 * @param fecha Fecha
	 * @return ArrayList de peliculas
	 */
	public ArrayList readAllPorSesionFecha(Date fecha);
}