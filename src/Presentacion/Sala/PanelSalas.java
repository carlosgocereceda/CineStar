/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Sala;

import Negocio.Sala.TSala;
import Presentacion.Controlador.Controlador;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *
 * @author gerar
 */
public class PanelSalas extends javax.swing.JPanel {
    private TableModelTableSalas tableModelTableSalas;
    /**
     * Creates new form PanelSalas
     */
    public PanelSalas(ArrayList<TSala> tSalas) {
        initComponents();
        
        tableModelTableSalas = new TableModelTableSalas(tSalas);
        tableSala.setModel(tableModelTableSalas);
        tableSala.getTableHeader().setReorderingAllowed(false);
        
        tableSala.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.setOpaque(false);
    }

    public PanelSalas(ArrayList<TSala> tSalas,TSala tSalaSeleccionada,JPanel panel) {
        initComponents();
        
        tableModelTableSalas = new TableModelTableSalas(tSalas);
        tableSala.setModel(tableModelTableSalas);
        tableSala.getTableHeader().setReorderingAllowed(false);
        
        int pos = tSalas.indexOf(tSalaSeleccionada);
        tableSala.getSelectionModel().setSelectionInterval(pos, pos);
        
        tableSala.setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.setOpaque(false);
        
        btnEliminarSala.setEnabled(true);
        
        panel.setSize(490, 200);
        panelModificarSala.add(panel);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSala = new javax.swing.JTable();
        panelModificarSala = new javax.swing.JPanel();
        btnAnadirSala = new javax.swing.JButton();
        btnEliminarSala = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 411));

        jScrollPane1.setOpaque(false);

        tableSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableSala.setOpaque(false);
        tableSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSala);

        panelModificarSala.setOpaque(false);

        javax.swing.GroupLayout panelModificarSalaLayout = new javax.swing.GroupLayout(panelModificarSala);
        panelModificarSala.setLayout(panelModificarSalaLayout);
        panelModificarSalaLayout.setHorizontalGroup(
            panelModificarSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelModificarSalaLayout.setVerticalGroup(
            panelModificarSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnAnadirSala.setText("Anadir Sala");
        btnAnadirSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirSalaActionPerformed(evt);
            }
        });

        btnEliminarSala.setText("Eliminar Sala");
        btnEliminarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelModificarSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnadirSala, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarSala, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnadirSala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarSala)
                        .addGap(0, 154, Short.MAX_VALUE))
                    .addComponent(panelModificarSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void tableSalaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:       
    	if(evt.getClickCount()==2){
    		TSala tSala = tableModelTableSalas.gettSalas().get(
                    tableSala.getSelectedRow()); 
        	Controlador ctrl = Controlador.getInstancia();
            ctrl.accion(tSala, Controlador.VER_MODIFICAR_SALA);
        }
    }                                      

    private void btnAnadirSalaActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:        
        Controlador ctrl = Controlador.getInstancia();
        ctrl.accion(null, Controlador.VER_ANADIR_SALA);
        ctrl.accion(null, Controlador.VER_SALAS);
    }                                             

    private void btnEliminarSalaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        Controlador ctrl = Controlador.getInstancia();
        TSala tSala = tableModelTableSalas.gettSalas().get(
                        tableSala.getSelectedRow());
        ctrl.accion(tSala, Controlador.BORRAR_SALA);
        /*tableModelTableSalas.fireTableDataChanged();
        btnEliminarSala.setEnabled(false);*/
        ctrl.accion(null, Controlador.VER_SALAS);
    }                                               


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAnadirSala;
    private javax.swing.JButton btnEliminarSala;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelModificarSala;
    private javax.swing.JTable tableSala;
    // End of variables declaration                   
}
