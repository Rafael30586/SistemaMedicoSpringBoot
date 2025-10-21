package com.f_rafael.hospital_servicio.dto;

import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CirugiaPacienteDto {
    private Long id;
    private PacienteDto paciente;
    private TratamientoQuirurgico cirugia;
    private LocalDate fecha;
    private LocalTime inicio;
    private LocalTime fin;
}
