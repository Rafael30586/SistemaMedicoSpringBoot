package com.f_rafael.farmacia_servicio.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StringMapper {

    public String removerGuionesBajos(String texto){
        return texto.replace('_',' ');
    }
}
