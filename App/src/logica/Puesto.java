/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *

 */
public class Puesto {

    private String nombre;
    private String direccion;
    private ArrayList<Tarifa> tarifas;
    private ArrayList<Transito> transitos;

    public Puesto(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifas = new ArrayList();
        this.transitos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public ArrayList<Transito> getTransitos() {
        return transitos;
    }

    public void agregarTransito(Transito t) {
        transitos.add(t);
    }

    public void agregarTarifa(Tarifa nueva) {
        // buscar si existe una tarifa de la categoría nueva
        for (Tarifa t: tarifas){
            if(t.getCategoria().equals(nueva.getCategoria())){
                t.setMonto(nueva.getMonto());
                return;
            }
        }
        tarifas.add(nueva);
        
    }

    public Tarifa buscarTarifa(Categoria categoria) {
        for (Tarifa t : tarifas) {
            if (t.getCategoria().equals(categoria)) {
                return t;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

}
