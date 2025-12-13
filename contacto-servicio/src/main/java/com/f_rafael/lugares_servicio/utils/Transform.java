package com.f_rafael.lugares_servicio.utils;

public class Transform {

    public static String removerGuiones(String texto){ // Clase para borrar
        String textoSinGuiones = texto.replace('_',' ');
        return textoSinGuiones;
    }
}
