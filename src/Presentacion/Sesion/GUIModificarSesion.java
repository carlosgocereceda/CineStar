/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Sesion;

import Presentacion.Controlador.Controlador;

import Negocio.Pelicula.TPelicula;
import Negocio.Sala.TSala;
import Negocio.Sesion.TSesion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author gerar
 */
public class GUIModificarSesion extends javax.swing.JDialog {
    
    private Integer idSesion;
    private Date Fecha;

    /**
     * Creates new form GUIModificar
     */
    public GUIModificarSesion(java.awt.Frame parent, boolean modal,final TSesion tSesion,ArrayList<TSala> tSalas,ArrayList<TPelicula> tPeliculas,
                                ArrayList<TSesion> tSesiones,ArrayList<Date> horasDisponibles,TSala tSalaSeleccionada,
                                TPelicula tPeliculaSeleccionada) {
        super(parent, modal);
      //  Controlador ctrl = Controlador.getInstancia();
        this.idSesion = tSesion.getIdSesion();
        this.Fecha = tSesion.getFecha();
        initComponents();
        setSize(630,385);
        ImageIcon img = new ImageIcon("src/Imagenes/cinestar.jpg");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getSize().width, this.getSize().height, Image.SCALE_DEFAULT));
        lblFondo.setIcon(icono);
        jPanel2.setOpaque(false);
        fechaChooser.setDate(tSesion.getFecha());
        final JDialog ventana = this;
        fechaChooser.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				if(ventana.isVisible()){
					Object[] datos = new Object[2];
	                tSesion.settPelicula((TPelicula) cbPeliculas.getSelectedItem());
	                tSesion.settSala((TSala) cbSalas.getSelectedItem());
	                tSesion.setHora((Date) cbHorasDisponibles.getSelectedItem());
	                tSesion.setFecha(fechaChooser.getDate());
	                //datos[0] = tSesion;
	                setVisible(false);
	                Controlador.getInstancia().accion(tSesion, Controlador.VER_MODIFICAR_SESION);
				}				
			}
        	
        });
        
        for (TSala tSala : tSalas) {
            cbSalas.addItem(tSala);
        }
        
        tSesiones.remove(tSesion);
        TableModelSesionPorSala tableModel = new TableModelSesionPorSala(tSesiones);
        jTableSesiones.setModel(tableModel);
        
        ArrayList<Date> horasOcupadas = new ArrayList();
        Date horaFin = null;
        int indice = 0;
        ArrayList<TSesion> tSesionesSinPeliActual = (ArrayList<TSesion>) tSesiones.clone();
        tSesionesSinPeliActual.remove(tSesion);
        
        
        //ArrayList<TPelicula> tPeliculas = ctrl.getAllPeliculas();
        Date horaSeleccionada = null;
        if(tSesion != null){
            spinnerCantLibres.setValue(tSesion.getCantLibres());
            tPrecioUnitario.setText(tSesion.getPrecioUnitario()+"");
            horaSeleccionada = (Date) tSesion.getHora().clone();
            Date horaSeleccionadaFin = (Date) horaSeleccionada.clone();
            horaSeleccionada.setMinutes(horaSeleccionada.getMinutes()-tSesion.gettPelicula().getDuracion());
            horaSeleccionadaFin.setMinutes(horaSeleccionadaFin.getMinutes()+tSesion.gettPelicula().getDuracion());
            Date hora = (Date) horaSeleccionada.clone();
            while(hora.getHours() < horaSeleccionadaFin.getHours() || 
                    (hora.getHours() == horaSeleccionadaFin.getHours() &&  hora.getMinutes() < horaSeleccionadaFin.getMinutes())){                
                horasDisponibles.add(hora);
                hora = (Date) hora.clone();                
                hora.setMinutes(hora.getMinutes()+5);
            }
            horasDisponibles.add(horaSeleccionadaFin);
            Collections.sort(horasDisponibles,new Comparator<Date>() {
                @Override
                public int compare(Date date1, Date date2) {
                    if(date1.getHours() == 00 && date1.getMinutes() == 00){
                        return 1;
                    }else if(date2.getHours() == 00 && date2.getMinutes() == 00){
                        return -1;
                    }else if(date1.getHours() > date2.getHours()){
                        return 1;
                    }else if(date1.getHours() == date2.getHours() && date1.getMinutes() > date2.getMinutes()){
                        return 1;
                    }else 
                    return -1;
                }
            });
        }
        DateHora dateHoraSeleccionada = null;
        
        if(horasDisponibles != null){
            for (Date horasDiponible : horasDisponibles) {
                horaSeleccionada = (Date) tSesion.getHora().clone();
                DateHora dateHora = new DateHora(horasDiponible);
                if(horaSeleccionada != null && horaSeleccionada.getHours() == horasDiponible.getHours() 
                        && horaSeleccionada.getMinutes() == horasDiponible.getMinutes()){
                    dateHoraSeleccionada = dateHora;
                }
                cbHorasDisponibles.addItem(dateHora);
            }
            if(dateHoraSeleccionada != null){
                cbHorasDisponibles.setSelectedItem(dateHoraSeleccionada);
            }
        }
        
        for (TPelicula tPelicula : tPeliculas) {
            cbPeliculas.addItem(tPelicula);
        }

        
        
       
        
        
        cbSalas.setSelectedItem(tSalaSeleccionada);
        cbPeliculas.setSelectedItem(tPeliculaSeleccionada);
        
        txtDuracion.setText(tPeliculaSeleccionada.getDuracion().toString());
        
        cbSalas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	Object[] datos = new Object[2];
                tSesion.settPelicula((TPelicula) cbPeliculas.getSelectedItem());
                tSesion.settSala((TSala) cbSalas.getSelectedItem());
                tSesion.setHora((Date) cbHorasDisponibles.getSelectedItem());
                tSesion.setFecha(fechaChooser.getDate());
                //datos[0] = tSesion;
                setVisible(false);
                Controlador.getInstancia().accion(tSesion, Controlador.VER_MODIFICAR_SESION);
            }
            
        });
        
        cbPeliculas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	Object[] datos = new Object[2];
                tSesion.settPelicula((TPelicula) cbPeliculas.getSelectedItem());
                tSesion.settSala((TSala) cbSalas.getSelectedItem());
                tSesion.setHora((Date) cbHorasDisponibles.getSelectedItem());
                tSesion.setFecha(fechaChooser.getDate());
                //datos[0] = tSesion;
                setVisible(false);
                Controlador.getInstancia().accion(tSesion, Controlador.VER_MODIFICAR_SESION);
            }
            
        });
        
        
        
        btnEliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				setVisible(false);
				Controlador.getInstancia().accion(idSesion, Controlador.ELIMINAR_SESION);
				Controlador.getInstancia().accion(null, Controlador.VER_SESIONES);
			}
        	
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	TSala tSala = (TSala) cbSalas.getSelectedItem();
                TPelicula tPelicula = (TPelicula) cbPeliculas.getSelectedItem();
                Date hora = (Date) cbHorasDisponibles.getSelectedItem();
                Date fechaSeleccionada = fechaChooser.getDate();
                Integer cantLibres = (Integer) spinnerCantLibres.getValue();
                String precioUni = tPrecioUnitario.getText();
                fechaSeleccionada.setHours(hora.getHours());
                Date actual = new Date();
                //----
                
                if(tSala != null && tPelicula != null && hora != null && fechaSeleccionada != null
    	        		&& cantLibres > 0 && precioUni.length() > 0){
                	if(actual.after(fechaSeleccionada)){
    					if(actual.getYear() == fechaSeleccionada.getYear() && actual.getMonth() == fechaSeleccionada.getMonth()
    							&& actual.getDate() == fechaSeleccionada.getDate()){
    						tSesion.settPelicula(tPelicula);
    	                    tSesion.settSala(tSala);
    	                    tSesion.setHora(hora);
    	                    tSesion.setFecha(fechaSeleccionada);
    	                    tSesion.setCantLibres(cantLibres);
    	                    tSesion.setPrecioUnitario(Float.parseFloat(precioUni));
		                	setVisible(false);
		                    Controlador.getInstancia().accion(tSesion, Controlador.MODIFICAR_SESION);
		                    Controlador.getInstancia().accion(null, Controlador.VER_SESIONES);			
    					}else{
    						JOptionPane.showMessageDialog(null, "No puede introducir una fecha pasada");
    					}	            	
		        	}
    				else{
    					tSesion.settPelicula(tPelicula);
                        tSesion.settSala(tSala);
                        tSesion.setHora(hora);
                        tSesion.setFecha(fechaSeleccionada);
                        tSesion.setCantLibres(cantLibres);
                        tSesion.setPrecioUnitario(Float.parseFloat(precioUni));
                    	 setVisible(false);
                         Controlador.getInstancia().accion(tSesion, Controlador.MODIFICAR_SESION);
                         Controlador.getInstancia().accion(null, Controlador.VER_SESIONES);
    				}				
    		 }
    		 else{
    			 JOptionPane.showMessageDialog(null, "No están todos los datos rellenos");
    		 }
                //----
                
            	/*	
            	tSesion.settPelicula((TPelicula) cbPeliculas.getSelectedItem());
                tSesion.settSala((TSala) cbSalas.getSelectedItem());
                tSesion.setHora((Date) cbHorasDisponibles.getSelectedItem());
                tSesion.setFecha(fechaChooser.getDate());
                tSesion.setCantLibres((Integer) spinnerCantLibres.getValue());
                tSesion.setPrecioUnitario(Float.parseFloat(tPrecioUnitario.getText()));
                //datos[0] = tSesion;
                setVisible(false);
                Controlador.getInstancia().accion(tSesion, Controlador.MODIFICAR_SESION);
                Controlador.getInstancia().accion(null, Controlador.VER_SESIONES);*/
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

        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbSalas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbPeliculas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbHorasDisponibles = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSesiones = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        spinnerCantLibres = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        tPrecioUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fechaChooser = new com.toedter.calendar.JDateChooser();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnModificar.setText("Modificar");
        
        getContentPane().add(btnModificar);
        btnModificar.setBounds(380, 320, 110, 23);

        btnEliminar.setText("Eliminar");
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(503, 320, 100, 23);

        jLabel1.setText("Sala");

        jLabel2.setText("Pelicula");

        jLabel3.setText("Duracion:");

        txtDuracion.setEditable(false);

        jLabel4.setText("Horas Inicio Disponibles:");

        jTableSesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableSesiones);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Cantidad de Plazas Libres:");

        jLabel6.setText("Precio de Entrada Unitario:");

        jLabel7.setText("Fecha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbHorasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerCantLibres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(fechaChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbHorasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spinnerCantLibres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6))
                    .addComponent(tPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 614, 337);
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, -6, 620, 360);

        pack();
    }// </editor-fold>                        
                                            

    

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cbHorasDisponibles;
    private javax.swing.JComboBox cbPeliculas;
    private javax.swing.JComboBox cbSalas;
    private com.toedter.calendar.JDateChooser fechaChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSesiones;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JSpinner spinnerCantLibres;
    private javax.swing.JTextField tPrecioUnitario;
    private javax.swing.JTextField txtDuracion;
    // End of variables declaration                   
}
