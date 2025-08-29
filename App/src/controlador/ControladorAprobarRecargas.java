/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Administrador;
import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Recarga;
import logica.SistemaRecarga;
import observador.Observable;
import observador.Observador;

/**
 *

 */
public class ControladorAprobarRecargas implements Observador{
    
    private Administrador admin;
    private VistaAprobarRecarga vista;
    //private Propietario propietario;
    
    public ControladorAprobarRecargas(Administrador admin, VistaAprobarRecarga vista){
       this.admin = admin;
       this.vista = vista;
       Fachada.getInstancia().agregarObservador(this);
       mostrarRecargas();
    }
    
    public void salir(){ // cerrar
        Fachada.getInstancia().quitarObservador(this);
    }
    
    public void aprobar(Recarga recarga) throws PeajeException{
        if(recarga==null) throw new PeajeException("Debes seleccionar una recarga");
        recarga.aprobarRecarga(admin);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Fachada.eventos.cambioRecargas)){
            mostrarRecargas();
        }
    }

    private void mostrarRecargas() {
        ArrayList<Recarga> recargas = Fachada.getInstancia().buscarRecargasNoAprobadas();
        vista.mostrarCargas(recargas);
    }
    
    
}
