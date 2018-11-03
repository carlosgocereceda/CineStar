/**
 * 
 */
package Negocio.Pelicula;

import java.util.ArrayList;
import java.util.Date;

import Negocio.Pelicula.TPelicula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ServicioPelicula {
	/**
	 * Comprueba que contenga toda la informacion de la pelicula y tambien si existe 
	 * alguna pelicula con el mismo titulo
	 * @param tPelicula Informacion de la pelicula
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public Integer anadirPelicula(TPelicula tPelicula);

	/**
	 * Comprueba que la pelicula no tenga ninguna sesion asociada si es asi 
	 * elimina la pelicula
	 * @param idPelicula id de la pelicula
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public Integer eliminarPelicula(Integer idPelicula);

	/**
	 * Comprueba que la pelicula no tenga ninguna sesion asociada
	 * si es asi modifica la pelicula
	 * @param tPelicula informacion de la pelicula
	 * @return 0 si no ocurre ningun fallo o 1 si ocurre algun fallo
	 */
	public Integer modificarPelicula(TPelicula tPelicula);

	/** 
	 * <!-- begin-UML-doc -->
	 * Devuelve todas las peliculas
	 * <!-- end-UML-doc -->
	 * @return ArrayList de peliculas
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList getAllPeliculas();
	/**
	 * Devuelve todas las peliculas asociadas a una fecha
	 * @param fecha
	 * @return ArrayList de peliculas
	 */
	public ArrayList getAllPeliculasPorSesionFecha(Date fecha);
}