package Presentacion.Empleados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Negocio.Empleados.TEmpleado;
import Negocio.Empleados.TEmpleadoFijo;
import Negocio.Empleados.TEmpleadoParcial;
import Presentacion.Controlador.Controlador;
import Presentacion.Main.MainFrame;

public class VistaEmpleadosImp extends VistaEmpleados {

	@Override
	public void update(int event, Object object) {
		// TODO Apéndice de método generado automáticamente
		switch(event){
			case Controlador.NOTIFICA_RESULTADO_EMPLEADO:
				JOptionPane.showMessageDialog(null, object);
				break;
			case Controlador.VER_EMPLEADOS:
				Object[] datos = (Object[]) object;
	            MainFrame ventana = (MainFrame) datos[0];
	           // ArrayList<TSala> tSalas = (ArrayList<TSala>) datos[1];
	            ArrayList<TEmpleado> tEmpleados = (ArrayList<TEmpleado>) datos[1];
                ventana.update(new PanelEmpleados(tEmpleados));
                break;
			case Controlador.VER_ANADIR_EMPLEADO:
				PanelGetEmpleado panel = null;
                String tipo;
                if(object == null ){
                	tipo = null;
                	panel = new PanelAnadirEmpleadoFijo();
                }else{
                	tipo = (String) object;
                	if(tipo.compareToIgnoreCase("Fijo") == 0){
                		panel = new PanelAnadirEmpleadoFijo();
	                }else if(tipo.compareToIgnoreCase("Parcial") == 0){
	                    panel = new PanelAnadirEmpleadoParcial();
	                }
                }
                GUIAnadirEmpleado ventanaAnadir = new GUIAnadirEmpleado(null,true,panel,tipo);
                ventanaAnadir.setVisible(true);              
                break;
            case Controlador.VER_MODIFICAR_EMPLEADO:
                TEmpleado tEmpleado = (TEmpleado) object;
                panel = null;
                if(tEmpleado instanceof TEmpleadoFijo){
                    panel = new PanelModificarEmpleadoFijo(tEmpleado);
                }else if(tEmpleado instanceof TEmpleadoParcial){
                    panel = new PanelModificarEmpleadoParcial(tEmpleado);
                }
                GUIModificarEmpleado ventanaModificar = new GUIModificarEmpleado(null,true,panel);
                ventanaModificar.setVisible(true);
                break;
		}
		
			
	}

}
