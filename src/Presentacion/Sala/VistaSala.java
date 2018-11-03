/**
 * 
 */
package Presentacion.Sala;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class VistaSala {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VistaSala instance;

	/** 
	 * @return the instance
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistaSala getInstance() {
		// begin-user-code
		return instance;
		// end-user-code
	}

	/** 
	 * @param instance the instance to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setInstance(VistaSala instance) {
		// begin-user-code
		VistaSala.instance = instance;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIAnadirSala gUIAnadirSala;

	/** 
	 * @return the gUIAnadirSala
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public GUIAnadirSala getgUIAnadirSala() {
		// begin-user-code
		return gUIAnadirSala;
		// end-user-code
	}

	/** 
	 * @param gUIAnadirSala the gUIAnadirSala to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setgUIAnadirSala(GUIAnadirSala gUIAnadirSala) {
		// begin-user-code
		this.gUIAnadirSala = gUIAnadirSala;
		// end-user-code
	}


	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param event
	 * @param object
	 */
	public abstract void update(Integer event, Object object);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistaSala getInstancia() {
		// begin-user-code
		// TODO Auto-generated method stub
		if(instance == null){
			instance = new VistaSalaImp();
		}
		return instance;
		// end-user-code
	}
}