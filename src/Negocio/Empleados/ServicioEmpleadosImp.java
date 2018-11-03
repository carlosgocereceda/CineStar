/**
 * 
 */
package Negocio.Empleados;

import java.util.ArrayList;

import Integracion.Empleados.DAOEmpleados;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Ventas.DAOVentas;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioEmpleadosImp implements ServicioEmpleados {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */


	
	/** 
	 * (non-Javadoc)
	 * @see ServicioEmpleados#CrearEmpleado()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer DarDeAltaEmpleado(TEmpleado tEmpleado) {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOEmpleados daoempleados = fact.generaDAOEmpleados();
		//HAY QUE CAMBIARLO POR READBYDNI PERO NO HE PROBADO SI FUNCIONA
		//TEmpleado tEmpleadoAux = daoempleados.readByDNI(tEmpleado.getDni());
		TEmpleado tEmpleadoAux = daoempleados.read(tEmpleado.getIdEmpleado());
		if (tEmpleadoAux == null) {
			tEmpleadoAux = daoempleados.readByDNI(tEmpleado.getDni());
			if(tEmpleadoAux == null){
				daoempleados.create(tEmpleado);
				return 0;
			}else{
				return 1;
			}			
		}
		else{
			return 1;
		}
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioEmpleados#EliminarEmpleado()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer DarDeBajaEmpleado(Integer idEmp) {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOEmpleados daoempleados = fact.generaDAOEmpleados();
		TEmpleado tEmpleadoAux = daoempleados.read(idEmp);
		if (tEmpleadoAux != null) {
			DAOVentas daoVenta = fact.generaDAOVentas();
			daoVenta.deleteByIDEmpleado(idEmp);
			daoempleados.delete(idEmp);
			return 0;
		}
		else{
			return 1;
		}
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioEmpleados#ModificarEmpleado()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer ModificarEmpleado(TEmpleado tEmpleado) {
		FactoriaIntegracion fact = FactoriaIntegracion.getInstancia();
		DAOEmpleados daoempleados = fact.generaDAOEmpleados();
		TEmpleado tEmpleadoAux = daoempleados.read(tEmpleado.getIdEmpleado());
		if (tEmpleadoAux != null) {
			daoempleados.update(tEmpleado);
			return 0;
		}
		else{
			return 1;
		}
	}

	@Override
	public ArrayList<TEmpleado> getAllEmpleados() {
		// TODO Apéndice de método generado automáticamente
		FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
        DAOEmpleados daoEmpleados = factInteg.generaDAOEmpleados();
        return daoEmpleados.readAll();
	}

	/** 
	 * (non-Javadoc)
	 * @see ServicioEmpleados#MostrarEmpleados()
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public TEmpleado getEmpleado(int idEmpleado){
        FactoriaIntegracion factInteg = FactoriaIntegracion.getInstancia();
        DAOEmpleados daoEmpleados = factInteg.generaDAOEmpleados();
        return daoEmpleados.read(idEmpleado);
    }
	
}