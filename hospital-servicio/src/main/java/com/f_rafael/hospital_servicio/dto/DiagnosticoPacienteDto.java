package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoPacienteDto {
    private Long id;
    private PacienteDto paciente;
    private String diagnostico;
    private LocalDate inicio;
    private LocalDate fin;
}
