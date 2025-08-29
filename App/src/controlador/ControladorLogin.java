/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.PeajeException;
import logica.Usuario;

/**
 *

 */
public abstract class ControladorLogin {
    protected VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }

    public void login(String cedula, String pass) throws PeajeException {
        int c;
          try {
            c = Integer.parseInt(cedula);
          } catch (NumberFormatException e) {
            throw new PeajeException ("La cédula debe contener solo dígitos");
          }
       
        Usuario usuario = llamarLogin(c, pass);
        if (usuario !=null) {
            vista.ejecutarCasoDeUsoInicial(usuario);
            vista.cerrarVista();
        } 
    }


    protected abstract Usuario llamarLogin(int cedula, String pass);
}
