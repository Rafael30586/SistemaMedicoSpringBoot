package com.f_rafael.hospital_servicio.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class StringMapper {

    public String quitarGuionesBajos(String palabras){
        return palabras.replace('_',' ');
    }
}
