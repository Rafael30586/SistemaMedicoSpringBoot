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
@Entity
@Getter @Setter
@Table(name = "fisioterapia_paciente")
public class FisioterapiaPaciente { // Un tratamiento de fisioterapia realizado en un paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "paciente_id")
    private Long pacienteId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate inicio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fin;
}
