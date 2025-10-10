package com.f_rafael.pacientes_servicio.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoDeError { // ¿Podría agregar un campo llamado id que siempre resulte en -1 para que lo mapee a la entidad del otro microservicio?
    @JsonProperty("código_de_estado")
    private Integer codigoDeEstado;
    private String mensaje;
    @JsonProperty("marca_de_tiempo")
    private LocalDateTime marcaDeTiempo;
}
