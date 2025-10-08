package com.f_rafael.pacientes_servicio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DireccionDto {
    private Long id;
    private String calle;
    private Integer altura;
    private String departamento;
    private LocalidadDto localidad;
}
