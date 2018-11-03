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
public class TEmpleadoFijo extends TEmpleado{
	/**
	 * Sueldo del empleado
	 */
    private float sueldo;
    
    public TEmpleadoFijo(String Dni,String nombre, String apellidos, String password,float sueldo){
        super(Dni,nombre,apellidos,"Fijo",password);
        this.sueldo = sueldo;
    }
    public TEmpleadoFijo(int idEmpleado,String Dni,String nombre, String apellidos, String password,float sueldo){
        super(idEmpleado,Dni,nombre,apellidos,"Fijo",password);
        this.sueldo = sueldo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
