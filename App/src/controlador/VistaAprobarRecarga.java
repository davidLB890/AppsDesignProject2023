/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import logica.Recarga;

/**
 *

 */
public interface VistaAprobarRecarga {

    public void mostrarCargas(ArrayList<Recarga> recargasProp);
    public void error(String mensaje);
    
}
