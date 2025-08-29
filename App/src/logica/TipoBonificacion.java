/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *

 */
public abstract class TipoBonificacion {
    
    private String nombre;

    public TipoBonificacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public abstract int calcularBonificacion(Transito t);

    @Override
    public String toString() {
        return nombre;
    }

    
}
