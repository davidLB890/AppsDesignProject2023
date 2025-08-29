/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import observador.Observable;

/**
 *

 */
public class Fachada extends Observable{
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaRecarga sRecarga = new SistemaRecarga();
    private SistemaPuestos sPuestos = new SistemaPuestos();
    
    private static Fachada instancia = new Fachada();


    
    public enum eventos{cambioRecargas, cambioBonificaciones};
    
    // Singleton
    public static Fachada getInstancia() {
        return instancia;
    }

    //TODO: Chequear que este constructor vacío esté correcto
    private Fachada() {
    }

    public void agregarAdministrador(Administrador a) {
        sAcceso.agregarAdministrador(a);
    }

    public void agregarPropietario(Propietario p) {
        sAcceso.agregarPropietario(p);
    }

    public void agregarPuesto(Puesto puesto) {
        sPuestos.agregarPuesto(puesto);
    }

    public void agregarRecarga(Recarga recarga) {
        sRecarga.agregarRecarga(recarga);
    }
    
    /* ESTO NO VA ACÁ POR EXPERTO
    public void agregarBonificacion(TipoBonificacion tipo, Puesto pu ,Propietario p){
        sAcceso.agregarBonificacion(tipo, pu, p);
    }
*/

    public ArrayList<Propietario> getPropietarios() {
        return sAcceso.getPropietarios();
    }
    public ArrayList<Administrador> getAdministradores() {
        return sAcceso.getAdministradores();
    }

    public ArrayList<TipoBonificacion> getTiposBonificacion() {
        return sPuestos.getTiposBonificacion();
    }
    
    public ArrayList<Puesto> getPuestos(){
        return sPuestos.getPuestos();
    }
      
    public Administrador loginAdmin(int ci, String pass) throws PeajeException {
        return sAcceso.loginAdministrador(ci, pass);
    }
    
    public Propietario loginPropietario(int ci, String pass) throws PeajeException {
        return sAcceso.loginPropietario(ci, pass);
    }
    
    public void logOutAdministrador(Administrador admin) {
        sAcceso.logOutAdministrador(admin);
    }

    public ArrayList<Recarga> buscarRecargasPropietario(Propietario p){
        return sRecarga.buscarRecargasPropietario(p);
    }
    
    public Propietario buscarPropietarioCi(int ci) throws PeajeException{
        return sAcceso.buscarPropietarioCi(ci);
    }
    
    public ArrayList<Recarga> buscarRecargasNoAprobadas(){
        return sRecarga.buscarRecargasNoAprobadas();
    }
    // CU: Emular transito
    public Vehiculo buscarVehiculo(String matricula) throws PeajeException {
        return sAcceso.buscarVehiculo(matricula);
    }
    
    public void comprobarSaldoMinino(Propietario prop){
        sAcceso.comprobarSaldoMinino(prop);
    }
    
    public void setSaldoMinimo(float monto){
        sAcceso.setSaldoMinimo(monto);
    }
}
