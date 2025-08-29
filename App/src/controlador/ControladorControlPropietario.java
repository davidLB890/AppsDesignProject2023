/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Collections;
import logica.Fachada;
import logica.Notificacion;
import logica.Propietario;
import logica.Recarga;
import observador.Observable;
import observador.Observador;

/**
 *

 */
public class ControladorControlPropietario implements Observador{
    
    private Propietario propietario;
    private VistaControlPropietario vista;
    
    public ControladorControlPropietario(Propietario propietario, VistaControlPropietario vista){
        this.propietario = propietario;
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        this.propietario.agregarObservador(this);
        //TODO también debería haber otro que sea observador para estar al tanto de las recargas 
        //(ya que el propietario no conoce sus recargas)
        mostrarControl();
        
    }
    
    public void salir(){ // cerrar
        Fachada.getInstancia().quitarObservador(this);
        this.propietario.quitarObservador(this);
    }
    
    
    public void borrar(){
        propietario.eliminarNotificaciones();
        //esto no lo debería hacer si funcionara el evento de cambioListaNotificaciones.
        mostrarNotificaciones();
    }
    
    public void cargarNombre(){
        vista.cargarNombre(propietario.getNombreCompleto());
    }
    
    public void cargarSaldo(){
        vista.cargarSaldo(propietario.getSaldo());
    }
    
    public void mostrarVehiculos(){
        vista.mostrarVehiculos(propietario.getVehiculos());
    }
    
    public void mostrarBonificaciones(){
        vista.mostrarBonificaciones(propietario.getBonificaciones());
    }
    
    public void mostrarTransitos(){
        vista.mostrarTransitos(propietario.getTransitos());
    }
    
    public void mostrarRecargas(){
        ArrayList<Recarga> recargasProp = Fachada.getInstancia().buscarRecargasPropietario(propietario);
        Collections.sort(recargasProp, Collections.reverseOrder());
        vista.mostrarRecargas(recargasProp);
    }
    
    public void mostrarNotificaciones(){
        ArrayList<Notificacion> notificaciones = propietario.getNotificaciones();
        Collections.sort(notificaciones, Collections.reverseOrder());
        vista.mostrarNotificaciones(propietario.getNotificaciones());
    }

    private void mostrarControl() {
        cargarNombre();
        cargarSaldo();
        mostrarVehiculos();
        mostrarBonificaciones();
        mostrarTransitos();
        mostrarRecargas();
        mostrarNotificaciones();
    }

    public Propietario getPropietario() {
        return propietario;
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Fachada.eventos.cambioRecargas)){
            mostrarRecargas();
            cargarSaldo();
        } 
        else if(evento.equals(Propietario.eventos.cambiaSaldo)){
            cargarSaldo();
        }else if(evento.equals(Propietario.eventos.cambiaListaVehiculos)){
            mostrarVehiculos();
        }else if(evento.equals(Propietario.eventos.cambiaListaBonificaciones ) || evento.equals(Fachada.eventos.cambioBonificaciones)){
            mostrarBonificaciones();
        }else if(evento.equals(Propietario.eventos.cambiaListaTransitos)){
            mostrarTransitos();
            cargarSaldo();
        }else if(evento.equals(Propietario.eventos.cambiaListaNotificaciones)){
            mostrarNotificaciones();
        }
        
    }
}
