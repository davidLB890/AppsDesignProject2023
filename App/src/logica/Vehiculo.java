/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *

 */
public class Vehiculo {
    
    private String matricula;
    private String modelo;
    private String color;
    private ArrayList<Transito> transitos;
    private Categoria categoria;
    private Propietario propietario;
    

    public Vehiculo(String matricula, String modelo, String color, Categoria categoria, Propietario propietario) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.categoria = categoria;
        this.transitos = new ArrayList();
        this.propietario = propietario;
        agregarApropietario();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPrpietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Transito> getTransitos() {
        return transitos;
    }
    public boolean agregarTransito(Transito t){
        return transitos.add(t);
    }

    public boolean huboTransitoEnFecha(Puesto puesto, Date fecha) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(fecha);
    Calendar cal2 = Calendar.getInstance();
        for (Transito t:transitos){
            cal2.setTime(t.getFecha());
            if (cal1.get(Calendar.YEAR)== cal2.get(Calendar.YEAR) && 
                    cal1.get(Calendar.MONTH)== cal2.get(Calendar.MONTH) &&
                    cal1.get(Calendar.DAY_OF_MONTH)== cal2.get(Calendar.DAY_OF_MONTH)
                    && t.getPuesto().equals(puesto)){
                return true;
            }
        }
        return false;
    }

    private void agregarApropietario() {
        propietario.agregarVehiculo(this);
    }

    public float calcularGasto(){
        float gasto = 0;
        for (Transito t : transitos){
            gasto += t.getImporte();
        }
        return gasto;
    }
    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", modelo=" + modelo + ", color=" + color + ", categoria=" + categoria + ", propietario=" + propietario + ", transitos=" + transitos + '}';
    }
        
}
