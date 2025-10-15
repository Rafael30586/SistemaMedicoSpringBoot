package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "turnos")
// @MappedSuperclass Esta anotación provoca, entre otras cosas, que la clase no tenga su propia tabla. No conviene usarla en este caso
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "tipo")
public class Turno {
    @Id
    protected Long id;
    @ManyToOne
    protected Paciente paciente;
    @Column(name = "fecha_solicitud",nullable = false)
    protected LocalDate fechaSolicitud;
    @Column(name = "fecha_turno",nullable = false)
    protected LocalDate fechaTurno;
    protected LocalTime inicio;
    protected LocalTime fin;
    @Enumerated(EnumType.STRING)
    protected EstadoTurno estado;
    @Enumerated(EnumType.STRING)
    protected Cobertura cobertura;
}
