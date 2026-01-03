package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Verificador {

    public void esEmail(String cadena){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$\n");
        Matcher matcher = pattern.matcher(cadena);

        if(!matcher.matches()) throw new DatoIncorrectoException("La dirección de email tiene un formato incorrecto");
    }

    public void tieneEspaciosVacios(String cadena){
        if(cadena.contains(" ")) throw new DatoIncorrectoException("La cadena de caracteres no debe tener espacios vacíos");
    }

    public void esNumeroTelefonico(String cadena){
        Pattern pattern = Pattern.compile("^\\\\d+(?:-\\\\d+)*$\n");
        Matcher matcher = pattern.matcher(cadena);

        if(!matcher.matches()) throw new DatoIncorrectoException("La cadena de caracteres  no es un número telefónico válido");
        tieneEspaciosVacios(cadena);
    }

    public void soloLetrasMinusculasEspaciosYGuionesMedios(String cadena){
        Pattern pattern = Pattern.compile("^[a-záéíóúñ]+(?:[- ][a-záéíóúñ]+)*$");
        Matcher matcher = pattern.matcher(cadena);

        if(!matcher.matches()) throw new DatoIncorrectoException("La cadena tiene caracteres no permitidos");
    }

    public void contieneGuiones(String cadena){
        if(cadena.contains("-")) throw new DatoIncorrectoException("LAcdena de caracteres no puede contener guiones medios");
    }
}
