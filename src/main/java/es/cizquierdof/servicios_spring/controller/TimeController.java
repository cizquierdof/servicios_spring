package es.cizquierdof.servicios_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * time
 */
@Controller
public class TimeController {
@GetMapping("/time")
@ResponseBody
public String hola(){
    return "hola";
}

    
}