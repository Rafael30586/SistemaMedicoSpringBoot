package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@DiscriminatorValue("estudio")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoEstudio extends Turno{
    @Column(name = "estudio_id")
    private Long estudioId;
}
