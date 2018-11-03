/**
 * 
 */
package Presentacion.Sesion;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Negocio.Pelicula.TPelicula;
import Negocio.Sala.TSala;
import Negocio.Sesion.TSesion;
import Presentacion.Controlador.Controlador;
import Presentacion.Main.MainFrame;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VSImp extends VistaSesion {

	@Override
	public void update(Integer event, Object object) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		switch(event){
			case Controlador.VER_SESIONES:
	            Object[] datos = (Object[]) object;
	            MainFrame ventana = (MainFrame) datos[0];
	            ArrayList<TSesion> tSesiones = (ArrayList<TSesion>) datos[1];
	            Date fecha = (Date) datos[2];
	            ventana.update(new PanelSesiones(fecha,tSesiones));
	            break;
			case Controlador.VER_ANADIR_SESION:
				datos = (Object[]) object;
                GUIAnadirSesion ventanaEmergente = new GUIAnadirSesion(null,true,(ArrayList<TSala>)datos[0],
                		(ArrayList<TPelicula>)datos[1],(ArrayList<TSesion>)datos[2], (ArrayList<Date>) datos[3],(TSala)datos[4],(TPelicula)datos[5],(Date) datos[6]);
                ventanaEmergente.setVisible(true);
                break;
			case Controlador.VER_MODIFICAR_SESION:
				 datos = (Object[]) object;
		         ventana = (MainFrame) datos[0];
		         //TSesion tSesion = (TSesion) datos[1];
		         TSesion tSesion = (TSesion) datos[1];
		         ArrayList<TSesion> a = new ArrayList<TSesion>();
		         a.add(tSesion);
		         //tSesiones = (ArrayList<TSesion>) datos[1];
		         GUIModificarSesion ventanaEmergenteModificar = new GUIModificarSesion(null,true, (TSesion) datos[1],(ArrayList<TSala>)datos[2],
                		(ArrayList<TPelicula>)datos[3],(ArrayList<TSesion>)datos[4], (ArrayList<Date>) datos[5],(TSala)datos[6],(TPelicula)datos[7]);
                         ventanaEmergenteModificar.setVisible(true);
                 break;
			case Controlador.NOTIFICA_RESULTADO_SESION:
				JOptionPane.showMessageDialog(null, object);

		}
	}
}