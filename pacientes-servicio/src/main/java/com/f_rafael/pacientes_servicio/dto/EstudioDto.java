package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudioDto {
    private Long id;
    private String nombre;
    private EstudioMedicoClasificacionDto clasificacion;
}
