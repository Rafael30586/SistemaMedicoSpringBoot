package com.f_rafael.pacientes_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraSocialDto {
    private Long id;
    private String nombre;
    private Set<SedeDto> sedes;
    private Set<SubPacienteDto> pacientes;
}
