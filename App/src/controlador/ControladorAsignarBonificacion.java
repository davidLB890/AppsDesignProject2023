/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Administrador;
import logica.BonificacionAsignada;
import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.PropietarioException;
import logica.Puesto;
import logica.TipoBonificacion;
import observador.Observable;
import observador.Observador;

/**
 *

 */
public class ControladorAsignarBonificacion implements Observador{
    
    private Administrador admin;
    private Propietario prop;
    private VistaAsignarBonificacion vista;
    
    public ControladorAsignarBonificacion(Administrador admin, VistaAsignarBonificacion vista){
        this.admin = admin;
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        mostrarBonificaciones();
        mostrarPuestos();
    }
    
    public void salir(){
        Fachada.getInstancia().quitarObservador(this);
        
    }
    
    public void buscar(String cedula){
        
        if(cedula.isEmpty()){
            vista.error("No existe usuario");
        }else{
            Propietario prop = null;
            int ci=0;
            try{
                ci = Integer.parseInt(cedula);
                try{
                    prop = Fachada.getInstancia().buscarPropietarioCi(ci);
                    mostrarBonificacionesPropietario(prop);
                    mostrarNombre(prop);
                    this.prop=prop;
                }catch(PeajeException ex){
                    vista.error(ex.getMessage());
                }

            }catch(NumberFormatException nf){
                vista.error("No existe el propietario");
            }

        }
        
    }
    
    public void asignar(TipoBonificacion tipo, Puesto puesto, String cedula){
        Propietario prop = null;
        
        if(tipo == null){
           vista.error("Debe especificar bonificación");
       }else if(puesto == null){
           vista.error("Debe especificar puesto");
       }else if(cedula.isEmpty()){
           vista.error("Debe especificar cédula");
       }else{
            try{
               prop = Fachada.getInstancia().buscarPropietarioCi(Integer.parseInt(cedula));
               BonificacionAsignada nueva = new BonificacionAsignada(puesto, tipo);
               prop.agregarBonificaciones(nueva);
            }catch(PropietarioException ex){
               vista.error(ex.getMessage());
            } catch (PeajeException ex) {
               vista.error(ex.getMessage());
            }  
       }
        
        
       
       
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Fachada.eventos.cambioBonificaciones)){
            //mostrarBonificaciones();
            mostrarBonificacionesPropietario(this.prop);
        }
    }
    
    private void mostrarBonificaciones(){
        ArrayList<TipoBonificacion> tiposBonificacion = Fachada.getInstancia().getTiposBonificacion();
        vista.mostrarBonificaciones(tiposBonificacion);
    }
    
    private void mostrarPuestos(){
        ArrayList<Puesto> puestos = Fachada.getInstancia().getPuestos();
        vista.mostrarPuestos(puestos);
    }
    
    private void mostrarBonificacionesPropietario(Propietario prop){
        ArrayList<BonificacionAsignada> bonificaciones = prop.getBonificaciones();
        vista.mostrarBonificacionesPropietario(bonificaciones);
    }

    private void mostrarNombre(Propietario prop) {
        vista.mostrarNombre(prop.getNombreCompleto());
    }
    
}
