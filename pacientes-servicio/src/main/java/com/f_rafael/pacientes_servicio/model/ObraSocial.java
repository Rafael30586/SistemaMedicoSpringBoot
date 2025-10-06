package com.f_rafael.pacientes_servicio.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Set<Sede> sedeId; // Sede
}
