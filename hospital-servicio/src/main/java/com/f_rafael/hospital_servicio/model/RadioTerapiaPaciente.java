package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "radioterapia_paciente")
public class RadioTerapiaPaciente {
    private Long id;
    @Column(name = "paciente_id",nullable = false)
    private Long pacienteId;
    private LocalDate inicio;
    private LocalDate fin;
}
