package com.f_rafael.hospital_servicio.utils;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Verificador {

    public void esIdODni(String opcion){
        if(opcion != "id" && opcion != "dni") throw new DatoIncorrectoException("Las opciones disponibles son id y dni");
    }

    public void esAnterior(LocalDate inicio, LocalDate fin){
        if(inicio.isAfter(fin) && fin != null) throw new DatoIncorrectoException("La primera fecha debe ser anterior a la segunda");
    }
}
