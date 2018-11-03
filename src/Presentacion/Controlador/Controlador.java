/**
 * 
 */
package Presentacion.Controlador;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Controlador {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static Controlador instancia;

	/** 
	 * @return the instancia
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Controlador getInstancia() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if (instancia == null) {
			instancia = new ControladorImp();
		}
		return instancia;
		// end-user-code
	}

	/** 
	 * @param instancia the instancia to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setInstancia(Controlador instancia) {
		// begin-user-code
		Controlador.instancia = instancia;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int ANADIR_SALA = 1;

	/** 
	 * @return the ANADIR_SALA
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getANADIR_SALA() {
		// begin-user-code
		return ANADIR_SALA;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int MODIFICAR_SALA = 2;

	/** 
	 * @return the MODIFICAR_SALA
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getMODIFICAR_SALA() {
		// begin-user-code
		return MODIFICAR_SALA;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int BORRAR_SALA = 3;

	/** 
	 * @return the BORRAR_SALA
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getBORRAR_SALA() {
		// begin-user-code
		return BORRAR_SALA;
		// end-user-code
	}
	public static final int VER_SALAS = 11;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int ANADIR_PELICULA = 4;

	/** 
	 * @return the ANADIR_PELICULA
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getANADIR_PELICULA() {
		// begin-user-code
		return ANADIR_PELICULA;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int MODIFICAR_PELICULA = 5;

	/** 
	 * @return the MODIFICAR_PELICULA
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getMODIFICAR_PELICULA() {
		// begin-user-code
		return MODIFICAR_PELICULA;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int BORRAR_PELICULA = 6;

	/** 
	 * @return the BORRAR_PELICULA
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getBORRAR_PELICULA() {
		// begin-user-code
		return BORRAR_PELICULA;
		// end-user-code
	}

	public static final int VER_PELICULAS = 12;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int ANADIR_SESION = 7;

	/** 
	 * @return the ANADIR_SESION
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getANADIR_SESION() {
		// begin-user-code
		return ANADIR_SESION;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int MODIFICAR_SESION = 8;

	/** 
	 * @return the BORRAR_SESION
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getMODIFICAR_SESION() {
		// begin-user-code
		return MODIFICAR_SESION;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int ELIMINAR_SESION = 9;

	/** 
	 * @return the ELIMINAR_SESION
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static final int getELIMINAR_SESION() {
		// begin-user-code
		return ELIMINAR_SESION;
		// end-user-code
	}
	public static final int VER_SESIONES = 13;
	public static final int VER_ANADIR_SESION = 14;
    public static final int VER_MODIFICAR_SESION = 15;
	public static final int VER_VENTAS = 16;
	public static final int REALIZAR_NUEVA_VENTA = 17;
    public static final int VER_REALIZAR_NUEVA_VENTA_PELICULA = 18;
	public static final int VER_VENTAS_VER_MODIFICAR = 19;
	public static final int NOTIFICA_RESULTADO_SALA = 20;
	public static final int NOTIFICA_RESULTADO_PELICULA = 21;
	public static final int NOTIFICA_RESULTADO_SESION = 22;
	public static final int ANADIR_EMPLEADO = 23;
	public static final int ELIMINAR_EMPLEADO = 24;
	public static final int MODIFICAR_EMPLEADO = 25;
	public static final int NOTIFICA_RESULTADO_EMPLEADO = 26;
	public static final int VER_EMPLEADOS = 27;
    public static final int VER_ANADIR_EMPLEADO = 28;
    public static final int VER_MODIFICAR_EMPLEADO = 29;
	public static final int VER_ANADIR_PELICULA = 30;
	public static final int VER_MODIFICAR_PELICULA = 31;
	public static final int VER_MODIFICAR_SALA = 32;
	public static final int VER_ANADIR_SALA = 10;
	public static final int CERRAR_VENTA = 33;
	public static final int MODIFICAR_VENTA = 36;
	public static final int ELIMINAR_VENTA = 38;
	public static final int ELIMINAR_LINEA_VENTA = 37;
	public static final int VER_TODAS_VENTAS = 34;
	public static final int VER_TODAS_VENTAS_VER_MODIFICAR = 39;
	public static final int VER_MODIFICAR_VENTA = 35;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param data
	 * @param evento
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void accion(Object data, Integer evento);
	
	public abstract void start();
}