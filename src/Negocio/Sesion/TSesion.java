/**
 * 
 */
package Negocio.Sesion;

import Negocio.Pelicula.TPelicula;
import Negocio.Sala.TSala;
import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TSesion {

	/** 
	 * <!-- begin-UML-doc -->
	 * Identificador de la sesion
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer idSesion;

	/** 
	 * @return the idSesion
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getIdSesion() {
		// begin-user-code
		return idSesion;
		// end-user-code
	}

	/** 
	 * @param idSesion the idSesion to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIdSesion(Integer idSesion) {
		// begin-user-code
		this.idSesion = idSesion;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Informaciond de la pelicula de la sesion
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

	/** 
	 * <!-- begin-UML-doc -->
	 * Informacionde la sala
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private TSala tSala;

	/** 
	 * @return the tSala
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TSala gettSala() {
		// begin-user-code
		return tSala;
		// end-user-code
	}

	/** 
	 * @param tSala the tSala to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void settSala(TSala tSala) {
		// begin-user-code
		this.tSala = tSala;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Fecha de la sesion
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date fecha;

	/** 
	 * @return the fecha
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getFecha() {
		// begin-user-code
		return fecha;
		// end-user-code
	}

	/** 
	 * @param fecha the fecha to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFecha(Date fecha) {
		// begin-user-code
		this.fecha = fecha;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Cantidas de plazas libres de la sesion
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer cantLibres;

	/** 
	 * @return the cantLibres
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getCantLibres() {
		// begin-user-code
		return cantLibres;
		// end-user-code
	}

	/** 
	 * @param cantLibres the cantLibres to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setCantLibres(Integer cantLibres) {
		// begin-user-code
		this.cantLibres = cantLibres;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Precio por entrada de la sesion
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private float precioUnitario;

	/** 
	 * @return the precioUnitario
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public float getPrecioUnitario() {
		// begin-user-code
		return precioUnitario;
		// end-user-code
	}

	/** 
	 * @param precioUnitario the precioUnitario to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPrecioUnitario(float precioUnitario) {
		// begin-user-code
		this.precioUnitario = precioUnitario;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * Hora de la sesion
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Date hora;

	/** 
	 * @return the hora
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Date getHora() {
		// begin-user-code
		return hora;
		// end-user-code
	}

	/** 
	 * @param hora the hora to set
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setHora(Date hora) {
		// begin-user-code
		this.hora = hora;
		// end-user-code
	}

	@Override
	public boolean equals(Object obj) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TSesion tSesion1 = (TSesion) obj;

		if (this.idSesion == null || tSesion1.idSesion == null) {
			if (this.tSala.equals(tSesion1.tSala)
					&& this.tPelicula.equals(tSesion1.tPelicula)
					&& fecha == tSesion1.fecha && hora == tSesion1.hora) {
				return true;
			}
			return false;
		} else if (this.idSesion == tSesion1.idSesion) {
			return true;
		}
		return false;
		// end-user-code
	}

	public TSesion(Integer idSesion, TPelicula tPelicula, TSala tSala,
			Date fecha, Date hora, Integer cantLibres, Float precioUnitario) {
		this.idSesion = idSesion;
		this.tPelicula = tPelicula;
		this.tSala = tSala;
		this.fecha = fecha;
		this.hora = hora;
		this.cantLibres = cantLibres;
		this.precioUnitario = precioUnitario;
	}

	public TSesion(TPelicula tPelicula, TSala tSala, Date fecha, Date hora,
			Integer cantLibres, Float precioUnitario) {
		this.tPelicula = tPelicula;
		this.tSala = tSala;
		this.fecha = fecha;
		this.hora = hora;
		this.cantLibres = cantLibres;
		this.precioUnitario = precioUnitario;
	}
        
    @Override
    public TSesion clone(){
        TSesion tSesion = new TSesion(this.idSesion,this.tPelicula,this.tSala, (Date) fecha.clone(), (Date) hora.clone(),cantLibres,precioUnitario);
        return tSesion;
    }
}