package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diagnosticos")
@Setter @Getter
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "diagnosticos_sintomas",
            joinColumns = @JoinColumn(name = "diagnostico_id"),
            inverseJoinColumns = @JoinColumn(name = "sintoma_id")
    )
    private Set<Sintoma> sintomas;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "diagnosticos_signos",
            joinColumns = @JoinColumn(name = "diagnostico_id"),
            inverseJoinColumns = @JoinColumn(name = "signo_id")
    )
    private Set<Signo> signos;
}
