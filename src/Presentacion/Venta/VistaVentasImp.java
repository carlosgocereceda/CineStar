package Presentacion.Venta;

import java.util.ArrayList;
import java.util.Date;

import Negocio.Empleados.TEmpleado;
import Negocio.Pelicula.TPelicula;

import Negocio.Sesion.TSesion;
import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TVenta;
import Presentacion.Controlador.Controlador;
import Presentacion.Main.MainFrame;

public class VistaVentasImp extends VistaVentas {

	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Controlador.VER_TODAS_VENTAS:
			Object[] datos = (Object[]) object;
			MainFrame ventana = (MainFrame) datos[0];
			ArrayList<TVenta> tVentas = (ArrayList<TVenta>) datos[1];
			ventana.update(new PanelTodasVentas(tVentas));
			break;
		case Controlador.VER_VENTAS:
			datos = (Object[]) object;
			ventana = (MainFrame) datos[0];
			TVenta tVenta = (TVenta) datos[1];
			ArrayList<TEmpleado> tEmpleados = (ArrayList<TEmpleado>) datos[2];
			ventana.update(new PanelVentas(tVenta,tEmpleados));
			break;
		case Controlador.REALIZAR_NUEVA_VENTA:
			datos = (Object[]) object;
			ventana = (MainFrame) datos[0];
			tVenta = (TVenta) datos[1];
			Date fecha = (Date) datos[2];
			ArrayList<TPelicula> tpeliculas = (ArrayList<TPelicula>) datos[3];
			ventana.update(new PanelVentasPeliculas(tVenta,fecha,tpeliculas));
			break;
        case Controlador.VER_REALIZAR_NUEVA_VENTA_PELICULA:
            datos = (Object[]) object;
            ventana = (MainFrame) datos[0];
            tVenta = (TVenta) datos[1];
            TPelicula tPelicula = (TPelicula) datos[2];
            ArrayList<TSesion> tSesionesPorSala = (ArrayList<TSesion>) datos[3];
            ventana.update(new PanelVentaPeliculaSesiones(tVenta,tPelicula,tSesionesPorSala));
            break;
        case Controlador.VER_VENTAS_VER_MODIFICAR:
            datos = (Object[]) object;
            ventana = (MainFrame) datos[0];
            tVenta = (TVenta) datos[1];
            LineaVenta lineaVenta = (LineaVenta) datos[2];
            tEmpleados = (ArrayList<TEmpleado>) datos[3];
            PanelRealizarVenta realizarVenta = new PanelRealizarVenta(tVenta,lineaVenta);
            realizarVenta.setSize(490, 200);
            ventana.update(new PanelVentas(tVenta,tEmpleados,lineaVenta,realizarVenta));
            break;
        case Controlador.VER_MODIFICAR_VENTA:
        	datos = (Object[]) object;
			ventana = (MainFrame) datos[0];
			tVenta = (TVenta) datos[1];
			tEmpleados = (ArrayList<TEmpleado>) datos[2];
			ventana.update(new PanelVentas(tVenta,tEmpleados));
        	break;
		}
	}
}