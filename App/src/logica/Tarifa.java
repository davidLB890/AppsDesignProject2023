/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *

 */
public class Tarifa {
 
    private float monto;
    private Categoria categoria;

    public Tarifa(float monto, Categoria categoria) {
        this.monto = monto;
        this.categoria = categoria;
    }

       
    
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
  
    
}
