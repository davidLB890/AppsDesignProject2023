/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Usuario;

/**
 *

 */
public class ControladorLoginPropietario extends ControladorLogin {

    public ControladorLoginPropietario(VistaLogin vista) {
        super(vista);
    }


    @Override
    protected Propietario llamarLogin(int cedula, String pass) {
        try {
            return Fachada.getInstancia().loginPropietario(cedula, pass);
        } catch (PeajeException ex) {
            vista.mostrarMensajeDeError(ex.getMessage());
        }
        return null;
    }

}
