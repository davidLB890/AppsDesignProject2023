/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.BonificacionAsignada;
import logica.Notificacion;
import logica.Recarga;
import logica.Transito;
import logica.Vehiculo;

/**
 *

 */
public interface VistaControlPropietario {
        public void error(String message);

    public void cargarNombre(String nombreCompleto);

    public void cargarSaldo(float saldo);

    public void mostrarVehiculos(ArrayList<Vehiculo> vehiculos);

    public void mostrarBonificaciones(ArrayList<BonificacionAsignada> bonificaciones);

    public void mostrarTransitos(ArrayList<Transito> transitos);

    public void mostrarRecargas(ArrayList<Recarga> recargasProp);

    public void mostrarNotificaciones(ArrayList<Notificacion> notificaciones);

}
