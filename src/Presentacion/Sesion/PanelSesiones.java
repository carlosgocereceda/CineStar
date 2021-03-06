/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Sesion;

import Presentacion.Controlador.Controlador;
import Negocio.Sesion.TSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;

/**
 *
 * @author gerar
 */
public class PanelSesiones extends javax.swing.JPanel {

    /**
     * Creates new form PanelSesiones
     */
    public PanelSesiones(Date fecha,ArrayList<TSesion> tSesiones) {
        initComponents();
        
        this.setOpaque(false);
        
        Controlador ctrl = Controlador.getInstancia();
        //ArrayList<TSesion> tSesiones = ctrl.getAllSesion();
        
        ArrayList<TSesion> tSesionesPorSala = new ArrayList();
        panelSesiones.setLayout(new BoxLayout(panelSesiones, BoxLayout.Y_AXIS));
        fechaChooser.setDate(fecha);
        panelSesiones.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        if(!tSesiones.isEmpty()){
            TSesion tSesionAux = tSesiones.get(0);
            tSesionesPorSala.add(tSesionAux);
            for (int i = 1; i < tSesiones.size(); i++) {
                if(tSesiones.get(i).gettSala().getIdSala() == tSesionAux.gettSala().getIdSala()){
                    tSesionesPorSala.add(tSesiones.get(i));
                }else{
                    PanelSesionPorSala panelSesionPorSala = new PanelSesionPorSala(tSesionesPorSala);
                    panelSesionPorSala.setSize(600,100);
                    panelSesiones.add(panelSesionPorSala);
                    tSesionesPorSala = new ArrayList();
                    tSesionAux = tSesiones.get(i);
                    tSesionesPorSala.add(tSesionAux);
                }
            }
            if(!tSesionesPorSala.isEmpty()){
                PanelSesionPorSala panelSesionPorSala = new PanelSesionPorSala(tSesionesPorSala);
                panelSesionPorSala.setSize(690,100);
                panelSesiones.add(panelSesionPorSala);
            }
        }
        btnAnadirSesion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                /*GUIAnadirSesion ventana = new GUIAnadirSesion(null,true);
                ventana.setVisible(true);*/
            	Controlador.getInstancia().accion(null, Controlador.VER_ANADIR_SESION);
            }
            
        });
        btnBuscar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ap�ndice de m�todo generado autom�ticamente
				Controlador.getInstancia().accion(fechaChooser.getDate(), Controlador.VER_SESIONES);
			}
        	
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAnadirSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelSesiones = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fechaChooser = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 411));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Sesiones");

        btnAnadirSesion.setText("A�adir Sesion");

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout panelSesionesLayout = new javax.swing.GroupLayout(panelSesiones);
        panelSesiones.setLayout(panelSesionesLayout);
        panelSesionesLayout.setHorizontalGroup(
            panelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        panelSesionesLayout.setVerticalGroup(
            panelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelSesiones);

        jLabel2.setText("Fecha:");

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnadirSesion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAnadirSesion))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fechaChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAnadirSesion;
    private javax.swing.JButton btnBuscar;
    private com.toedter.calendar.JDateChooser fechaChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelSesiones;
    // End of variables declaration                   
}
