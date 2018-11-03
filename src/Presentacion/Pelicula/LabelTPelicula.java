/**
 * 
 */
package Presentacion.Pelicula;

import javax.swing.JLabel;
import Negocio.Pelicula.TPelicula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class LabelTPelicula extends JLabel {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private TPelicula tPelicula;

	/** 
	 * @return the tPelicula
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TPelicula gettPelicula() {
		// begin-user-code
		return tPelicula;
		// end-user-code
	}

	/** 
	 * @param tPelicula the tPelicula to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void settPelicula(TPelicula tPelicula) {
		// begin-user-code
		this.tPelicula = tPelicula;
		// end-user-code
	}

	public LabelTPelicula(TPelicula tPelicula) {
		super();
		this.tPelicula = tPelicula;
		super.setText(tPelicula.getTitulo());
	}
}