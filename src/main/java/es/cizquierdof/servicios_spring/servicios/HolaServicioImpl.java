package es.cizquierdof.servicios_spring.servicios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * HolaServicioImpl
 */
@Service
public class HolaServicioImpl implements HolaServicio{

    @Value(value = "${mi_nombre}")
    private String miNombre;

    @Override
    public String hola() {
        return "hola "+ miNombre;
    }

     
    
}