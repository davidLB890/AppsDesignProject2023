/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.BonificacionAsignada;
import logica.Puesto;
import logica.TipoBonificacion;

/**
 *

 */
public interface VistaAsignarBonificacion {

    void mostrarBonificaciones(ArrayList<TipoBonificacion> tiposBonificacion);

    void mostrarPuestos(ArrayList<Puesto> puestos);

    public void mostrarBonificacionesPropietario(ArrayList<BonificacionAsignada> bonificaciones);

    public void mostrarNombre(String nombreCompleto);

    public void error(String message);
    
}
