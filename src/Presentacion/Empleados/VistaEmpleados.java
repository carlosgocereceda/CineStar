package Presentacion.Empleados;


public abstract class VistaEmpleados {
	private static VistaEmpleados instancia;
	
	public static VistaEmpleados getInstancia(){
		if(instancia == null){
			instancia = new VistaEmpleadosImp();
		}
		return instancia;
	}
	
	public abstract void update(int event,Object object);

}

