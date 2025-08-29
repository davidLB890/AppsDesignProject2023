/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *

 */
public class BonificacionFrecuente extends TipoBonificacion{

    public BonificacionFrecuente(String nombre) {
        super(nombre);
    }


    
    @Override
    public int calcularBonificacion(Transito t) {
        if (t.getVehiculo().huboTransitoEnFecha(t.getPuesto(), t.getFecha())){
            return 50;
        }
        return 0;
    }

    
}
