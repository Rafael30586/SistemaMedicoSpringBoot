package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turnos")
@Getter @Setter
public class Turno {
    @Id
    private Long id;
    @Column(name = "fecha_horario_solicitud",nullable = false)
    private LocalDateTime fechaHorarioSolicitud;
    @Column(name = "fecha_horario_turno",nullable = false)
    private LocalDateTime fechaHorarioTurno;
}
