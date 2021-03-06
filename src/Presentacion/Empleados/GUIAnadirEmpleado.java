/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Empleados;

import Negocio.Empleados.TEmpleado;
import Presentacion.Controlador.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gerar
 */
public class GUIAnadirEmpleado extends javax.swing.JDialog {

    /**
     * Creates new form GUIAnadirEmpleado
     */
    public GUIAnadirEmpleado(java.awt.Frame parent, boolean modal,final PanelGetEmpleado panel,String tipo) {
        super(parent, modal);
        initComponents();
        if(tipo == null || tipo.compareToIgnoreCase("Fijo") == 0){
            rbFijo.setSelected(true);
        }else if(tipo.compareToIgnoreCase("Parcial") == 0){
            rbParcial.setSelected(true);
        }
        panel.setSize(400, 275);
        panelPrincipal.add(panel);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        btnAnadirEmpleado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TEmpleado tEmpleado = panel.getEmpleado();
               // while(tEmpleado == null){
                	
                	tEmpleado = panel.getEmpleado();
                //}
                setVisible(false);
                Controlador.getInstancia().accion(tEmpleado, Controlador.ANADIR_EMPLEADO);
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

        btnGroupTipoEmpleado = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        btnAnadirEmpleado = new javax.swing.JButton();
        rbParcial = new javax.swing.JRadioButton();
        rbFijo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        btnAnadirEmpleado.setText("A�adir Empleado");
        btnAnadirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirEmpleadoActionPerformed(evt);
            }
        });

        btnGroupTipoEmpleado.add(rbParcial);
        rbParcial.setText("Parcial");
        rbParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParcialActionPerformed(evt);
            }
        });

        btnGroupTipoEmpleado.add(rbFijo);
        rbFijo.setSelected(true);
        rbFijo.setText("Fijo");
        rbFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFijoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnadirEmpleado)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(rbFijo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(rbParcial)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbParcial)
                    .addComponent(rbFijo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnadirEmpleado))
        );

        pack();
    }// </editor-fold>                        

    private void rbFijoActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        setVisible(false);
        Controlador.getInstancia().accion("Fijo", Controlador.VER_ANADIR_EMPLEADO);
    }                                      

    private void rbParcialActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        setVisible(false);
        Controlador.getInstancia().accion("Parcial", Controlador.VER_ANADIR_EMPLEADO);
    }                                         

    private void btnAnadirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAnadirEmpleado;
    private javax.swing.ButtonGroup btnGroupTipoEmpleado;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton rbFijo;
    private javax.swing.JRadioButton rbParcial;
    // End of variables declaration                   
}
