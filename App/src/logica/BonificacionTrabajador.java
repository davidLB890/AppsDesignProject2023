/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;



/**
 *

 */
public class BonificacionTrabajador extends TipoBonificacion{

    public BonificacionTrabajador(String nombre) {
        super(nombre);
    }

    
    @Override
    public int calcularBonificacion(Transito t) {
        
        if (t.esDiaDeSemana()){
            return 80;
        }
        return 0;
    }

    
}
