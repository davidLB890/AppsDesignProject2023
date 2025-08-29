/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Recarga;
import observador.Observable;
import observador.Observador;

/**
 *

 */
public class ControladorRecarga implements Observador{
    
    private Propietario propietario;
    private VistaRecarga vista;
    
    public ControladorRecarga(Propietario prop, VistaRecarga vista){
        this.propietario = prop;
        this.vista = vista;
        propietario.agregarObservador(this);
        cargarNombre();
        cargarSaldo();
    }
    
    public void agregarRecarga(String monto) {
       float m;
       try{
           m = Float.parseFloat(monto);
           try{   
                Recarga nueva = new Recarga(m, propietario);        
                Fachada.getInstancia().agregarRecarga(nueva);     
                vista.limpiarCampos();
            }catch (PeajeException pe){
                vista.error(pe.getMessage());
            }
       }catch (NumberFormatException nf){
           vista.error("Monto inválido");
       }
       



    }

    public void salir(){ 
        propietario.quitarObservador(this);
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        cargarSaldo();
    }
    
    public void cargarNombre(){
        vista.cargarNombre(propietario.getNombreCompleto());
    }
    
    public void cargarSaldo(){
        vista.cargarSaldo(propietario.getSaldo());
    }


    
}
