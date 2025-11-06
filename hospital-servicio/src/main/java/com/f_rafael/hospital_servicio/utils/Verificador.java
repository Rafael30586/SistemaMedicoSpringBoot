package com.f_rafael.hospital_servicio.utils;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import org.springframework.stereotype.Component;

@Component
public class Verificador {

    public void esIdODni(String opcion){
        if(opcion != "id" && opcion != "dni") throw new DatoIncorrectoException("Las opciones disponibles son id y dni");
    }
}
