package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoPacienteDto {
    private Long id;
    private PacienteDto paciente;
}
