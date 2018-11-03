/**
 * 
 */
package Presentacion.Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import Negocio.Empleados.ServicioEmpleados;//
import Negocio.Empleados.TEmpleado;//
import Negocio.Factoria.FactoriaNegocio;//
import Negocio.Pelicula.ServicioPelicula;//
import Negocio.Pelicula.TPelicula;//
import Negocio.Sala.ServicioSala;//
import Negocio.Sala.TSala;//
import Negocio.Sesion.ServicioSesion;//
import Negocio.Sesion.TSesion;//
import Negocio.Ventas.ServicioVentas;//
import Negocio.Ventas.TVenta;//
import Presentacion.Empleados.VistaEmpleados;//
import Presentacion.Main.MainFrame;
import Presentacion.Pelicula.VistaPeliculas;//
import Presentacion.Sala.VistaSala;//
import Presentacion.Sesion.VistaSesion;
import Presentacion.Venta.VistaVentas;//

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorImp extends Controlador {
	MainFrame ventana;

	//Declarar variable en el UML

	/** 
	 * (non-Javadoc)
	 * @see Controlador#accion(Object data, Integer evento)
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accion(Object data, Integer evento) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		switch (evento) {
		//Sala
		case ANADIR_SALA:
			TSala tSala = (TSala) data;
			FactoriaNegocio factNeg = FactoriaNegocio.getInstancia();
			ServicioSala servSala = factNeg.generaServicioSala();
			Integer resultado = servSala.anadirSala(tSala);
			String string_resultado;
			switch(resultado){
			case 0:string_resultado = "Se ha añadido la sala correctamente";break;
			case 1:string_resultado ="Error al añadir Sala. Ya existe una sala con ese nombre";break;
			default:string_resultado = "Error desconocido";break;
			}
			VistaSala.getInstance().update(NOTIFICA_RESULTADO_SALA, string_resultado);
			break;
		case MODIFICAR_SALA:
			tSala = (TSala) data;
			factNeg = FactoriaNegocio.getInstancia();
			servSala = factNeg.generaServicioSala();
			resultado = servSala.modificarSala(tSala);
			switch(resultado){
			case 0:string_resultado = "Se ha modificado la sala correctamente";break;
			case 1:string_resultado = "Error al modificar Sala, la sala " +
					"seleccionada tiene sesiones asociadas"; break;
			case 2:string_resultado = "Error al modificar la sala, la sala no existe"; break;
			default: string_resultado = "Error desconocido"; break;
			}
			VistaSala.getInstance().update(NOTIFICA_RESULTADO_SALA, string_resultado);
			break;
		case BORRAR_SALA:
			tSala = (TSala) data;
			factNeg = FactoriaNegocio.getInstancia();
			servSala = factNeg.generaServicioSala();
			resultado = servSala.eliminarSala(tSala);
			switch(resultado){
			case 0:string_resultado ="Se ha eliminado la sala correctamente";break;
			case 1:string_resultado = "Error al eliminar Sala, la sala " +
					"seleccionada tiene sesiones asociadas";break;
			case 2:string_resultado = "Error al eliminar Sala, la sala no existe";break;
			default:string_resultado = "Error desconocido";break;
			}
			VistaSala.getInstance().update(NOTIFICA_RESULTADO_SALA, string_resultado);
			break;
		case VER_SALAS:
			factNeg = FactoriaNegocio.getInstancia();
			servSala = factNeg.generaServicioSala();
            Object[] datos = new Object[2];
            datos[0] = ventana;
            datos[1] = servSala.getAllSalas();
			VistaSala.getInstancia().update(VER_SALAS, datos);
			break;
		case VER_ANADIR_SALA:
			VistaSala.getInstancia().update(VER_ANADIR_SALA, null);
			break;
		case VER_MODIFICAR_SALA:
			factNeg = FactoriaNegocio.getInstancia();
			servSala = factNeg.generaServicioSala();
			datos = new Object[3];
            datos[0] = ventana;
            datos[1] = servSala.getAllSalas();
            datos[2] = data;
            VistaSala.getInstancia().update(VER_MODIFICAR_SALA, datos);
            break;
		//Pelicula
		case ANADIR_PELICULA:
			TPelicula tPelicula = (TPelicula) data;
			factNeg = FactoriaNegocio.getInstancia();
			ServicioPelicula servPelicula = factNeg.generaServicioPelicula();
			resultado = servPelicula.anadirPelicula(tPelicula);
			switch(resultado){
			case 0:string_resultado = "La película se ha añadido con éxito";break;
			case 1:string_resultado = "La película ya existe"; break;
			default: string_resultado = "Error desconocido"; break;
			}
			VistaPeliculas.getInstancia().update(NOTIFICA_RESULTADO_PELICULA, string_resultado);
			break;
		case MODIFICAR_PELICULA:
			tPelicula = (TPelicula) data;
			factNeg = FactoriaNegocio.getInstancia();
			servPelicula = factNeg.generaServicioPelicula();
			resultado = servPelicula.modificarPelicula(tPelicula);
			switch (resultado){
			case 0:string_resultado = "La película se ha modificado con éxito";break;
			case 1:string_resultado = "Error al modificar la pelicula,tiene sesiones asociadas";break;
			case 2:string_resultado = "La película a moficar no existe"; break;
			default: string_resultado = "Error desconocido";break;
			}
			VistaPeliculas.getInstancia().update(NOTIFICA_RESULTADO_PELICULA, string_resultado);
			break;
		case BORRAR_PELICULA:
			Integer idPelicula = (Integer) data;
			factNeg = FactoriaNegocio.getInstancia();
			servPelicula = factNeg.generaServicioPelicula();
			resultado = servPelicula.eliminarPelicula(idPelicula);
			switch (resultado){
			case 0:string_resultado = "La película se ha eliminado con éxito";break;
			case 1:string_resultado = "Error al eliminar la pelicula,tiene sesiones asociadas";break;
			default: string_resultado = "Error desconocido";break;
			}
			VistaPeliculas.getInstancia().update(NOTIFICA_RESULTADO_PELICULA, string_resultado);
			break;
		case VER_PELICULAS:
			factNeg = FactoriaNegocio.getInstancia();
			servPelicula = factNeg.generaServicioPelicula();
            datos = new Object[2];
            datos[0] = ventana;
            datos[1] = servPelicula.getAllPeliculas();
			VistaPeliculas.getInstancia().update(VER_PELICULAS, datos);
			break;
		case VER_ANADIR_PELICULA:			
			VistaPeliculas.getInstancia().update(Controlador.VER_ANADIR_PELICULA, null);
        	Controlador.getInstancia().accion(null, Controlador.VER_PELICULAS);
			break;
		case VER_MODIFICAR_PELICULA:
			VistaPeliculas.getInstancia().update(Controlador.VER_MODIFICAR_PELICULA, data);
        	Controlador.getInstancia().accion(null, Controlador.VER_PELICULAS);
			break;
		//Sesion
		case ANADIR_SESION:
			TSesion tSesion = (TSesion) data;
			factNeg = FactoriaNegocio.getInstancia();
			ServicioSesion servSesion = factNeg.generaServicioSesion();
			resultado = servSesion.crearSesion(tSesion);
			switch(resultado){
			case 0:string_resultado = "Se ha añadido la sesión con éxito";break;
			case 1:string_resultado =  "No puede crear una sesion con una sala deshabilitada";break;
			default:string_resultado = "Error desconocido";break;
			}
			VistaSesion.getInstance().update(NOTIFICA_RESULTADO_SESION, string_resultado);
			
			break;
		case MODIFICAR_SESION:
			tSesion = (TSesion) data;
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			servSesion.modificarSesion(tSesion);
			break;
		case ELIMINAR_SESION:
			int idSesion = (int) data;
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			servSesion.eliminarSesion(idSesion);
			break;
		case VER_SESIONES:
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			Date fecha;
			if(data  == null){
				GregorianCalendar calendar = new GregorianCalendar();
				fecha = calendar.getTime();
			}else{
				fecha = (Date) data;
			}		
            datos = new Object[3];
            datos[0] = ventana;
            datos[1] = servSesion.getAllSesionesPorFecha(fecha);
            datos[2] = fecha;
			VistaSesion.getInstance().update(VER_SESIONES, datos);
            break;
		case VER_ANADIR_SESION:
			factNeg = FactoriaNegocio.getInstancia();
			servSala = factNeg.generaServicioSala();
			servPelicula = factNeg.generaServicioPelicula();
			servSesion = factNeg.generaServicioSesion();
			datos = new Object[7];
            ArrayList<TSala> tSalas = servSala.getAllSalas();
			datos[0] = tSalas;
                        ArrayList<TPelicula> tPeliculas = servPelicula.getAllPeliculas();
			datos[1] = tPeliculas;
            if(data == null){
                tPelicula = tPeliculas.get(0);
                tSala = tSalas.get(0);
                GregorianCalendar calendar = new GregorianCalendar();
				fecha = calendar.getTime();
            }else{
                Object[] datosTransfer = (Object[]) data;
                tSala = (TSala) datosTransfer[0];
                tPelicula = (TPelicula) datosTransfer[1];
                fecha = (Date) datosTransfer[2];
            }                       
			datos[2] = servSesion.getAllSesionesPorSalaFecha(tSala.getIdSala(), fecha);
            datos[3] = servSesion.getHorasDisponibles(tSala, tPelicula,fecha);
            datos[4] = tSala;
            datos[5] = tPelicula;
            datos[6] = fecha;
            VistaSesion.getInstance().update(VER_ANADIR_SESION, datos);
			break;
                case VER_MODIFICAR_SESION:
                    factNeg = FactoriaNegocio.getInstancia();
                    servSala = factNeg.generaServicioSala();
                    servPelicula = factNeg.generaServicioPelicula();
                    servSesion = factNeg.generaServicioSesion();
                    datos = new Object[8];
                    datos[0] = ventana;
                    tSesion = (TSesion) data;
                    datos[1] = tSesion;
                    tSalas = servSala.getAllSalas();
                    datos[2] = tSalas;
                    tPeliculas = servPelicula.getAllPeliculas();
                    datos[3] = tPeliculas;                    
                    tSala = tSesion.gettSala();
                    tPelicula = tSesion.gettPelicula();                      
                    datos[4] = servSesion.getAllSesionesPorSalaFecha(tSala.getIdSala(), tSesion.getFecha());
                    datos[5] = servSesion.getHorasDisponibles(tSala, tPelicula,tSesion.getFecha());
                    datos[6] = tSala;
                    datos[7] = tPelicula;
                    VistaSesion.getInstance().update(VER_MODIFICAR_SESION, datos);
                    break;
        case CERRAR_VENTA:
        	factNeg = FactoriaNegocio.getInstancia();
        	ServicioVentas servVenta = factNeg.generaServicioVentas();
        	
        	TVenta tVenta = (TVenta) data;
        	int error = servVenta.CerrarVenta(tVenta);
        	switch(error){
        	case 0:
        		datos = new Object[4];
                datos[0] = ventana;
            	tVenta = new TVenta();
            	GregorianCalendar calendar = new GregorianCalendar();
        		fecha = calendar.getTime();               
                datos[1] = tVenta;
                datos[2] = fecha;
                servPelicula = factNeg.generaServicioPelicula();
                datos[3] = servPelicula.getAllPeliculasPorSesionFecha(fecha);
                VistaVentas.getInstancia().update(REALIZAR_NUEVA_VENTA, datos);
    			break;
        	/*case 1:
        		break;
        	case 2:
        		break;
        	case 3:
        		break;*/
    		default:
    			System.out.println("Error");
    			break;
        	}
        	break;
        case MODIFICAR_VENTA:
        	tVenta = (TVenta) data;
        	factNeg = FactoriaNegocio.getInstancia();
        	servVenta = factNeg.generaServicioVentas();
        	servVenta.ModificarVenta(tVenta);
        	break;
        case ELIMINAR_VENTA:
        	Integer idVenta = (Integer) data;
        	factNeg = FactoriaNegocio.getInstancia();
        	servVenta = factNeg.generaServicioVentas();
        	servVenta.AnularVenta(idVenta);
        	break;
        case ELIMINAR_LINEA_VENTA:
        	datos = (Object[]) data;
        	idVenta = (Integer) datos[0];
        	idSesion = (int) datos[1];
        	factNeg = FactoriaNegocio.getInstancia();
        	servVenta = factNeg.generaServicioVentas();
        	servVenta.eliminarLineaVenta(idVenta, idSesion);
        	break;
        case VER_TODAS_VENTAS:
        	factNeg = FactoriaNegocio.getInstancia();
        	ServicioVentas servVentas = factNeg.generaServicioVentas();
        	datos = new Object[2];
			datos[0] = ventana;
			datos[1] = servVentas.getAllVentas();
	        VistaVentas.getInstancia().update(VER_TODAS_VENTAS, datos);
        	break;
		case VER_VENTAS:
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			servPelicula = factNeg.generaServicioPelicula();
	        //datos[2] = servPelicula.getAllPeliculas();
			datos = new Object[3];
			datos[0] = ventana;
			datos[1] = data;
			ServicioEmpleados servEmpleados = factNeg.generaServicioEmpleados();
            datos[2] = servEmpleados.getAllEmpleados();
	        VistaVentas.getInstancia().update(VER_VENTAS, datos);
	        break;
		case REALIZAR_NUEVA_VENTA:
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			servPelicula = factNeg.generaServicioPelicula();
			datos = new Object[4];
            datos[0] = ventana;
            fecha = null;;
            if(data == null){
            	tVenta = new TVenta();
            	GregorianCalendar calendar = new GregorianCalendar();
        		fecha = calendar.getTime();
            }else{
            	if(data instanceof Object[]){
            		Object[] datosAux = (Object[]) data;
                	tVenta = (TVenta) datosAux[0];
                	fecha = (Date) datosAux[1];          		
            	}else{
            		tVenta = (TVenta) data;
            		GregorianCalendar calendar = new GregorianCalendar();
            		fecha = calendar.getTime();
            	}  	           	
            }
            datos[1] = tVenta;
            datos[2] = fecha;
            datos[3] = servPelicula.getAllPeliculasPorSesionFecha(fecha);
            VistaVentas.getInstancia().update(REALIZAR_NUEVA_VENTA, datos);
			break;
      	case VER_REALIZAR_NUEVA_VENTA_PELICULA:
            factNeg = FactoriaNegocio.getInstancia();
            servSesion = factNeg.generaServicioSesion();
            servPelicula = factNeg.generaServicioPelicula();
            Object[] datosAux = (Object[]) data;
            datos = new Object[4];
            datos[0] = ventana;
            datos[1] = datosAux[0];
            tPelicula = (TPelicula) datosAux[1];
            fecha = (Date) datosAux[2];
            datos[2] = tPelicula;
            datos[3] = servSesion.getAllSesionesPorPeliculaFecha(tPelicula,fecha);
            VistaVentas.getInstancia().update(VER_REALIZAR_NUEVA_VENTA_PELICULA, datos);
            break;
		case VER_VENTAS_VER_MODIFICAR:
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			servPelicula = factNeg.generaServicioPelicula();
            datosAux = (Object[]) data;
			datos = new Object[4];
            datos[0] = ventana;
            datos[1] = datosAux[0];
            datos[2] = datosAux[1];
            servEmpleados = factNeg.generaServicioEmpleados();
            datos[3] = servEmpleados.getAllEmpleados();
            //datos[2] = servPelicula.getAllPeliculas();
            VistaVentas.getInstancia().update(VER_VENTAS_VER_MODIFICAR, datos);
            break;
		case VER_MODIFICAR_VENTA:
			factNeg = FactoriaNegocio.getInstancia();
			servSesion = factNeg.generaServicioSesion();
			servPelicula = factNeg.generaServicioPelicula();
			servVentas = factNeg.generaServicioVentas();
	        //datos[2] = servPelicula.getAllPeliculas();
			tVenta = servVentas.getVenta((Integer) data);
			datos = new Object[3];
			datos[0] = ventana;
			datos[1] = tVenta;
			servEmpleados = factNeg.generaServicioEmpleados();
            datos[2] = servEmpleados.getAllEmpleados();
	        VistaVentas.getInstancia().update(VER_VENTAS, datos);
			break;
		case ANADIR_EMPLEADO:
			TEmpleado templeado = (TEmpleado) data;
			factNeg = FactoriaNegocio.getInstancia();
			servEmpleados = factNeg.generaServicioEmpleados();
			resultado = servEmpleados.DarDeAltaEmpleado(templeado);
			switch(resultado){
			case 0:string_resultado = "Se ha añadido el empleado con éxito";break;
			case 1: string_resultado = "Ya existe un empleado con ese DNI";break;
			default: string_resultado = "Error no identificado";break;
			}
			VistaEmpleados.getInstancia().update(NOTIFICA_RESULTADO_EMPLEADO, string_resultado);
			
			datos = new Object[2];
            datos[0] = ventana;
            servEmpleados = FactoriaNegocio.getInstancia().generaServicioEmpleados();
            datos[1] = servEmpleados.getAllEmpleados();
            VistaEmpleados.getInstancia().update(VER_EMPLEADOS, datos);
			break;
		case ELIMINAR_EMPLEADO:
			Integer idEmpleado = (Integer) data;
			//templeado = (TEmpleado) data;
			factNeg = FactoriaNegocio.getInstancia();
			servEmpleados = factNeg.generaServicioEmpleados();
			resultado = servEmpleados.DarDeBajaEmpleado(idEmpleado);
			switch(resultado){
			case 0:string_resultado = "Se ha eliminado el empleado con éxito";break;
			case 1:string_resultado = "No existe el empleado";break;
			default:string_resultado = "Error no identificado";break;
			}
			VistaEmpleados.getInstancia().update(NOTIFICA_RESULTADO_EMPLEADO, string_resultado);
			datos = new Object[2];
            datos[0] = ventana;
            servEmpleados = FactoriaNegocio.getInstancia().generaServicioEmpleados();
            datos[1] = servEmpleados.getAllEmpleados();
            VistaEmpleados.getInstancia().update(VER_EMPLEADOS, datos);
			break;
		case MODIFICAR_EMPLEADO:
			templeado = (TEmpleado) data;
			factNeg = FactoriaNegocio.getInstancia();
			servEmpleados = factNeg.generaServicioEmpleados();
			resultado = servEmpleados.ModificarEmpleado(templeado);
			switch(resultado){
			case 0:string_resultado = "Se ha modificado el empleado con éxito";break;
			case 1:string_resultado = "No existe el empleado";break;
			default:string_resultado = "Error no identificado";break;
			}
			VistaEmpleados.getInstancia().update(NOTIFICA_RESULTADO_EMPLEADO, string_resultado);
			/*datos = new Object[2];
            datos[0] = ventana;
            servEmpleados = FactoriaNegocio.getInstancia().generaServicioEmpleados();
            datos[1] = servEmpleados.getAllEmpleados();
            VistaEmpleados.getInstancia().update(VER_EMPLEADOS, datos);*/
			break;
		case VER_EMPLEADOS:
            datos = new Object[2];
            datos[0] = ventana;
            servEmpleados = FactoriaNegocio.getInstancia().generaServicioEmpleados();
            datos[1] = servEmpleados.getAllEmpleados();
            VistaEmpleados.getInstancia().update(VER_EMPLEADOS, datos);
            break;
		case VER_ANADIR_EMPLEADO:
            VistaEmpleados.getInstancia().update(VER_ANADIR_EMPLEADO, data);
            break;
		case VER_MODIFICAR_EMPLEADO:
            servEmpleados = FactoriaNegocio.getInstancia().generaServicioEmpleados();
            TEmpleado tEmpleadoAux = (TEmpleado) data;
            TEmpleado tEmpleado = servEmpleados.getEmpleado(tEmpleadoAux.getIdEmpleado());
            VistaEmpleados.getInstancia().update(VER_MODIFICAR_EMPLEADO, tEmpleado);
            break;

		}
		// end-user-code
		/*
		 * Al añadir empleado no vale con autoincrement
		 * No se puede al modificar sala modificar la fecha, solo la hora por eso en GUIModificarSesion hay un
		 * atributo date, solo tendría que haber el id
		 * Falta un boton de eliminar sesion
		 * No fucnionaba el dao read Pelicula
		 * He añadido un readByDNI en empleados
		 */
	}
	
	public void start(){
		ventana = new MainFrame();
        ventana.setVisible(true);
        Controlador.getInstancia().accion(ventana, Controlador.VER_SALAS);
	}

	public static void main(String[] args) {
		Controlador.getInstancia().start();
	}
}