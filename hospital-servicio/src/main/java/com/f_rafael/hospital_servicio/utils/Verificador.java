package com.f_rafael.hospital_servicio.utils;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Verificador {

    public void esIdODni(String opcion){
        if(opcion != "id" && opcion != "dni") throw new DatoIncorrectoException("Las opciones disponibles son id y dni");
    }

    public void esAnterior(LocalDate inicio, LocalDate fin){
        if(inicio.isAfter(fin) && fin != null) throw new DatoIncorrectoException("La primera fecha debe ser anterior a la segunda");
    }

    public void esAnterior(LocalTime inicio, LocalTime fin){
        if(inicio.isAfter(fin)) throw new DatoIncorrectoException("El primer horario debe ser anterior al segundo");
    }

    public void esMenor(Double minimo, Double maximo){
        if(minimo > maximo) throw new DatoIncorrectoException("El valor mínimo no puede ser mayor que el máximo");
    }

    public void esEmail(String cadena){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(cadena);

        if(!matcher.matches()) throw new DatoIncorrectoException("La dirección de email tiene un formato incorrecto");
    }

    public void tieneEspaciosVacios(String cadena){
        if(cadena.contains(" ")) throw new DatoIncorrectoException("La cadena de caracteres no debe tener espacios vacíos");
    }

    public void esNumeroTelefonico(String cadena){
        Pattern pattern = Pattern.compile("^\\d+(?:-\\d+)*$\n");
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
