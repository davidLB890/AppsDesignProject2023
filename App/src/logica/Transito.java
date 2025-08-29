/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Calendar;
import java.util.Date;

/**
 *

 */
public class Transito {
    
    private Date fecha;
    // calculado en el momento de instanciar el objeto nuevo, constructor
    private float tarifaAplicada;
    // calculado en el momento de instanciar el objeto nuevo, constructor
    private float bonificacionAplicada;
    // calculado en el momento de instanciar el objeto nuevo, constructor
    private float importe;
    private BonificacionAsignada bonificacion;
    private Vehiculo vehiculo;
    private Puesto puesto;

    
    // contructor con fecha, para los tránsitos de datos de prueba
    public Transito(Date fecha, Vehiculo vehiculo, Puesto puesto) throws PeajeException {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.puesto = puesto;
        asignarTarifa();
        asignarBonificacion();
        calcularImporte();
        if (importe>vehiculo.getPropietario().getSaldo()) throw new PeajeException("Saldo insuficiente");
        agregarTransitoAListas();
    }
    
 
    // contructor sin fecha, para los tránsitos simulados
    public Transito(Vehiculo vehiculo, Puesto puesto) throws PeajeException {
        this.fecha = new Date();
        this.vehiculo = vehiculo;
        this.puesto = puesto;
        asignarTarifa();
        asignarBonificacion();
        calcularImporte();
        if (importe>vehiculo.getPropietario().getSaldo()) throw new PeajeException("Saldo insuficiente." + vehiculo.getPropietario().getSaldo() );
        agregarTransitoAListas();
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public double getTarifa() {
        return tarifaAplicada;
    }


    public Date getFecha() {
        return fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public float getImporte() {
        return importe;
    }

    public BonificacionAsignada getBonificacion() {
        return bonificacion;
    }

    public float getBonificacionAplicada() {
        return bonificacionAplicada;
    }

    
    
    private void asignarTarifa() {
        tarifaAplicada = puesto.buscarTarifa(vehiculo.getCategoria()).getMonto();
    }
    
    
    private void asignarBonificacion() {
        bonificacion =vehiculo.getPropietario().obtenerBonificacionParaPuesto(puesto);
        if (bonificacion !=null){
            bonificacionAplicada = bonificacion.getTipo().calcularBonificacion(this)*tarifaAplicada/100;
        }else{
            bonificacionAplicada =0;
        }
    }
    
    
    private void calcularImporte() {  
        this.importe = tarifaAplicada - bonificacionAplicada;
   
    }

    @Override
    public String toString() {
        String boni="Ninguna";
        
        if (bonificacion!=null){
            boni = bonificacion.getTipo().getNombre();
        }
        return "Transito{" + "fecha=" + fecha + ", tarifaAplicada=" + tarifaAplicada + ", bonificacionAplicada=" + bonificacionAplicada + ", importe=" + importe + ", bonificacion=" +boni ;      

    }

    private void agregarTransitoAListas() {
        vehiculo.agregarTransito(this);
        puesto.agregarTransito(this);
        vehiculo.getPropietario().setSaldo(vehiculo.getPropietario().getSaldo()-importe);
        vehiculo.getPropietario().agregarTransito(this);
    }

    public boolean esDiaDeSemana() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getFecha());
        
        if (cal.get(Calendar.DAY_OF_WEEK)>1 && cal.get(Calendar.DAY_OF_WEEK)<7){
            return true;
        }
        return false;
    }







    



    
    
}
