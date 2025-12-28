package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("cita")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TurnoCita extends Turno{
    @Column(name = "profesional_id")
    private Long profesionalId;
}
