/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import vistaEscritorio.LogInAbstracto;
import controlador.ControladorLogin;
import controlador.ControladorLoginPropietario;
import java.awt.Frame;
import logica.Propietario;
import logica.Usuario;
import vistaEscritorio.ControlPropietarioDialogo;

/**
 *

 */
public class LoginPropietarioDialogo extends LogInAbstracto{
    
    public LoginPropietarioDialogo(Frame parent, boolean modal){
        super(parent, modal, "Login Propietario");
    }

    @Override
    protected ControladorLogin crearControlador() {
        return new ControladorLoginPropietario(this);
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        new ControlPropietarioDialogo(null, false, (Propietario)usuario).setVisible(true);
    }


    
}
