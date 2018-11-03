/**
 * 
 */
package Negocio.Pelicula;

import java.awt.Image;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Imagen {
	/** 
	 * <!-- begin-UML-doc -->
	 * Objecto image que guarda la imagen
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Image imagen;

	/** 
	 * @return the imagen
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Image getImagen() {
		// begin-user-code
		return imagen;
		// end-user-code
	}

	/** 
	 * @param imagen the imagen to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setImagen(Image imagen) {
		// begin-user-code
		this.imagen = imagen;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Ruta de la imagen
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String ruta;

	/** 
	 * @return the ruta
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getRuta() {
		// begin-user-code
		return ruta;
		// end-user-code
	}

	/** 
	 * @param ruta the ruta to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setRuta(String ruta) {
		// begin-user-code
		this.ruta = ruta;
		// end-user-code
	}

	public Imagen(Image imagen, String ruta) {
		this.imagen = imagen;
		this.ruta = ruta;
	}
}