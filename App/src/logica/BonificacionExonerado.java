/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *

 */
public class BonificacionExonerado extends TipoBonificacion{

    public BonificacionExonerado(String nombre) {
        super(nombre);
    }


    
    

    @Override
    public int calcularBonificacion(Transito t) {
        return 100;
    }


    
}
