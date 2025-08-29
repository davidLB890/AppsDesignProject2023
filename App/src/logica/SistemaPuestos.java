/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *

 */
public class SistemaPuestos {
        
    private ArrayList<Puesto> puestos = new ArrayList();
    private ArrayList<TipoBonificacion> tiposBonificacion = new ArrayList();

    public SistemaPuestos() {
        agregarBonificaciones();
    }
     
    
    public void agregarPuesto(Puesto puesto){
        puestos.add(puesto);
    }

    private void agregarBonificaciones() {
        tiposBonificacion.add(new BonificacionExonerado("Exonerado"));
        tiposBonificacion.add(new BonificacionFrecuente("Frecuente"));
        tiposBonificacion.add(new BonificacionTrabajador("Trabajador"));
    }

    public ArrayList<TipoBonificacion> getTiposBonificacion() {
        return tiposBonificacion;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    

}
