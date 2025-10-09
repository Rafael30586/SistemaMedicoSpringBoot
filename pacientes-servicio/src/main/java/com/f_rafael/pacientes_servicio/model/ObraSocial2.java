package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "obras_sociales")
public class ObraSocial2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Sede> sedes;
    @OneToMany(mappedBy = "obraSocial", fetch = FetchType.LAZY)
    private Set<Paciente> pacientes;
}
