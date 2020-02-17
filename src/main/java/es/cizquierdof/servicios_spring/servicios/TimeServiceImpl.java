package es.cizquierdof.servicios_spring.servicios;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * SERVICIO ReturnTimeImpl proporciona varios servicios utilizando las clases
 * Calendar y GregorianCalendar
 */
@Service
@RequestScope // genra un objeto por cada vez que se ejecuta el controlador
              // si no se pone es singelton es decir un unico objeto cuando se
              // levanta el servicio
public class TimeServiceImpl implements TimeService {

    private Calendar c;

    /********* DEVUELVE LA FECHA ACTUAL DEL SISTEMA************ */
    @Override
    public String fechaHoy() {

        return c.getTime().toString();

        /*
         * FORMA MANUAL DE HACERLO SIN UTILIZAR EL METODO toString() por defecto
         *
         * String d = Integer.toString(c.get(Calendar.DATE)); String m =
         * Integer.toString(c.get(Calendar.MONTH)); String a =
         * Integer.toString(c.get(Calendar.YEAR));
         * 
         * String h = Integer.toString(c.get(Calendar.HOUR)); String m =
         * Integer.toString(c.get(Calendar.MINUTE)); String s =
         * Integer.toString(c.get(Calendar.SECOND));
         * 
         * return d+"/"+m+"/"+a+" "+h+":"+m+":"+s;
         */
    }

    /*****************
     * DEVUELVE LA EDAD EN AÑOS A APRTIR DE LA FECHA DE NACIMIENTO****************
     */
    @Override
    public String edad(int d, int m, int a) {

        /*
         * Calendar ahora = GregorianCalendar.getInstance(); // obtenemos objeto
         * Calendar momento actual y //lo guardamos en el objeto ahora
         */

        Calendar fNacimiento = new GregorianCalendar(a, m - 1, d); // inicializamos fNacimiento como Calendar
                                                                   // con día, mes y año que nos han passado
                                                                   // (los meses empiezan desde el 0, así que hay que
                                                                   // restar 1)
        c.getTime();    //obtenemos fecha actual mediante el atributo c propio del servicio

        // Restamos el año de nacimiento del año actual (YEAR es un ccampo de la clase
        // Calendar que hace referencia al año del objeto)
        int edad = c.get(Calendar.YEAR) - fNacimiento.get(Calendar.YEAR);
        // corregimos el resultado si el dia del nacimiento es posterior al de la fecha
        // actual porque aun no ha cumplido el año
        if (fNacimiento.get(Calendar.DAY_OF_YEAR) > c.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return "La edad es " + edad; // devolvemos un String con la edad pedida
    }

    public TimeServiceImpl() {
        c = new GregorianCalendar();
    }

}