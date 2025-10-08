package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Table(name = "sintomas")
public class Sintoma { // Sensaciones subjetivas del paciente, ejemplo: dolor de cabeza
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "sintomas")
    private Set<Diagnostico> diagnosticos;
}
