package Negocio.Ventas;

import Negocio.Sesion.TSesion;

public class LineaVenta {
	/**
	 * Sesion de la linea de venta
	 */
	private TSesion tSesion;
	/**
	 * Cantidad de la linea de venta
	 */
	private int cant;
	
	public LineaVenta(TSesion tSesion,int cant){
		this.tSesion = tSesion;
		this.cant = cant;
	}

	public TSesion gettSesion() {
		return tSesion;
	}

	public void settSesion(TSesion tSesion) {
		this.tSesion = tSesion;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	
}
