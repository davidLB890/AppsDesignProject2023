/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Fachada;
import logica.PeajeException;
import logica.Puesto;
import logica.Tarifa;
import logica.Transito;
import logica.Vehiculo;

/**
 *

 */
public class ControladorEmularTransito{

    private VistaEmularTransito vista;
    private Puesto puestoSeleccionado;

    public ControladorEmularTransito(VistaEmularTransito vista) {
        this.vista = vista;
        cargarPuestos();
        cargarTarifas(); 
    }

    private void cargarPuestos() {
        ArrayList<Puesto> puestos = Fachada.getInstancia().getPuestos();
        vista.mostrarPuestos(puestos);
    }

    private void cargarTarifas() {
        if (puestoSeleccionado!=null){
            vista.mostrarTarifas(puestoSeleccionado.getTarifas());
        }   
    }

    public ArrayList<Tarifa> obtenerTarifas(Puesto p) {
        return p.getTarifas();
    }


    public void agregarTransito(String matricula) throws PeajeException {//throws PeajeException {

        if (this.puestoSeleccionado == null) {
            throw new PeajeException("Debes seleccionar un puesto");
        }
        Vehiculo vehiculo = null;
        Transito transitoNuevo = null;
        try {
            vehiculo = Fachada.getInstancia().buscarVehiculo(matricula);
            transitoNuevo = new Transito(vehiculo, this.puestoSeleccionado);
            limpiarCampos();
            Fachada.getInstancia().comprobarSaldoMinino(vehiculo.getPropietario());
            if (transitoNuevo.getBonificacion() != null) {
                vista.mostrarResultadoBonificacion(transitoNuevo);
            } else {
                vista.mostrarResultadoSinBonificacion(transitoNuevo);
            }
        } catch (PeajeException ex) {
            vista.error(ex.getMessage());
        }

    }

    private void limpiarCampos() {
        vista.limpiarCampos();
    }

    public void hayPuestoSeleccionado(Puesto puesto) {
            puestoSeleccionado = puesto;
            vista.mostrarTarifas(puestoSeleccionado.getTarifas());
    }
    public void noHayPuestoSeleccionado(){
        puestoSeleccionado = null;
        vista.mostrarTarifas(new ArrayList<>());
    }

}
