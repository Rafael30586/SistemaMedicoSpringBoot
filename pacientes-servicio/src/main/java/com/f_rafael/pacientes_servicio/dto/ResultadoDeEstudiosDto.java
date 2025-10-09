package com.f_rafael.pacientes_servicio.dto;

import com.f_rafael.pacientes_servicio.model.Cobertura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ResultadoDeEstudiosDto {
    private Long numero;
    private SubPacienteDto paciente;
    private Cobertura cobertura;
    private List<EstudioDto> estudios;
    private String urlInforme;
}
