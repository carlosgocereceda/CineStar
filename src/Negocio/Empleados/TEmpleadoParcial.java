/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Empleados;


/**
 *
 * @author gerar
 */
public class TEmpleadoParcial extends TEmpleado{
	/**
	 * Horas que trabaja el empleado a la semana
	 */
    private int horas;
    /**
     * Precio por hora del empleado
     */
    private float precioHora;
    
    
    public TEmpleadoParcial(String Dni, String nombre, String apellidos, String password,int horas,float precioHora) {
        super(Dni, nombre, apellidos, "Parcial", password);
        this.horas = horas;
        this.precioHora = precioHora;
    }

    public TEmpleadoParcial(int idEmpleado,String Dni, String nombre, String apellidos, String password,int horas,float precioHora) {
        super(idEmpleado,Dni, nombre, apellidos, "Parcial", password);
        this.horas = horas;
        this.precioHora = precioHora;
    }

	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public float getPrecioHora() {
		return precioHora;
	}


	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
    
    
}
