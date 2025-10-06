package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "motivos_turno")
public class MotivoTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Motivo motivo;
    @Column(name = "cita_o_estudio")
    private String citaOEstudio;
}
