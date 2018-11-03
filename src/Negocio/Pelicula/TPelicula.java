/**
 * 
 */
package Negocio.Pelicula;

import Negocio.Pelicula.Imagen;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author gerar
 */
public class TPelicula {

	public TPelicula(int idPelicula, String titulo, Integer duracion,
			String clasificacion, boolean estado, Imagen imagen) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.estado = estado;
		this.imagen = imagen;
	}

	public TPelicula(String titulo, Integer duracion, String clasificacion,
			boolean estado, Imagen imagen) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.estado = estado;
		this.imagen = imagen;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Titulo de la pelicula
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String titulo;

	/** 
	 * @return the titulo
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getTitulo() {
		// begin-user-code
		return titulo;
		// end-user-code
	}

	/** 
	 * @param titulo the titulo to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setTitulo(String titulo) {
		// begin-user-code
		this.titulo = titulo;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Identificador de la pelicula
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer idPelicula;

	/** 
	 * @return the idPelicula
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getIdPelicula() {
		// begin-user-code
		return idPelicula;
		// end-user-code
	}

	/** 
	 * @param idPelicula the idPelicula to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIdPelicula(Integer idPelicula) {
		// begin-user-code
		this.idPelicula = idPelicula;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Duraciond de la pelicula
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer duracion;

	/** 
	 * @return the duracion
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getDuracion() {
		// begin-user-code
		return duracion;
		// end-user-code
	}

	/** 
	 * @param duracion the duracion to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDuracion(Integer duracion) {
		// begin-user-code
		this.duracion = duracion;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Clasificacion de la pelicula
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String clasificacion;

	/** 
	 * @return the clasificacion
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getClasificacion() {
		// begin-user-code
		return clasificacion;
		// end-user-code
	}

	/** 
	 * @param clasificacion the clasificacion to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setClasificacion(String clasificacion) {
		// begin-user-code
		this.clasificacion = clasificacion;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Estado de la pelicula(0 habilitada 1 deshabilitada)
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean estado;

	/** 
	 * @return the estado
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean isEstado() {
		// begin-user-code
		return estado;
		// end-user-code
	}

	/** 
	 * @param estado the estado to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setEstado(boolean estado) {
		// begin-user-code
		this.estado = estado;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Imagen de la pelicula
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Imagen imagen;

	/** 
	 * @return the imagen
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Imagen getImagen() {
		// begin-user-code
		return imagen;
		// end-user-code
	}

	/** 
	 * @param imagen the imagen to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setImagen(Imagen imagen) {
		// begin-user-code
		this.imagen = imagen;
		// end-user-code
	}

	@Override
	public String toString() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.titulo;
		// end-user-code
	}

	@Override
	public boolean equals(Object obj) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TPelicula tPelicula1 = (TPelicula) obj;

		if (idPelicula == null || tPelicula1.idPelicula == null) {
			if (titulo.compareToIgnoreCase(tPelicula1.titulo) == 0
					&& duracion == tPelicula1.duracion
					&& clasificacion
							.compareToIgnoreCase(tPelicula1.clasificacion) == 0
					&& estado == tPelicula1.estado) {
				return true;
			}
			return false;
		} else if (idPelicula == tPelicula1.idPelicula) {
			return true;
		}
		return false;
		// end-user-code
	}
}