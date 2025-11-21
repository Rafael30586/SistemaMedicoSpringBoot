package com.f_rafael.farmacia_servicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ManejadorGlobalDeExcepciones {

    @ExceptionHandler(EntidadNoEncontradaException.class)
    public ResponseEntity<ObjetoDeError> controlarEntidadNoEncontradaException(EntidadNoEncontradaException excepcion){
        ObjetoDeError objetoDeError = new ObjetoDeError();

        objetoDeError.setCodigoDeEstado(HttpStatus.NOT_FOUND.value());
        objetoDeError.setMensaje(excepcion.getMessage());
        objetoDeError.setMarcaDeTiempo(LocalDateTime.now());

        return new ResponseEntity<>(objetoDeError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CampoNuloException.class)
    public ResponseEntity<ObjetoDeError> controlarIdNuloException(CampoNuloException excepcion){
        ObjetoDeError objetoDeError = new ObjetoDeError();

        objetoDeError.setCodigoDeEstado(HttpStatus.BAD_REQUEST.value());
        objetoDeError.setMensaje(excepcion.getMessage());
        objetoDeError.setMarcaDeTiempo(LocalDateTime.now());

        return new ResponseEntity<>(objetoDeError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DatoIncorrectoException.class)
    public ResponseEntity<ObjetoDeError> controlarDatoIncorrectoException(DatoIncorrectoException excepcion){
        ObjetoDeError objetoDeError = new ObjetoDeError();

        objetoDeError.setCodigoDeEstado(HttpStatus.BAD_REQUEST.value());
        objetoDeError.setMensaje(excepcion.getMessage());
        objetoDeError.setMarcaDeTiempo(LocalDateTime.now());

        return new ResponseEntity<>(objetoDeError, HttpStatus.BAD_REQUEST);
    }
}
