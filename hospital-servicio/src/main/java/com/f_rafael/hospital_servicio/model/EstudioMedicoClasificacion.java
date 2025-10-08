package com.f_rafael.hospital_servicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "estudios_medicos_clasificaciones")
public class EstudioMedicoClasificacion { // Clasificación de un estudio médico, ejemplos: examen de laboratorio, estudios de imagen ,etc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
