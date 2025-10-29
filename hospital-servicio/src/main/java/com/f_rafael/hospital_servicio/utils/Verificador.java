package com.f_rafael.hospital_servicio.utils;

import org.springframework.stereotype.Component;

@Component
public class Verificador {

    public boolean esIdODni(String opcion){
        if(opcion.equals("dni") || opcion.equals("id")) return true;
        else return false;
    }
}
