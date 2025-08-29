/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Puesto;
import logica.Tarifa;
import logica.Transito;

/**
 *

 */
public interface VistaEmularTransito {
    
    public void mostrarPuestos(ArrayList<Puesto> puestos);
    
    public void mostrarTarifas(ArrayList<Tarifa> tarifas);
    
    public void registrarTransito();

    public void limpiarCampos();
    
    public void mostrarTarifasVacio();
    
    public void mostrarResultadoBonificacion(Transito transitoNuevo);

    public void mostrarResultadoSinBonificacion(Transito transitoNuevo);
    
    public void error(String mensaje);

   
    
}
