/**
 * 
 */
package Negocio.Ventas;

import Negocio.Empleados.TEmpleado;
import Negocio.Sesion.TSesion;
import java.util.HashMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TVenta {
	

	/** 
	 * <!-- begin-UML-doc -->
	 * Identificador de la venta
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer idVenta;

	/** 
	 * @return the idVenta
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getIdVenta() {
		// begin-user-code
		return idVenta;
		// end-user-code
	}

	/** 
	 * @param idVenta the idVenta to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIdVenta(Integer idVenta) {
		// begin-user-code
		this.idVenta = idVenta;
		// end-user-code
	}
	/**
	 * HashMap de las lineas de venta con el identificador es el id de sesion de la linea de venta 
	 * y el valor es la linea de venta.
	 */
	private HashMap<Integer,LineaVenta> lineasVentas;

    public HashMap<Integer,LineaVenta> getLineasVentas() {
        return lineasVentas;
    }

    public void setLineasVentas(HashMap<Integer,LineaVenta> lineasVentas) {
        this.lineasVentas = lineasVentas;
    }
       
    public TEmpleado tEmpleado;
    
    /**
     * Asigna un vendedor a la venta.
     * @param tEmpleado
     */
    public void asignarVendedor(TEmpleado tEmpleado){
    	this.tEmpleado = tEmpleado;
    }
    
    public TEmpleado gettEmpleado(){
    	return tEmpleado;
    }

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta(HashMap<Integer,LineaVenta> lineasVentas) {
		// begin-user-code
		// TODO Auto-generated constructor stub
                this.lineasVentas = lineasVentas;
		// end-user-code
	}
	public TVenta(Integer idVenta,HashMap<Integer,LineaVenta> lineasVentas) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		this.idVenta = idVenta;
        this.lineasVentas = lineasVentas;
		// end-user-code
	}
	public TVenta(Integer idVenta,HashMap<Integer,LineaVenta> lineasVentas,TEmpleado tEmpleado) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		this.idVenta = idVenta;
        this.lineasVentas = lineasVentas;
        this.tEmpleado = tEmpleado;
		// end-user-code
	}
        
        public TVenta(){
        	lineasVentas = new HashMap();
        }
        
        /**
         * Añade una sesion con una cantidad a la linea de venta de la venta.
         * @param tSesion
         * @param cant
         */
        public void anadirSesion(TSesion tSesion,Integer cant){
        	LineaVenta lineaVenta = new LineaVenta(tSesion,cant);
        	lineasVentas.put(tSesion.getIdSesion(), lineaVenta);
        }

        /**
         * Borra una linea de venta a partir de una sesion
         * @param tSesion
         */
		public void borrarSesion(TSesion tSesion) {
			// TODO Apéndice de método generado automáticamente
			lineasVentas.remove(tSesion.getIdSesion());
		}
		
		/**
		 * Modifica la cantida asociada a la linea de venta.
		 * @param lineaVenta
		 */
		public void modificarSesion(LineaVenta lineaVenta){
			lineasVentas.put(lineaVenta.gettSesion().getIdSesion(), lineaVenta);
		}
}