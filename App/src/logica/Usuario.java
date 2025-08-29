/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import observador.Observable;

/**
 *

 */
public abstract class Usuario extends Observable{
    
    private int cedula;
    private String contrasena;
    private String nombreCompleto;

    public Usuario(int cedula, String contrasena, String nombreCompleto) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    
    
}
