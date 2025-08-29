/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import logica.Administrador;
import logica.BonificacionAsignada;
import logica.BonificacionExonerado;
import logica.BonificacionFrecuente;
import logica.BonificacionTrabajador;
import logica.Categoria;
import logica.Fachada;
import logica.Notificacion;
import logica.PeajeException;
import logica.Propietario;
import logica.PropietarioException;
import logica.Puesto;
import logica.Recarga;
import logica.Tarifa;
import logica.TipoBonificacion;
import logica.Transito;
import logica.Vehiculo;

/**
 *

 */
public class DatosPrueba {
        private static Fachada fachada = Fachada.getInstancia();
    
    public static void cargar() throws ParseException, PeajeException, PropietarioException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        // agrego usuarios 
        Administrador a1 = new Administrador(1, "a", "Ana Perez");
        Administrador a2 = new Administrador(2, "b", "Beatriz Gonzalez");
        
        fachada.agregarAdministrador(a1);
        fachada.agregarAdministrador(a2);
        
        Propietario p3 = new Propietario(3, "d", "Dionisio Almada");
        Propietario p4 = new Propietario(4, "e", "Elias Sanchez");
        Propietario p5 = new Propietario(5, "f", "Fiorella Voix");
        Propietario p6 = new Propietario(6, "g", "Guillermo Mendez");
        Propietario p7 = new Propietario(7, "h", "Hilario Williams");
        Propietario p8 = new Propietario(8, "i", "Ignacio Al-Salam");
        
        fachada.agregarPropietario(p3);
        fachada.agregarPropietario(p4);
        fachada.agregarPropietario(p5);
        fachada.agregarPropietario(p6);
        fachada.agregarPropietario(p7);
        fachada.agregarPropietario(p8);
        
        

        Recarga r1 = new Recarga(formato.parse("05/02/2019"),800,p3);
        Recarga r2 = new Recarga(formato.parse("05/01/2018"),(1400),p4);
        Recarga r3 = new Recarga(formato.parse("01/09/2020"),(500),p3);
        Recarga r4 = new Recarga(formato.parse("07/02/2018"),(10),p3);
        Recarga r5 = new Recarga(formato.parse("05/02/2018"),(3000),p5);
        Recarga r6 = new Recarga(formato.parse("07/03/2018"),(3000),p6);
        Recarga r7 = new Recarga(formato.parse("20/01/2018"),(2000),p7);
        Recarga r8 = new Recarga(formato.parse("10/02/2018"),(1500),p8);

        fachada.agregarRecarga(r1);
        fachada.agregarRecarga(r2);
        fachada.agregarRecarga(r3);
        fachada.agregarRecarga(r4);
        fachada.agregarRecarga(r5);
        fachada.agregarRecarga(r6);
        fachada.agregarRecarga(r7);
        fachada.agregarRecarga(r8);
        r1.aprobarRecarga(a2);
        r2.aprobarRecarga(a2);
        r5.aprobarRecarga(a2);
        r6.aprobarRecarga(a2);
        r7.aprobarRecarga(a2);
        r8.aprobarRecarga(a2);

           
       // agrego categorias
        Categoria c1 = new Categoria("Motocicleta"); 
        Categoria c2 = new Categoria("Automovil");
        Categoria c3 = new Categoria("Camion");
        Categoria c4 = new Categoria("Omnibus");
        
       // agrego vehiculos 

        Vehiculo V2 = new Vehiculo("V2", "Harley Davidson", "Negra", c1,p3);
        Vehiculo V7 = new Vehiculo("V7", "Scania S1 ", "Rojo", c3,p3);
        
        Vehiculo V1 = new Vehiculo("V1", "Vespa", "Verde", c1,p4);
        Vehiculo V8 = new Vehiculo("V8", "Nissan N1 ", "Azul", c3,p4);

        Vehiculo V3 = new Vehiculo("V3", "VW Gol", "Blanco", c2,p5);
        Vehiculo V9 = new Vehiculo("V9", "Leyland L1 ", "Negro", c4,p5);
        
        Vehiculo V4 = new Vehiculo("V4", "Fitito ", "Rojo", c2,p6);
        Vehiculo V10 = new Vehiculo("V10", "Iveco I1 ", "Blanco", c4,p6);

        Vehiculo V5 = new Vehiculo("V5", "Chevette", "Gris", c2,p7);

        Vehiculo V6 = new Vehiculo("V6", "Volvo V1 ", "Negro", c3,p8);


     
        
        // agrego puestos 
        Puesto pu1 = new Puesto("HyG", "Ruta 5 km 67.700");
        Puesto pu2 = new Puesto("Camino a las Sierras", "Ruta 8 km 50.500 ");
        Puesto pu3 = new Puesto("Cebollati", "Ruta 8 km 206.250");
        Puesto pu4 = new Puesto("Garzon", "Ruta 9 km 177.650");
        
        // No los voy a usar en un principio
        /*
        Puesto pu5 = new Puesto("Pando", "Ruta Interbalnearia km 32.400");
        Puesto pu6 = new Puesto("Solis", "Ruta Interbalnearia km 81");
        Puesto pu7 = new Puesto("Cufre", "Ruta 1 km350 ");
        */
        
        fachada.agregarPuesto(pu1);
        fachada.agregarPuesto(pu2);
        fachada.agregarPuesto(pu3);
        fachada.agregarPuesto(pu4);
        
         // agrego tarifas        
        Tarifa ta1 = new Tarifa(100, c1);
        Tarifa ta2 = new Tarifa(120, c2);
        Tarifa ta3 = new Tarifa(200, c3);
        Tarifa ta4 = new Tarifa(250, c4);

        Tarifa ta5 = new Tarifa(80, c1);
        Tarifa ta6 = new Tarifa(120, c2);
        Tarifa ta7 = new Tarifa(150, c3);
        Tarifa ta8 = new Tarifa(280, c4);

        Tarifa ta9 = new Tarifa(50, c1);
        Tarifa ta10 = new Tarifa(90, c2);
        Tarifa ta11 = new Tarifa(120, c3);
        Tarifa ta12 = new Tarifa(150, c4);

        Tarifa ta13 = new Tarifa(200, c1);
        Tarifa ta14 = new Tarifa(220, c2);
        Tarifa ta15 = new Tarifa(400, c3);
        Tarifa ta16 = new Tarifa(550, c4);

        // asigno tarifas a puestos
        pu1.agregarTarifa(ta1);
        pu1.agregarTarifa(ta2);
        pu1.agregarTarifa(ta3);
        pu1.agregarTarifa(ta4);
        pu2.agregarTarifa(ta5);
        pu2.agregarTarifa(ta6);
        pu2.agregarTarifa(ta7);
        pu2.agregarTarifa(ta8);
        pu3.agregarTarifa(ta9);
        pu3.agregarTarifa(ta10);
        pu3.agregarTarifa(ta11);
        pu3.agregarTarifa(ta12);
        pu4.agregarTarifa(ta13);
        pu4.agregarTarifa(ta14);
        pu4.agregarTarifa(ta15);
        pu4.agregarTarifa(ta16);
        
               

        // Bonificaciones 
        
        // ---->(ARMAR MAS Y ASIGNARLAS A DIAGRAMA DE ABAJO)
        
        
        //EXONERADO
        TipoBonificacion b1 = Fachada.getInstancia().getTiposBonificacion().get(0);
        //FRECUENTE
        TipoBonificacion b2 = Fachada.getInstancia().getTiposBonificacion().get(1);
        //TRABAJADOR
        TipoBonificacion b3 = Fachada.getInstancia().getTiposBonificacion().get(2);
        
        
        
        p3.agregarBonificaciones(new BonificacionAsignada(pu1,b3));
        //p4.agregarBonificaciones(new BonificacionAsignada(pu2,b3));
        p5.agregarBonificaciones(new BonificacionAsignada(pu3,b1));
        p6.agregarBonificaciones(new BonificacionAsignada(pu4,b2));

        // TRÁNSITOS. Para que los datos sean consistentes agrego tránsitos por fecha ascendente 
        
        
             
        Transito t1 = new Transito(formato.parse("23/01/2021"), V1,pu2);
        
        // pruebo bonificación b3: trabajador, tránsitos en fecha de semana
        Transito t2 = new Transito(formato.parse("03/02/2021"), V2,pu1);
        Transito t21 =new Transito(formato.parse("06/02/2021"), V2,pu1); 
        
        // pruebo bonificación b1: exonerado
        Transito t3 = new Transito(formato.parse("25/03/2021"), V9,pu3);
        Transito t20 = new Transito(formato.parse("30/4/2023"), V9,pu4); 
        
        Transito t13 = new Transito(formato.parse("15/06/2022"), V3,pu1);
        Transito t19 = new Transito(formato.parse("31/03/2023"), V9,pu3);
       
        
        
        // pruebo bonificación b2: frecuente    
        Transito t4 = new Transito(formato.parse("05/04/2021"), V4,pu4);
        Transito t5 = new Transito(formato.parse("05/04/2021"), V4,pu4);       
        Transito t6 = new Transito(formato.parse("20/01/2022"), V4,pu4);
        
        Transito t14 = new Transito(formato.parse("20/07/2022"), V4,pu2);       
        Transito t10 = new Transito(formato.parse("30/5/2022"), V10,pu2);
        
        
        //Transito t7 = new Transito(formato.parse("30/02/2022"), v6,pu2);
        Transito t8 = new Transito(formato.parse("04/03/2022"), V7,pu1);
        Transito t9 = new Transito(formato.parse("17/04/2022"), V8,pu4);    

        Transito t11 = new Transito(formato.parse("04/06/2022"), V1,pu3);
        Transito t12 = new Transito(formato.parse("05/06/2022"), V2,pu4);

        
        

        Transito t15 = new Transito(formato.parse("30/08/2022"), V5,pu3);
        //Transito t16 = new Transito(formato.parse("04/09/2022"), v6,pu4);
        Transito t17 = new Transito(formato.parse("17/12/2022"), V7,pu1);
        Transito t18 = new Transito(formato.parse("25/02/2023"), V8,pu2);
        
        

        
        
       
        // agrego notificaciones
        
        Notificacion n1 = new Notificacion(formato.parse("01/01/2023"), "Feliz año nuevo");      
        Notificacion n2 = new Notificacion(formato.parse("01/05/2023"), "Promoción Día de la madre");
        Notificacion n3 = new Notificacion(formato.parse("01/02/2023"), "Promoción 1");
        Notificacion n4 = new Notificacion(formato.parse("01/04/2023"), "Promocion 2");
        
        
        // asigno notificaciones a usuarios
        p3.agregarNotificacion(n1);
        p4.agregarNotificacion(n1);
        
        p5.agregarNotificacion(n1);
        p5.agregarNotificacion(n2);
        p5.agregarNotificacion(n3);
        
        
        p6.agregarNotificacion(n1);
        p7.agregarNotificacion(n1);
        p8.agregarNotificacion(n1);
        p3.agregarNotificacion(n2);
        p4.agregarNotificacion(n2);

        p6.agregarNotificacion(n2);
        p7.agregarNotificacion(n2);
        p8.agregarNotificacion(n2);
        p3.agregarNotificacion(n3);
        p4.agregarNotificacion(n3);
        
        p6.agregarNotificacion(n4);
        p7.agregarNotificacion(n4);
        p8.agregarNotificacion(n4);
   
        fachada.setSaldoMinimo(120);
 
        
       
        }
}
