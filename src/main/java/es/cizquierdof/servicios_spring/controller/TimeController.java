package es.cizquierdof.servicios_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.cizquierdof.servicios_spring.servicios.HolaServicio;
import es.cizquierdof.servicios_spring.servicios.TimeService;

/**
 * CONTROLADOR timeController
 */

@Controller
public class TimeController {

    /**************GENERA SERGVICIOS AUTOMATICAMENTE************ */
    @Autowired
    private HolaServicio holaServicio;
    @Autowired
    private TimeService timeService;

    /****************************************************
     * LLAMA AL METODO hola() DEL SERVICIO holaServicio
     **************************************************/
    @GetMapping("/time") // mapeamos lo que hay que intorducir en el browser
    @ResponseBody // respuesta que provoca el mapeado anterior
    public String hola() {
        return holaServicio.hola();
    }

    /******************************************************
     * DEVUELVE LA FECHA Y HORA DEL SISTEMA
     */
    @GetMapping("/hoy")
    @ResponseBody
    public String Hoy(@RequestParam("n") String nom) {
        return "la fecha de hoy es: " + timeService.fechaHoy() + " " + nom;
    }

    /**************************************************************
     * DEVUELVE LA EDAD PARTIENDO DE LA FECHA DE NACIMIENTO
     */
    @GetMapping("/edad") // mapeamos una url /edad que dispare el servicio
    @ResponseBody // le pedimos que responda en el body
    public String edad(@RequestParam("d") Integer d, // tomamos los parametros de la url
            @RequestParam("m") Integer m, // los definimos como Integer con int no funciona
            @RequestParam("a") Integer a) {

        return timeService.edad(d, m, a);
    }

}