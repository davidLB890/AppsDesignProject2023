/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

/**
 *

 */
public interface VistaRecarga {

    public void cargarNombre(String nombreCompleto);

    public void cargarSaldo(float saldo);
    
    public void error(String message);

    public void limpiarCampos();

    
}
