/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;

/**
 *

 */
public class Notificacion implements Comparable<Notificacion>{
    
    private Date fecha;
    private String mensaje;

    public Date getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }


    // para armar datos de prueba
    public Notificacion(Date fecha, String mensaje) {
        this.fecha = fecha;
        this.mensaje = mensaje;
    }
            
    public Notificacion(String mensaje) {
        this.fecha = new Date();
        this.mensaje = mensaje;
    }

    @Override
    public int compareTo(Notificacion o) {
        return this.getFecha().compareTo(o.getFecha());
    }
    
    
}
