package com.f_rafael.hospital_servicio.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ObjetoDeError {
    @JsonProperty("código_de_estado")
    private Integer codigoDeEstado;
    private String mensaje;
    @JsonProperty("marca_de_tiempo")
    private LocalDateTime marcaDeTiempo;
}
