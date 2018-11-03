/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Venta;

import Negocio.Sesion.TSesion;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author gerar
 */
public class JButtonSesion extends JButton{
    private TSesion tSesion;
    
    public JButtonSesion(TSesion tSesion){       
        super();
        this.tSesion = tSesion;
        Date hora = tSesion.getHora();
        setText(String.format("%02d",hora.getHours())+":"+String.format("%02d",hora.getMinutes()));       
    }
    
    public TSesion gettSesion(){
        return tSesion;
    }
}
