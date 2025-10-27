package com.f_rafael.hospital_servicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PsicoterapiaPacienteDto {
    private Long id;
    private PacienteDto paciente;
    private LocalDate inicio;
    private LocalDate fin;
}
