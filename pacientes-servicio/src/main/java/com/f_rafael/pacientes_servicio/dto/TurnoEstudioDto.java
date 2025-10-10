package com.f_rafael.pacientes_servicio.dto;

import com.f_rafael.pacientes_servicio.model.EstadoTurno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class TurnoEstudioDto {
    private Long id;
    private SubPacienteDto paciente;
    private LocalDate fechaSolicitud;
    private LocalDate fechaTurno;
    private LocalTime inicio;
    private LocalTime fin;
    private EstadoTurno estado;
    private EstudioDto estudio;
}
