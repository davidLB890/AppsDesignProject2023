/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import vistaEscritorio.LogInAbstracto;
import controlador.ControladorLogin;
import controlador.ControladorLoginAdministrador;
import java.awt.Frame;
import logica.Administrador;
import logica.Usuario;


/**
 *

 */
public class LoginAdmin extends LogInAbstracto {
    
    public LoginAdmin(Frame parent, boolean modal){
        super(parent, modal, "Login Administrador");
    }

    @Override
    protected ControladorLogin crearControlador() {
        return new ControladorLoginAdministrador(this);

    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        new MenuAdministrador((Administrador)usuario).setVisible(true);
    }


     
    
}
