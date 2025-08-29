/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;

/**
 *

 */
public class Recarga implements Comparable<Recarga> {

    private Date fecha;
    private float monto;
    private Propietario propietario;
    // al aprobarse, se asina un Amdin a bonificacion
    private Administrador administrador;
    private String estado;

    // las recargas nuevas
    public Recarga(float monto, Propietario propietario) throws PeajeException {
        if (monto< 1) {
            throw new PeajeException("Monto inválido");
        }
        this.fecha = new Date();
        this.monto = monto;
        this.propietario = propietario;
        this.estado = "En espera";
        // al aprobarse, se asina un Amdin a bonificacion
        this.administrador = null;
    }

    // las recargas historias (de datos de prueba)
    public Recarga(Date fecha, float monto, Propietario propietario) {
        this.fecha = fecha;
        this.monto = monto;
        this.propietario = propietario;
        this.estado = "En espera";
        // al aprobarse, se asina un Amdin a bonificacion
        this.administrador = null;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    //Aca se setea el administrador
    public void aprobarRecarga(Administrador administrador) {
        this.administrador = administrador;
        this.estado = "Aprobado";
        propietario.agregarSaldo(monto);
        propietario.agregarNotificacion("Tu recarga de $ " + monto + " fue aprobada", new Date());
        Fachada.getInstancia().avisar(Fachada.eventos.cambioRecargas);
    }

    @Override
    public int compareTo(Recarga o) {
        return getFecha().compareTo(o.getFecha());
    }

}
