package com.f_rafael.hospital_servicio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class FisioterapiaPacienteDto {
    private Long id;
    private PacienteDto paciente;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate inicio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fin;
}
