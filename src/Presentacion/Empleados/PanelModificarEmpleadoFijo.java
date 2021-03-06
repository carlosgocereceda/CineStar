/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Empleados;

import Negocio.Empleados.TEmpleado;
import Negocio.Empleados.TEmpleadoFijo;

/**
 *
 * @author gerar
 */
public class PanelModificarEmpleadoFijo extends PanelGetEmpleado {

	private Integer idEmp;
	
    /**
     * Creates new form PanelModificarEmpleadoFijo
     */
    public PanelModificarEmpleadoFijo(TEmpleado tEmpleado) {
        initComponents();
        this.idEmp = tEmpleado.getIdEmpleado();
        TEmpleadoFijo tEmpleadoFijo = (TEmpleadoFijo) tEmpleado;
        tDNI.setText(tEmpleadoFijo.getDni());
        tNombre.setText(tEmpleadoFijo.getNombre());
        tApellidos.setText(tEmpleadoFijo.getApellidos());
        tPassword.setText(tEmpleadoFijo.getPassword());
        tSueldo.setText(tEmpleadoFijo.getSueldo()+"");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tDNI = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tSueldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tPassword = new javax.swing.JTextField();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("DNI:");

        tNombre.setText("jTextField2");

        tApellidos.setText("jTextField3");

        jLabel5.setText("Sueldo:");

        tSueldo.setText("tSueldo");

        jLabel6.setText("Password:");

        tPassword.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tDNI)
                            .addComponent(tNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(tApellidos)
                            .addComponent(tPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tSueldo)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tApellidos;
    private javax.swing.JTextField tDNI;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tPassword;
    private javax.swing.JTextField tSueldo;
    // End of variables declaration                   

    @Override
    public TEmpleado getEmpleado() {
    	/*
    	 * int idEmpleado,String Dni,String nombre, String apellidos, String password,float sueldo){
        super(idEmpleado,Dni,nombre,apellidos,"Fijo",password);
    	 * 
    	 */
    	TEmpleadoFijo tEmpleadoFijo = new TEmpleadoFijo(this.idEmp,tDNI.getText(), tNombre.getText(),
    			tApellidos.getText(), tPassword.getText(),Float.parseFloat(this.tSueldo.getText()));
    	return tEmpleadoFijo;
    }
}
