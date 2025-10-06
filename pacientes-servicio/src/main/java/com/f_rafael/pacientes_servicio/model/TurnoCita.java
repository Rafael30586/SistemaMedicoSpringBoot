package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "turnos_citas")
@DiscriminatorValue("cita")
public class TurnoCita extends Turno{

    @Column(name = "profesional_id")
    private Long profesionalId;
}
