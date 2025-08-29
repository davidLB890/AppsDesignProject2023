/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;

/**
 *

 */
public class BonificacionAsignada {
    
    private Date fechaAsignada;
    private Puesto puesto;
    private TipoBonificacion tipo;
    
    
    // para datos de prueba
    public BonificacionAsignada(Date fecha, Puesto puesto, TipoBonificacion tipo) {
        this.puesto = puesto;
        this.tipo = tipo;
        fechaAsignada = fecha;
    }
    
    // para nuevas bonif
    public BonificacionAsignada(Puesto puesto, TipoBonificacion tipo) throws PeajeException{
        if(puesto == null || tipo == null) throw new PeajeException("Debe especificar puesto y tipo");
        this.puesto = puesto;
        this.tipo = tipo;
        fechaAsignada = new Date();
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public TipoBonificacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoBonificacion tipo) {
        this.tipo = tipo;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }
    
    



    
    
}
