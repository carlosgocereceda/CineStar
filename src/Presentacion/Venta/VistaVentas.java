package Presentacion.Venta;



public abstract class VistaVentas {
private static VistaVentas instancia;
	
	public static VistaVentas getInstancia(){
		if(instancia == null){
			instancia = new VistaVentasImp();
		}
		return instancia;
	}
	
	public abstract void update(int event,Object object);

}
	
