package com.f_rafael.hospital_servicio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "psicopterapia_paciente")
public class PsicoterapiaPaciente { // Un tratamiento de psicoterapia en un paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "paciente_id", nullable = false)
    private Long pacienteId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate inicio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fin;
}
