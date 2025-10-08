package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sectores")
@Getter @Setter
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre; // Ejemplos: medicina, limpieza, gastronomia, recursos humanos, etc
}
