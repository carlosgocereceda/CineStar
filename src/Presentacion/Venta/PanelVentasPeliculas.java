/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Venta;


import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Negocio.Pelicula.TPelicula;
import Negocio.Ventas.TVenta;
import Presentacion.Controlador.Controlador;
import Presentacion.Pelicula.LabelTPelicula;
/**
 *
 * @author gerar
 */
public class PanelVentasPeliculas extends javax.swing.JPanel {
    private LabelTPelicula labelSeleccionado;
    /**
     * Creates new form PanelVentasPeliculas1
     */
    public PanelVentasPeliculas(final TVenta tVenta,Date fecha,ArrayList<TPelicula> tPeliculas) {
        initComponents();
        
        fechaChooser.setDate(fecha);
     
        
        this.setOpaque(false);
        scrollPeliculas.setOpaque(false);
        scrollPeliculas.getViewport().setOpaque(false);
        
        scrollPeliculas.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
        panelAllPeliculas.setLayout(new BoxLayout(panelAllPeliculas, BoxLayout.Y_AXIS));
        panelAllPeliculas.setOpaque(false);
        scrollPeliculas.setOpaque(false);
        //Controlador ctrl = Controlador.getInstancia();
        //ArrayList<TPelicula> tPeliculas = ctrl.getAllPeliculas();

        int ncolumnas = 5;
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        if(tPeliculas != null){
            for (int i = 0; i < tPeliculas.size(); i++) {
                if(i%ncolumnas == 0){
                    panelAllPeliculas.add(panel);
                    panel = new JPanel();
                    panel.setOpaque(false);
                }
                final LabelTPelicula label = new LabelTPelicula(tPeliculas.get(i));
                ImageIcon img = new ImageIcon(tPeliculas.get(i).getImagen().getImagen());
                Icon icono = new ImageIcon(img.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
                label.setIcon(icono);
                label.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(labelSeleccionado != null && labelSeleccionado == label){
                            labelSeleccionado = null;
                            label.setBorder(null);
                        }else{                           
                            if(labelSeleccionado != null){
                                labelSeleccionado.setBorder(null);
                            }
                            labelSeleccionado = label;
                            LabelTPelicula l = (LabelTPelicula) e.getSource();
                            l.setBorder(BorderFactory.createLineBorder(Color.black));
                        }
                    }
                    
                });
                label.setPreferredSize(new Dimension(100, 150));
                panel.add(label);
            }
        }
        if (panel.getComponentCount() != 0) {
                panelAllPeliculas.add(panel);
        }
        
        btnSesiones.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] datos = new Object[3];
				datos[0] = tVenta;
				datos[1] = labelSeleccionado.gettPelicula();
				datos[2] = fechaChooser.getDate();
				Controlador.getInstancia().accion(datos, Controlador.VER_REALIZAR_NUEVA_VENTA_PELICULA);
				
			}			
		});
        
        btnAtras.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente
				Controlador.getInstancia().accion(tVenta, Controlador.VER_VENTAS);
			}        	
        });
        btnBuscarPorFecha.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente
				Date actual = new Date();
				Date fechaSeleccionada = fechaChooser.getDate();
				if(actual.after(fechaSeleccionada)){
					if(actual.getYear() == fechaSeleccionada.getYear() && actual.getMonth() == fechaSeleccionada.getMonth()
							&& actual.getDate() == fechaSeleccionada.getDate()){
						Object[] datos = new Object[2];
						datos[0] = tVenta;
						datos[1] = fechaChooser.getDate();
						Controlador.getInstancia().accion(datos, Controlador.REALIZAR_NUEVA_VENTA);						
					}else{
						JOptionPane.showMessageDialog(null, "No puede introducir una fecha pasada");
					}	            	
	            }
				else{
					Object[] datos = new Object[2];
					datos[0] = tVenta;
					datos[1] = fechaChooser.getDate();
					Controlador.getInstancia().accion(datos, Controlador.REALIZAR_NUEVA_VENTA);
				}				
			}       	
        });

        /*btnSesionesPelicula.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(labelSeleccionado != null){
                	Object[] datos = new Object[2];
                	datos[0] = tVenta;
                	datos[1] = labelSeleccionado.gettPelicula();               	
                	Controlador.getInstancia().accion(datos, Controlador.VER_REALIZAR_NUEVA_VENTA_PELICULA);
                }
                
            }           
        });*/
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        scrollPeliculas = new javax.swing.JScrollPane();
        panelAllPeliculas = new javax.swing.JPanel();
        btnSesiones = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        fechaChooser = new com.toedter.calendar.JDateChooser();
        btnBuscarPorFecha = new javax.swing.JButton();

        setLayout(null);

        javax.swing.GroupLayout panelAllPeliculasLayout = new javax.swing.GroupLayout(panelAllPeliculas);
        panelAllPeliculas.setLayout(panelAllPeliculasLayout);
        panelAllPeliculasLayout.setHorizontalGroup(
            panelAllPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        panelAllPeliculasLayout.setVerticalGroup(
            panelAllPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        scrollPeliculas.setViewportView(panelAllPeliculas);

        add(scrollPeliculas);
        scrollPeliculas.setBounds(0, 20, 600, 360);

        btnSesiones.setText("Sesiones");
        add(btnSesiones);
        btnSesiones.setBounds(500, 380, 100, 23);

        btnAtras.setText("Atras");
        add(btnAtras);
        btnAtras.setBounds(10, 380, 70, 23);
        add(fechaChooser);
        fechaChooser.setBounds(0, 0, 160, 20);

        btnBuscarPorFecha.setText("Buscar");
        add(btnBuscarPorFecha);
        btnBuscarPorFecha.setBounds(160, 0, 100, 23);
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarPorFecha;
    private javax.swing.JButton btnSesiones;
    private com.toedter.calendar.JDateChooser fechaChooser;
    private javax.swing.JPanel panelAllPeliculas;
    private javax.swing.JScrollPane scrollPeliculas;
    // End of variables declaration                   
}
