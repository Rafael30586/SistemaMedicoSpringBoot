package com.f_rafael.hospital_servicio.utils;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import org.springframework.stereotype.Component;

@Component
public class Verificador {

    public boolean esIdODni(String opcion){
        if(opcion == null) throw new CampoNuloException("La opción no puede ser nula");
        if(opcion.equals("dni") || opcion.equals("id")) return true;
        else return false;
    }
}
