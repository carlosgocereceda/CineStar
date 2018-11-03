package Presentacion.Pelicula;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Negocio.Pelicula.TPelicula;
import Presentacion.Controlador.Controlador;
import Presentacion.Main.MainFrame;

public class VistaPeliculasImp extends VistaPeliculas{

	public void update(int event,Object object){
		switch(event){
			case Controlador.VER_PELICULAS:
				Object[] datos = (Object[]) object;
                MainFrame ventana = (MainFrame) datos[0];                            
                ArrayList<TPelicula> tPeliculas = (ArrayList<TPelicula>) datos[1];
                ventana.update(new PanelPeliculas(tPeliculas));
				/*GUIPeliculas ventana = new GUIPeliculas(tPelicula);
				ventana.setVisible(true);*/
				break;
			case Controlador.VER_ANADIR_PELICULA:
				GUIAnadirPelicula ventanaAnadirPelicula = new GUIAnadirPelicula(null, true);
				ventanaAnadirPelicula.setVisible(true);					
				break;
			case Controlador.VER_MODIFICAR_PELICULA:
				GUIModificarPelicula ventanaModificarPelicula = new GUIModificarPelicula(null,true,(TPelicula) object); 
	        	ventanaModificarPelicula.setVisible(true);
				break;
			case Controlador.NOTIFICA_RESULTADO_PELICULA:
				JOptionPane.showMessageDialog(null, object);
				break;
		}
	}
}
