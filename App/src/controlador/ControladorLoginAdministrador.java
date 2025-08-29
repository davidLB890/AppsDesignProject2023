/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Administrador;
import logica.Fachada;
import logica.PeajeException;
import logica.Usuario;

/**
 *

 */
public class ControladorLoginAdministrador extends ControladorLogin{

    public ControladorLoginAdministrador(VistaLogin vista) {
        super(vista);
    }
    
    @Override
    protected Administrador llamarLogin(int cedula, String pass) {
       try {
            return Fachada.getInstancia().loginAdmin(cedula, pass);
        } catch (PeajeException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
        return null;
    }

    
}
