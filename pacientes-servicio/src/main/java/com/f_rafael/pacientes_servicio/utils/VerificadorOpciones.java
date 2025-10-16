package com.f_rafael.pacientes_servicio.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VerificadorOpciones {
    public boolean idODni(String opcion){
        if(!opcion.equals("dni") && !opcion.equals("id")){
            return false;
        }
        return true;
    }
}
