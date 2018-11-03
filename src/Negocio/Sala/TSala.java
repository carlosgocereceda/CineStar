/**
 * 
 */
package Negocio.Sala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TSala {

	public TSala(boolean estado, int filas, int columnas, String nombre) {
		this.estado = estado;
		this.filas = filas;
		this.columnas = columnas;
		this.nombre = nombre;
	}

	public TSala(int id, boolean estado, int filas, int columnas, String nombre) {
		this.estado = estado;
		this.filas = filas;
		this.columnas = columnas;
		this.nombre = nombre;
		this.idSala = id;
	}

	/** 
	 * <!-- begin-UML-doc -->
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
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int columnas;

	/** 
	 * @return the columnas
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getColumnas() {
		// begin-user-code
		return columnas;
		// end-user-code
	}

	/** 
	 * @param columnas the columnas to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setColumnas(int columnas) {
		// begin-user-code
		this.columnas = columnas;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int filas;

	/** 
	 * @return the filas
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int getFilas() {
		// begin-user-code
		return filas;
		// end-user-code
	}

	/** 
	 * @param filas the filas to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFilas(int filas) {
		// begin-user-code
		this.filas = filas;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String nombre;

	/** 
	 * @return the nombre
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getNombre() {
		// begin-user-code
		return nombre;
		// end-user-code
	}

	/** 
	 * @param nombre the nombre to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNombre(String nombre) {
		// begin-user-code
		this.nombre = nombre;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer idSala;

	/** 
	 * @return the idSala
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getIdSala() {
		// begin-user-code
		return idSala;
		// end-user-code
	}

	/** 
	 * @param idSala the idSala to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIdSala(Integer idSala) {
		// begin-user-code
		this.idSala = idSala;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param estado
	 * @param filas
	 * @param columnas
	 * @param nombre
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TSala(boolean estado, Integer filas, Integer columnas, String nombre) {
		// begin-user-code
		// TODO Apéndice de constructor generado automáticamente
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idSala
	 * @param estado
	 * @param filas
	 * @param columnas
	 * @param nombre
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TSala(Integer idSala, boolean estado, Integer filas,
			Integer columnas, String nombre) {
		// begin-user-code
		// TODO Apéndice de constructor generado automáticamente
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String toString() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.nombre;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param obj
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean equals(Object obj) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TSala tSala1 = (TSala) obj;
		if (idSala == null || tSala1.idSala == null) {
			if (nombre.compareToIgnoreCase(tSala1.nombre) == 0
					&& this.columnas == tSala1.columnas
					&& filas == tSala1.filas && estado == tSala1.estado) {
				return true;
			}
			return false;
		} else if (idSala == tSala1.idSala) {
			return true;
		}
		return false;
		// end-user-code
	}
}