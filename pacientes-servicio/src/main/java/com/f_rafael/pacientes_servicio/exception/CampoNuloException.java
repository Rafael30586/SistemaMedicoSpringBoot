package com.f_rafael.pacientes_servicio.exception;

public class CampoNuloException extends RuntimeException{

    public CampoNuloException(String mensaje){
        super(mensaje);
    }
}
