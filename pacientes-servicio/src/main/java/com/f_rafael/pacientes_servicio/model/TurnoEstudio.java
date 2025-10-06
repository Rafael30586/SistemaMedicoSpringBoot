package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@DiscriminatorValue("estudio")
public class TurnoEstudio extends Turno{
    @Column(name = "estudio_id")
    private Long estudioId;
}
