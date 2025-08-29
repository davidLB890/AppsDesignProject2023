/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 *

 */
public class Propietario extends Usuario{

    
    public enum eventos{cambiaListaNotificaciones, cambiaListaTransitos, 
                        cambiaListaVehiculos, cambiaSaldo, cambiaListaBonificaciones};

    
    private float saldo;
    private ArrayList<Notificacion> notificaciones;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Transito> transitos;
    private ArrayList<BonificacionAsignada> bonificaciones;
    
    
    
    public Propietario(int cedula, String contrasena,String nombreCompleto) {
        super(cedula,contrasena,nombreCompleto);
        this.saldo = 0;
        this.bonificaciones = new ArrayList();
        this.notificaciones= new ArrayList();
        this.vehiculos= new ArrayList();
        this.transitos = new ArrayList();
    }

    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }
    
    public void agregarNotificacion(Notificacion n){
        notificaciones.add(n);
        avisar(eventos.cambiaListaNotificaciones);
    }
    
    public void eliminarNotificaciones(){
        notificaciones = new ArrayList(); 
        avisar(eventos.cambiaListaNotificaciones);
    }
    
    public void agregarTransito(Transito t){
        if (!transitos.contains(t)){
            transitos.add(0,t);
            agregarNotificacion("Pasaste por el puesto " + t.getPuesto().getNombre() + " con el vehículo " + t.getVehiculo().getMatricula(), t.getFecha());
            avisar(eventos.cambiaListaTransitos);
            Fachada.getInstancia().avisar(eventos.cambiaListaTransitos);
        }
    }

    public ArrayList<Transito> getTransitos() {
        return transitos;
    }
    public void agregarSaldo(float monto){
        saldo+=monto;
        avisar(eventos.cambiaSaldo);
    }
    
    
    //retorna false si no puede agregar
    public void agregarBonificaciones(BonificacionAsignada b) throws PropietarioException{
        if (existeBonificacionParaElPuesto(b)){
            throw new PropietarioException("Ya tiene una Bonificación asignada para ese puesto");
        }else{
            bonificaciones.add(b);
            avisar(eventos.cambiaListaBonificaciones);
            Fachada.getInstancia().avisar(Fachada.eventos.cambioBonificaciones);
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<BonificacionAsignada> getBonificaciones() {
        return bonificaciones;
    }
    
    public BonificacionAsignada obtenerBonificacionParaPuesto(Puesto p){
        for (BonificacionAsignada b : bonificaciones){
            if (b.getPuesto().equals(p)){
                return b;
            }
        }
        return null;
    }
    
    public Vehiculo buscarVehiculo(String matricula) {
        for(Vehiculo v:vehiculos){
            if(v.getMatricula().equals(matricula)){
                return v;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return super.getNombreCompleto()+"{" + "saldo=" + saldo + ", bonificaciones=" + bonificaciones + ", notificaciones=" + notificaciones;
    }

    private boolean existeBonificacionParaElPuesto(BonificacionAsignada b) {
        for(BonificacionAsignada bonif:bonificaciones){
            if(bonif.getPuesto().equals(b.getPuesto())){
                return true;
            }
        }
        return false;
    }

    public void agregarNotificacion(String mensaje, Date fecha) {
        Notificacion nueva = new Notificacion(fecha, mensaje);
        notificaciones.add(nueva);
        avisar(eventos.cambiaListaNotificaciones);
    }
    
}
