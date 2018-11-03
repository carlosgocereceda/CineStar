/**
 * 
 */
package Negocio.Empleados;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TEmpleado {
	
	public TEmpleado(String Dni,String nombre, String apellidos,String tipo, String password){
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Dni = Dni;
        this.tipo = tipo;
		this.Password = password;
	}
	
	public TEmpleado(int idEmpleado,String Dni,String nombre, String apellidos,String tipo, String password){
		this.idEmpleado = idEmpleado;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Dni = Dni;
        this.tipo = tipo;
		this.Password = password;
	}
	/**
	 * Identificador del empleado
	 */
	private int idEmpleado;
	
	public int getIdEmpleado(){
		return idEmpleado;
	}
	
	public void setIdEmpleado(int idEmpleado){
		this.idEmpleado = idEmpleado;
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * Nombre del empleado
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String Nombre;

	/** 
	 * @return the Nombre
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getNombre() {
		// begin-user-code
		return Nombre;
		// end-user-code
	}

	/** 
	 * @param Nombre the Nombre to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNombre(String Nombre) {
		// begin-user-code
		this.Nombre = Nombre;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Apellidos del empleado
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String Apellidos;

	/** 
	 * @return the Apellidos
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getApellidos() {
		// begin-user-code
		return Apellidos;
		// end-user-code
	}

	/** 
	 * @param Apellidos the Apellidos to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setApellidos(String Apellidos) {
		// begin-user-code
		this.Apellidos = Apellidos;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * DNI del empleado
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String Dni;

	/** 
	 * @return the Dni
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getDni() {
		// begin-user-code
		return Dni;
		// end-user-code
	}

	/** 
	 * @param Dni the Dni to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDni(String Dni) {
		// begin-user-code
		this.Dni = Dni;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Contraseña del empleado
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String Password;

	/** 
	 * @return the Password
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getPassword() {
		// begin-user-code
		return Password;
		// end-user-code
	}

	/** 
	 * @param Password the Password to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPassword(String Password) {
		// begin-user-code
		this.Password = Password;
		// end-user-code
	}
    /**
     * Tipo de empleado    
     */
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
        
}