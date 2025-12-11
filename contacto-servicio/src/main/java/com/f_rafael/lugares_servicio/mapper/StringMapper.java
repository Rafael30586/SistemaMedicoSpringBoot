package com.f_rafael.lugares_servicio.mapper;

import org.springframework.stereotype.Component;

@Component
public class StringMapper {

    public String quitarGuionesBajos(String cadena){
        return cadena.replace('_',' ');
    }
}
