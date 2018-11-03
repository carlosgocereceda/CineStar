/**
 * 
 */
package Presentacion.Sala;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Negocio.Sala.TSala;
import Presentacion.Controlador.Controlador;
import Presentacion.Main.MainFrame;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaSalaImp extends VistaSala {

	@Override
	public void update(Integer event, Object object) {
		// TODO Auto-generated method stub
		switch(event){
		case Controlador.VER_SALAS:
			Object[] datos = (Object[]) object;
            MainFrame ventana = (MainFrame) datos[0];
            ArrayList<TSala> tSalas = (ArrayList<TSala>) datos[1];
            ventana.update(new PanelSalas(tSalas));
            break;
		case Controlador.VER_ANADIR_SALA:
			GUIAnadirSala ventanaAnadirSala = new GUIAnadirSala(null, true);
	        ventanaAnadirSala.setVisible(true);
	        break;
		case Controlador.VER_MODIFICAR_SALA:
			datos = (Object[]) object;
            ventana = (MainFrame) datos[0];
            tSalas = (ArrayList<TSala>) datos[1];
            TSala tSala = (TSala) datos[2];
			ventana.update(new PanelSalas(tSalas,tSala,new PanelModificarSala(tSala)));
			break;
		
		case Controlador.NOTIFICA_RESULTADO_SALA:
			JOptionPane.showMessageDialog(null, object);
		}
	}
}