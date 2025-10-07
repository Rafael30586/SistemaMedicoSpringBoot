package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Table(name = "diagnosticos_pacientes")
public class DiagnosticoPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "paciente_id")
    private Long pacienteId;
    @Column(name = "diagnostico_id")
    private Long diagnosticoId;
    private LocalDate inicio;
    private LocalDate fin;
}
