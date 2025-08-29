/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *

 */
public class SistemaRecarga {
 
    private ArrayList<Recarga> recargas = new ArrayList();
        
    // usuario agrega recarga, atributo administrador se agrega al aprobarse recarga
    public void agregarRecarga(Recarga recarga){
        recargas.add(recarga);
        Fachada.getInstancia().avisar(Fachada.eventos.cambioRecargas);
    }
    
    public ArrayList<Recarga> buscarRecargasPropietario(Propietario p){
        ArrayList<Recarga> recargasProp = new ArrayList();
        
        for(Recarga r: recargas){
            if(r.getPropietario().equals(p)){
                recargasProp.add(r);
            }
        }
        
        return recargasProp;
    }

    ArrayList<Recarga> buscarRecargasNoAprobadas() {
        ArrayList<Recarga> recargas = new ArrayList();
        
        for(Recarga r: this.recargas){
            if(r.getEstado()!="Aprobado"){
                recargas.add(r);
            }
        }
        
        return recargas;
    }
       
}
