/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Pelicula;

import Presentacion.Controlador.Controlador;
import Negocio.Pelicula.TPelicula;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author gerar
 */
public class GUIModificarPelicula extends GUIAnadirPelicula {
    private TPelicula tPelicula;
    /**
     * Creates new form GUIModificarPelicula
     */
    public GUIModificarPelicula(java.awt.Frame parent, boolean modal,final TPelicula tPelicula) {
        super(parent, modal);
        initComponents();
        this.tPelicula = tPelicula;
        super.setTitle("Modificar Pelicula");
        super.btnGuardar.removeActionListener(btnGuardar.getActionListeners()[0]);
        super.btnGuardar.addActionListener(new ActionListener(){
            @Override
            
            public void actionPerformed(ActionEvent e) {
            	String titulo = tTitulo.getText();
            	Integer duracion = (Integer) spinnerDuracion.getValue();
            	String clasificacion = tClasificacion.getText();
            	
            	if(titulo.length() != 0 && duracion != 0 && clasificacion.length() != 0){
            		boolean estado = false;
            		if(rbHabilitada.isSelected()){
                        estado = true;
            		}
                    tPelicula.setTitulo(titulo);
                    tPelicula.setDuracion(duracion);
                    tPelicula.setClasificacion(clasificacion);
                    tPelicula.setEstado(estado);
                    tPelicula.setImagen(fichero);
                    //TPelicula tPelicula = new TPelicula(this.tPelicula.getIdPelicula(),titulo,duracion,clasificacion,estado,fichero);
                    Controlador ctrl = Controlador.getInstancia();
                    setVisible(false);
                    ctrl.accion(tPelicula, Controlador.MODIFICAR_PELICULA);
                    ctrl.accion(null, Controlador.VER_PELICULAS);
            	}
       		
        		 else{
        			 JOptionPane.showMessageDialog(null, "No est�n todos los datos rellenos");
                 }
            }
           
        });
        super.tTitulo.setText(tPelicula.getTitulo());
        super.tClasificacion.setText(tPelicula.getClasificacion());
        if(tPelicula.isEstado()){
        	rbHabilitada.setSelected(true);
        }else{
        	rbDeshabilitada.setSelected(true);
        }
        
        super.spinnerDuracion.setValue(tPelicula.getDuracion());
        ImageIcon img = new ImageIcon(tPelicula.getImagen().getImagen());
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
        super.lblImg.setIcon(icono);
        super.fichero = tPelicula.getImagen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        



    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
