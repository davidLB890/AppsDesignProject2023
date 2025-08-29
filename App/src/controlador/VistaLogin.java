/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import logica.Usuario;

/**
 *

 */
public interface VistaLogin {
    void mostrarMensajeDeError(String mensaje);
    void cerrarVista();
    void ejecutarCasoDeUsoInicial(Usuario usuario);
}
