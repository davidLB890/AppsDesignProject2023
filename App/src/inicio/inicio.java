/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;

import vistaEscritorio.AprobacionRecargasDialogo;
import vistaEscritorio.AsignarBonificacionesDialogo;
import vistaEscritorio.LoginPropietarioDialogo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import logica.Fachada;
import logica.PeajeException;
import logica.PropietarioException;
import logica.Transito;
import logica.Vehiculo;
import vistaEscritorio.ControlPropietarioDialogo;
import vistaEscritorio.EmularTransitoDialogo;
import vistaEscritorio.TestingAplicacion;

/**
 *

 */
public class inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, PeajeException, PropietarioException {
        Fachada fachada = Fachada.getInstancia();

        // TODO code application logic here
        DatosPrueba.cargar();
        
        new TestingAplicacion().setVisible(true);



    }
    
}
