/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *

 */
public class Administrador extends Usuario{


    public Administrador(int cedula, String contrasena, String nombreCompleto) {
        super(cedula,contrasena,nombreCompleto);
    }

    @Override
    public String toString() {
        return super.getNombreCompleto();
    }

   
    
}
