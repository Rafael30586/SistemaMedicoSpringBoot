package com.f_rafael.lugares_servicio.utils;

import com.f_rafael.lugares_servicio.exception.DatoIncorrectoException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Verificador {

    public void tieneEspaciosVacios(String cadena){
        if(cadena.contains(" ")) throw new DatoIncorrectoException("La cadena de caracteres no debe tener espacios vacíos");
    }

    public void soloLetrasMinusculasEspaciosYGuionesMedios(String cadena){
        Pattern pattern = Pattern.compile("^[a-z]+(?:[- ][a-z]+)*$\n");
        Matcher matcher = pattern.matcher(cadena);

        if(!matcher.matches()) throw new DatoIncorrectoException("La cadena tiene caracteres no permitidos");
    }

    public void contieneGuiones(String cadena){
        if(cadena.contains("-")) throw new DatoIncorrectoException("LAcdena de caracteres no puede contener guiones medios");
    }
}
