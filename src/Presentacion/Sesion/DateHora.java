package Presentacion.Sesion;

import java.util.Date;

public class DateHora extends Date{
    private Date date;
    
    public DateHora(Date date){
        super();
        this.date = date;
        super.setHours(date.getHours());
        super.setMinutes(date.getMinutes());
    }
    
    
    @Override
    public String toString() {
        return super.getHours()+":"+String.format("%02d",super.getMinutes());
    }

    @Override
    public boolean equals(Object obj) {
        Date date1 = (Date) obj;
        if(date.getHours() == date1.getHours() && date.getMinutes() == date1.getMinutes()){
            return true;
        } 
        return false;
    }    
    
}