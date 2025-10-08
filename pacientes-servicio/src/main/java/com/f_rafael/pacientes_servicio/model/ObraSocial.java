package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class ObraSocial {

    private Long id;
    private String nombre;
    @OneToMany
    private Set<Sede> sedes; // Sede
}
