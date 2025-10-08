package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Table(name = "diagnostico_paciente")
public class DiagnosticoPaciente { // Un diagnóstico que se le da  a un paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pacienteId;
    @ManyToOne
    @JoinColumn(name = "diagnostico_id", nullable = false)
    private Diagnostico diagnostico;
    @Column(nullable = false)
    private LocalDate inicio;
    private LocalDate fin;
}
