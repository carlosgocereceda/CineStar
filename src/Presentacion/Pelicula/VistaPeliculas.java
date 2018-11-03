package Presentacion.Pelicula;

public abstract class VistaPeliculas {
	
	private static VistaPeliculas instancia;
	
	public static VistaPeliculas getInstancia(){
		if(instancia == null){
			instancia = new VistaPeliculasImp();
		}
		return instancia;
	}
	
	public abstract void update(int event,Object object);

}
