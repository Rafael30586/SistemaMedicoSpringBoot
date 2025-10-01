package com.f_rafael.farmacia_servicio.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoDeError {
    @JsonProperty("código de estado")
    private Integer codigoDeEstado;
    private String mensaje;
    @JsonProperty("marca de tiempo")
    private LocalDateTime marcaDeTiempo;

}
