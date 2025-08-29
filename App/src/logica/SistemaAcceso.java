/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *

 */
public class SistemaAcceso {
    private static float saldoMinimo;
    
    private ArrayList<Administrador> administradores = new ArrayList();
    private ArrayList<Propietario> propietarios = new ArrayList();
    
    private ArrayList<Administrador> administradoresLogueados = new ArrayList();
    
    public void agregarAdministrador(Administrador a){
        administradores.add(a);
    }
    
    public void agregarPropietario(Propietario p){
        propietarios.add(p);
    }

    public Administrador loginAdministrador(int ci, String pass) throws PeajeException {
        Usuario u = login(ci, pass, administradores);
        if (u!=null){
            agregarLogueado((Administrador)u);
        }else{
            throw new PeajeException("Acceso denegado");
        }
        return (Administrador)u;

    }
    private void agregarLogueado(Administrador admin) throws PeajeException{
        if (!administradoresLogueados.contains(admin)){
            administradoresLogueados.add(admin);
        }else{
            throw new PeajeException("Ud. ya está logueado");
        }
    }
    public void logOutAdministrador(Administrador admin){
        administradoresLogueados.remove(admin);
    }

    public Propietario loginPropietario(int ci, String pass) throws PeajeException {
        Usuario u = login(ci, pass, propietarios);
        if (u==null){
            throw new PeajeException("Acceso denegado");
        }
        return (Propietario)u;
    }
    
    private Usuario login(int ci, String pass, ArrayList usuarios) {
            Usuario u = null;
            for(Object o:usuarios){
                u = (Usuario)o;
                if(u.getCedula()==(ci) && u.getContrasena().equals(pass)){
                    return u;
                }
            }
            u = null;
        return u;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public Propietario buscarPropietarioCi(int ci) throws PeajeException{
        Propietario prop = null;
        
        for(Propietario p: propietarios){
            if(p.getCedula()==ci) prop = p;
        }
        
        if(prop == null) throw new PeajeException("No existe el propietario");
        return prop;
    }
    // CU: Emular transito
    public Vehiculo buscarVehiculo(String matricula) throws PeajeException{
        Propietario propietarioNoEncontrado = null;
        for (Propietario p : propietarios) {
            Vehiculo buscado = p.buscarVehiculo(matricula);
            if (buscado!=null) {
                return buscado;
            }
        }
        throw new PeajeException("No existe el vehículo");
    }

     // CU: Emular transito
    public float getSaldoMinimo() {
        return saldoMinimo;
    }

     // CU: Emular transito
    public void setSaldoMinimo(float saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }
    
    public void comprobarSaldoMinino(Propietario prop){
        if(prop.getSaldo() <= this.saldoMinimo){
            Notificacion noti = new Notificacion("Tu saldo actual es de $" + prop.getSaldo() + " te recomendamos hacer una recarga");
            prop.agregarNotificacion(noti);
        }
    }

    
    

}
